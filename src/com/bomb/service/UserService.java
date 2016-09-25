package com.bomb.service;

import java.util.List;

import com.bomb.model.User;

public interface UserService {

	public void save(User record);
	
	public List<User> infoByName(String userinfo);
    
}
