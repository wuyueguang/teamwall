package rocky.teamwall.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rocky.teamwall.entity.Tag;


//junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})

public class TagServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TagService tagService;
	
	@Test
	public void testGetTagList() {
		String uid = "123";
		List<Tag> tags = tagService.getTagList(uid);
		logger.info("tags={}", tags);
	}
	
	@Test
	public void testAddTag() {
		String uid = "888";
		String tag = "yes";
		int count = tagService.addTag(uid, tag);
		logger.info("count={}", count);
	}

}
