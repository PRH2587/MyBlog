package com.bomb.dto;

import java.util.List;

import com.bomb.base.page.Page;
import com.bomb.model.Blog;
import com.bomb.model.User;

public class BlogView {

	private Blog bloginfo;

	private List<Blog> list;

	private User userinfo;

	private Page page;

	public Blog getBloginfo() {
		return bloginfo;
	}

	public void setBloginfo(Blog bloginfo) {
		this.bloginfo = bloginfo;
	}

	public List<Blog> getList() {
		return list;
	}

	public void setList(List<Blog> list) {
		this.list = list;
	}

	public User getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BlogView [bloginfo=" + bloginfo + ", list=" + list + ", userinfo=" + userinfo + ", page=" + page + "]";
	}

	public BlogView(Blog bloginfo, List<Blog> list, User userinfo) {
		super();
		this.bloginfo = bloginfo;
		this.list = list;
		this.userinfo = userinfo;
	}

	public BlogView() {

	}

}
