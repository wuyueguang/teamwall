package rocky.teamwall.service;

import java.util.List;

import rocky.teamwall.entity.Tag;


public interface TagService {

	/**
	 * 根据uid获取所有的tag
	 * @return
	 */
	List<Tag> getTagList(String uid);
	
	/**
	 * 给用户添加tag
	 * @return
	 */
	int addTag(String uid, String tag);
}
