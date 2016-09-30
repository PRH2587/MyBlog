package com.bomb.dao;

import java.util.List;
import com.bomb.model.UserMessage;
import com.bomb.model.UserMessageExample;

public interface UserMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    List<UserMessage> selectByExample(UserMessageExample example);

    UserMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
    
    UserMessage getMesUserNameByUser(int userid);
}