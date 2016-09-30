package com.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bomb.dao.UserMessageMapper;
import com.bomb.model.UserMessage;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:config/spring-dao.xml", "classpath:config/spring-service.xml" })
public class UserMessageTest {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	UserMessageMapper userMessageMapper;
	
	@Test
	public void insertto(){
		for(int i=0;i<10;i++){
			insert();
		}
	}
	
	@Test
	public void insert() {
		UserMessage um = new UserMessage();
		um.setBlogId(1);
		um.setMessage("楼上说的对！");
		Date d = new Date();
		um.setTime(d);
		um.setUserId(1);
		um.setImagePath("/MyBlog/images/12.jpg");
		userMessageMapper.insert(um);
		logger.info("Mapper 插入"+um);
		

	}
	
	@Test
	public void findUsername(){
		int id = 2;
		UserMessage ums=userMessageMapper.getMesUserNameByUser(id);
		
		logger.info("getUsername-->>"+ums);
		
		}

}
