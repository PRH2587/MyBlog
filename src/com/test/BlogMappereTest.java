package com.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bomb.dao.BlogMapper;
import com.bomb.model.Blog;
import com.bomb.service.BlogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:config/spring-dao.xml", "classpath:config/spring-service.xml" })
public class BlogMappereTest {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	BlogMapper blogmapper;
	
	@Autowired
	BlogService blogser;
	
	@Test
	public void for_() {
		for(int i=0;i<10;i++){
			insert();
		}

	}

	@Test
	public void insert() {
		Blog blog = new Blog();

		Date d = new Date();
		blog.setCreatetime(d);

		blog.setTitle("Java基本语法");
		blog.setContent(
				"J大小写敏感：Java是大小写敏感的，这就意味着标识符Hello与hello是不同的。 类名：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如MyFirstJavaClass。 方法名：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写，例如myFirstJavaMethod。 源文件名：源文件名必须和类名相同。"
						+ "当保存文件的时候，你应该使用类名作为文件名保存（切记Java是大小写敏感的），文件名的后缀为.java。（如果文件名和类名不相同则会导致编译错误）。 主方法入口：所有的Java程序由public static void main（String[] args）方法开始执行。");
		blog.setImageFullPath("images/img03.jpg");
		blog.setCreatetime(d);

		blogmapper.insert(blog);

		logger.info(blog);

	}
	@Test
	public void getBlogbyid(){
		String id = "ULOBY6XKN6VVJ5IQY9R3VI39J7N4QIAP";
		Blog b = blogser.info(id);
		System.out.println(b);
	}
	
	@Test
	public void getidByAdminBlogs(){
		String id = "SLZQLT9UFSR6Z1S18JAR0NHLCFAO7PL4";
		List<Blog> b = blogmapper.getidByAdminBlogs(id);
		for(int i=0;i<b.size();i++){
			System.out.println(b.get(i));
		}
	}
	
	@Test
	public void delet(){
		String id = "SP72KRKK5ZRA4HACK6TUK6Z8V9H3XPJR";
		
		blogmapper.deleteByPrimaryKey(id);
	}

}
