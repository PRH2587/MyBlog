package com.bomb.dto;

import java.util.List;

import com.bomb.base.page.Page;
import com.bomb.model.Blog;
import com.bomb.model.User;
import com.bomb.model.UserMessage;

public class MessageView {
	private Blog blogSingleinfo;

	private User userSingleinfo;

	private List<UserMessage> listm;

	private Page page;

	public Blog getBlogSingleinfo() {
		return blogSingleinfo;
	}

	public void setBlogSingleinfo(Blog blogSingleinfo) {
		this.blogSingleinfo = blogSingleinfo;
	}

	public User getUserSingleinfo() {
		return userSingleinfo;
	}

	public void setUserSingleinfo(User userSingleinfo) {
		this.userSingleinfo = userSingleinfo;
	}

	public List<UserMessage> getListm() {
		return listm;
	}

	public void setListm(List<UserMessage> listm) {
		this.listm = listm;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "MessageView [blogSingleinfo=" + blogSingleinfo + ", userSingleinfo=" + userSingleinfo + ", listm="
				+ listm + ", page=" + page + "]";
	}

}
