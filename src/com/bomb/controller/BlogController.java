package com.bomb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bomb.dto.BlogView;
import com.bomb.model.Blog;
import com.bomb.service.BlogService;

@Controller
@RequestMapping("/bomb")
public class BlogController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	BlogService blogservice;

	@RequestMapping("/index")
	public String index(@ModelAttribute("view") BlogView view, Model model) {
		logger.info("list index-->" + view);
		if (view != null) {
			view = new BlogView();
		}
		if (view.getBloginfo() != null) {
			view.setBloginfo(new Blog());
		}
		List<Blog> list = blogservice.list(view.getBloginfo());
		view.setList(list);
		model.addAttribute("view", view);
		return "bomb/index";
	}
	
	@RequestMapping("/contact")
	public String contact() {

		return "bomb/contact";
	}

	@RequestMapping("/single")
	public String single(@ModelAttribute BlogView view, Model model) {
		logger.info("Input BlogView [view] -> " + view);
		if (view.getBloginfo() != null && view.getBloginfo().getId() != null && view.getBloginfo().getId() != "") {
			Blog bloginfo = blogservice.info(view.getBloginfo().getId());
			view.setBloginfo(bloginfo);
		}
		System.out.println(view);
		model.addAttribute("view", view);
		return "bomb/single";
	}
	
	@RequestMapping("/update")
	 public String update(){
		return "";
	}
	
	@RequestMapping("/search")
	 public String search(){
		
		return "";
	}

}
