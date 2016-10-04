package com.bomb.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bomb.base.StringUtil;
import com.bomb.base.page.Page;
import com.bomb.dao.BlogMapper;
import com.bomb.model.Blog;
import com.bomb.model.BlogExample;
import com.bomb.model.BlogExample.Criteria;
import com.bomb.service.BlogService;

@Service
public class BlogServiceimpl implements BlogService {

	@Autowired
	BlogMapper blogmapper;

	/*
	 * ͬConroller ֻ����һ����
	 * 
	 * @Override
	public List<Blog> list(Blog condition) {
		BlogExample blogex = new BlogExample();
		Criteria criteria = blogex.createCriteria();
		if (condition != null && StringUtil.notEmpty(condition.getTitle())) {
			criteria.andTitleLike(condition.getTitle());
		}

		return blogmapper.selectByExample(blogex);
	}*/

	@Override
	public Blog info(String id) {

		return blogmapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(String id) {
		blogmapper.deleteByPrimaryKey(id);

	}

	@Override
	public void addBlog(Blog bloginfo) {
		blogmapper.insert(bloginfo);

	}

	

	@Override
	public Integer count(Blog bloginfo) {
		BlogExample example = new BlogExample();
		Criteria criteria = example.createCriteria();
		if (bloginfo != null && StringUtil.notEmpty(bloginfo.getPermission())) {
			criteria.andPermissionLike(bloginfo.getPermission());
		}
		return blogmapper.selectCountByExample(example);
	}

	@Override
	public List<Blog> list2(String permission, Page page) {
		BlogExample blogex = new BlogExample();
		Criteria criteria = blogex.createCriteria();
		if (permission != null) {
			criteria.andPermissionLike(permission);
		}
		if (page != null) {
			blogex.setPage(page);
		}
		return blogmapper.getidByAdminBlogs(permission);
	}

	@Override
	public Blog BlogAndMesinfo(String id) {
		// TODO Auto-generated method stub
		return blogmapper.selectBlogmessages(id);
	}

	@Override
	public void update(Blog bloginfo) {
		bloginfo.setAdminname(bloginfo.getAdminname());
		bloginfo.setCreatetime(bloginfo.getCreatetime());
		blogmapper.updateByPrimaryKey(bloginfo);
		
	}
}
