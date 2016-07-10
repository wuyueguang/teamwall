package rocky.teamwall.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rocky.teamwall.entity.Tag;

//junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class TagDAOTest {

	//注入dao实现依赖
	@Resource
	private TagDAO tagDAO;

	@Test
	public void testQueryByUid() {
		String uid = "123";
		List<Tag> tags = tagDAO.queryByUid(uid);
		for(Tag tag:tags){
			System.out.println(tag);
			assertEquals(uid, tag.getUid());
		}
	}
	
	@Test
	public void testInsertTag() {
		int count = tagDAO.insertTag("789", "hao");
		assertEquals(1, count);
	}
}
