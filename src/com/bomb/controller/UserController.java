package com.bomb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bomb.dto.BlogView;
import com.bomb.model.User;
import com.bomb.service.UserService;


@SessionAttributes("sessionuser")
@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	UserService userservice;

	/*@RequestMapping("/login")
	public String login(User u, ModelMap model) {
		logger.info("前台输入用户-->>" + u);
		String username = u.getName();
		List<User> list = userservice.infoByName(username);
		if (list == null || list.size() < 1) {
			return "bomb/login";
		} else {
			if (list.get(0).getPassword().equals(u.getPassword())) {
				model.addAttribute("sessionuser", list.get(0));
				return "bomb/index";
			} else {
				return "bomb/register";
			}
		}

	}*/
	
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("userview") BlogView userview, Model modle) {
		logger.info("获取登陆用户-->>"+userview);
		String username = userview.getUserinfo().getName();
		List<User> list = userservice.infoByName(username);
		if (list == null || list.size() < 1) {
			return "bomb/login";
		} else {
			if (list.get(0).getPassword().equals(userview.getUserinfo().getPassword())) {
				modle.addAttribute("sessionuser", list.get(0));
				return "bomb/index2";
			} else {
				return "bomb/register";
			}
		}
	}
	
	@RequestMapping("/loginout")
	public String loginout() {
		
		return "bomb/index2";
	}
	
	@RequestMapping("/gologin")
	public String gologin() {

		return "bomb/login";
	}

	@RequestMapping("/goregister")
	public String goregister() {

		return "bomb/register";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute BlogView view, Model modle) {
		logger.info("注册-->>"+view.getUserinfo());
		userservice.save(view.getUserinfo());
		return "bomb/login";
	}

}
