package com.bomb.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bomb.dao.UserMapper;
import com.bomb.model.User;
import com.bomb.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserMapper usermapper;

	@Override
	public void save(User record) {
		usermapper.insert(record);
	}

	@Override
	public List<User> infoByName(String userinfo) {
		// TODO Auto-generated method stub
		return usermapper.selectByName(userinfo);
	}

	
}
