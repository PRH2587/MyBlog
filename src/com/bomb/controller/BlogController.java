package com.bomb.controller;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bomb.base.page.Page;
import com.bomb.dto.BlogView;
import com.bomb.model.Blog;
import com.bomb.model.UserMessage;
import com.bomb.service.BlogService;
import com.bomb.service.UserMessageService;

@Controller
@RequestMapping("/bomb")
public class BlogController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	BlogService blogservice;
	
	@Autowired
	UserMessageService userMessageService;

	/*
	 * 
	 * 此方法不包含AdminUser类，只list Blog类
	 * 
	 * @RequestMapping("/index") public String index(@ModelAttribute("view")
	 * BlogView view, Model model) { logger.info("list index-->" + view); if
	 * (view != null) { view = new BlogView(); } if (view.getBloginfo() != null)
	 * { view.setBloginfo(new Blog()); } List<Blog> list =
	 * blogservice.list(view.getBloginfo()); view.setList(list);
	 * model.addAttribute("view", view); return "bomb/index"; }
	 */

	@RequestMapping("/index")
	public String index(@ModelAttribute("view") BlogView view, Model model) {
		logger.info("list index-->" + view);
		if (view != null) {
			view = new BlogView();
		}
		if (view.getBloginfo() != null) {
			view.setBloginfo(new Blog());
		}
		if (view.getPage() == null) {
			Page page = new Page();
			page.setPageNo(1);
			view.setPage(page);
		}
		Integer total = blogservice.count(view.getBloginfo());
		view.getPage().cal(total);
		List<Blog> list = blogservice.list2("SLZQLT9UFSR6Z1S18JAR0NHLCFAO7PL4", view.getPage());
		view.setList(list);
		model.addAttribute("view", view);
		return "bomb/index2";
	}

	@RequestMapping("/contact")
	public String contact() {

		return "bomb/contact";
	}

	
	@RequestMapping("/single")
	public String single(@ModelAttribute BlogView view, Model model) {
		logger.info("Input BlogView [view] -> " + view);
		if (view.getBloginfo() != null && view.getBloginfo().getId() != null && view.getBloginfo().getId() != "") {
			Blog bloginfo = blogservice.BlogAndMesinfo(view.getBloginfo().getId());
			UserMessage userMes = userMessageService.findUsername(2);
			System.out.println("userid是2的评论数--》》"+userMes.getUsername().getNickname());	
			view.setBloginfo(bloginfo);
		}
		model.addAttribute("view", view);
		return "bomb/single";
	}

	@RequestMapping("/update")
	public String update() {
		return "";
	}

	@RequestMapping("/write")
	public String write() {

		return "bomb/write";
	}

	@RequestMapping("/addWrite")
	public String goWrite(@ModelAttribute BlogView view, Model model) {
		logger.info("Input [add bloginfo]" + view);

		if (view.getBloginfo() != null) {
			Date time = new Date();
			view.getBloginfo().setCreatetime(time);
			view.getBloginfo().setBlogId(1);
			view.getBloginfo().setPermission("SLZQLT9UFSR6Z1S18JAR0NHLCFAO7PL4");
			view.getBloginfo().setAdminname(view.getBloginfo().getAdminname());
			blogservice.addBlog(view.getBloginfo());
		}

		return index(view, model);
	}

}
