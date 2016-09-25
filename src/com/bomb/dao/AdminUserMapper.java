package com.bomb.dao;

import java.util.List;

import com.bomb.model.AdminUser;
import com.bomb.model.AdminUserExample;

public interface AdminUserMapper {

    List<AdminUser> selectByExample(AdminUserExample example);

    AdminUser selectByPrimaryKey(String id);

    
}