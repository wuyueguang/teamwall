package rocky.teamwall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import rocky.teamwall.entity.Tag;

/**
 * Tag DAO
 * @author wuyg 2016-6-29
 *
 */
public interface TagDAO {
	
	/**
	 * 插入某个用户下的标签
	 * @param uid
	 * @param tag
	 * @return
	 * 返回插入的行数
	 */
	//由于java没有保存形参的记录，需通过@Param注解，告诉mybatis多个参数的名称
	int insertTag(@Param("uid") String uid, @Param("tag") String tag);
	

	/**
	 * 根据用户编号查询所有的标签
	 * @param uid
	 * @return
	 * 返回标签列表
	 */
	List<Tag> queryByUid(String uid);
	
}
