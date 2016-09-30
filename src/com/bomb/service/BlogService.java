package com.bomb.service;

import java.util.List;

import com.bomb.base.page.Page;
import com.bomb.model.Blog;

public interface BlogService {

	//public List<Blog> list(Blog condition);
	
	public List<Blog> list2(String permission,Page page);

	public Blog info(String id);
	
	public Blog BlogAndMesinfo(String id);

	public void update(String id);

	public void delete(String id);

	public void addBlog(Blog bloginfo);
	
	public Integer count(Blog bloginfo);
}
