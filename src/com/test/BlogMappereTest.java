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

		blog.setTitle("Java�����﷨");
		blog.setContent(
				"J��Сд���У�Java�Ǵ�Сд���еģ������ζ�ű�ʶ��Hello��hello�ǲ�ͬ�ġ� �������������е�����˵������������ĸӦ�ô�д��������������ɵ�����ɣ���ôÿ�����ʵ�����ĸӦ�ô�д������MyFirstJavaClass�� �����������еķ�������Ӧ����Сд��ĸ��ͷ������������������ɵ��ʣ�������ÿ����������ĸ��д������myFirstJavaMethod�� Դ�ļ�����Դ�ļ��������������ͬ��"
						+ "�������ļ���ʱ����Ӧ��ʹ��������Ϊ�ļ������棨�м�Java�Ǵ�Сд���еģ����ļ����ĺ�׺Ϊ.java��������ļ�������������ͬ��ᵼ�±�����󣩡� ��������ڣ����е�Java������public static void main��String[] args��������ʼִ�С�");
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
		String id = "J0SIV8ISEK94I1DMBAXBJU5O1GVWTWB7";
		
		blogmapper.deleteByPrimaryKey(id);
	}
	
	@Test
	public void selectBlogAndM(){
		String id = "A5Z1ZYLI8S38HJ0GS1FIG4ZFN7QCB119";
		Blog bm = blogmapper.selectBlogmessages(id);
		logger.info("Blogӵ�е�������"+bm.getListMessages().size());
		
	}

}
