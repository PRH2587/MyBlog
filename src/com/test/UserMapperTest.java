package com.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bomb.dao.UserMapper;
import com.bomb.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
public class UserMapperTest {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	UserMapper usermapper;
	
	@Test
	public void insert(){
		User user = new User();
		user.setName("≤‚ ‘”√ªß");
		user.setNickname("ceshi");
		user.setPassword("3333");
		usermapper.insert(user);
		logger.info(user);
	}
	
	

}
