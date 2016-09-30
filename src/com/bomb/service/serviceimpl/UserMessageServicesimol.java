package com.bomb.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bomb.dao.UserMessageMapper;
import com.bomb.model.UserMessage;
import com.bomb.service.UserMessageService;

@Service
public class UserMessageServicesimol implements UserMessageService{
	
	@Autowired
	UserMessageMapper userMassageMapper;

	@Override
	public UserMessage findUsername(int userid) {
		// TODO Auto-generated method stub
		return userMassageMapper.getMesUserNameByUser(userid);
	}

}
