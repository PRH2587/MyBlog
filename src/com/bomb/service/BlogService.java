package com.bomb.service;

import java.util.List;

import com.bomb.model.Blog;


public interface BlogService {
	
	public List<Blog> list(Blog condition);
	
	public Blog info(String  id);
	
	public void update(String  id);
	
	public void delete(String  id);
	
	public void addBlog(String  id);
}
