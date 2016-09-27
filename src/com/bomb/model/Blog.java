package com.bomb.model;

import java.util.Date;

import com.bomb.base.StringUtil;

public class Blog {
	private String id = StringUtil.createUUID();

	private String title;

	private String content;

	private String imageFullPath;

	private Date createtime;

	private AdminUser adminname;

	private String permission;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public AdminUser getAdminname() {
		return adminname;
	}

	public void setAdminname(AdminUser adminname) {
		this.adminname = adminname;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", imageFullPath=" + imageFullPath
				+ ", createtime=" + createtime + ", adminname=" + adminname + ", permission=" + permission + "]";
	}

    

	
}