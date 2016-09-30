package com.bomb.model;

import java.util.Date;

import com.bomb.base.StringUtil;

public class UserMessage {
	private String id = StringUtil.createUUID();
	
	private User username;

	private String imagePath;

	private String message;

	private Date time;

	private Integer blogId;

	private Integer userId;
	
	

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserMessage [id=" + id + ", username=" + username + ", imagePath=" + imagePath + ", message=" + message
				+ ", time=" + time + ", blogId=" + blogId + ", userId=" + userId + "]";
	}

	

}