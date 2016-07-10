package rocky.teamwall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rocky.teamwall.dao.TagDAO;
import rocky.teamwall.entity.Tag;
import rocky.teamwall.service.TagService;

/**
 * 真正的业务逻辑尽量在Service中实现，不应该在DAO中
 */
@Service
public class TagServiceImpl implements TagService {
	
	//自动注入Service依赖
	@Autowired
	private TagDAO tagDAO;
	
	public List<Tag> getTagList(String uid) {
		return tagDAO.queryByUid(uid);
	}

	public int addTag(String uid, String tag) {
		return tagDAO.insertTag(uid, tag);
	}

}
