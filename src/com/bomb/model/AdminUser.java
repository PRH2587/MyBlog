package com.bomb.model;

import com.bomb.base.StringUtil;

public class AdminUser {
    private String id =StringUtil.createUUID();;

    private String adminname;

    private String password;

    private Integer permission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", adminname=" + adminname + ", password=" + password + ", permission="
				+ permission + "]";
	}
    
    
}