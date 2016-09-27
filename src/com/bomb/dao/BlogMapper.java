package com.bomb.dao;

import com.bomb.model.Blog;
import com.bomb.model.BlogExample;
import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(String id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
    
    List<Blog> getidByAdminBlogs(String permission);
    
    Integer selectCountByExample(BlogExample example);
}