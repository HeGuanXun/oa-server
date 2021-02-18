package com.hgx.common.dao;
import java.util.List;
import com.hgx.common.utils.Assist;
import com.hgx.common.entity.User;

/**
 * User的Dao接口
 * @author
 */
public interface UserDao {

	/**
	 * 获得数据的总行数
	 */
	long getUserRowCount(Assist assist);
	
	/**
	 * 获得User数据集合
	 */
	List<User> selectUser(Assist assist);
	/**
	 * 通过User的id获得对象
	 */
	User selectUserById(Integer id);
	
	/**
	 * 获得一个User对象
	 */
	User selectUserObjSingle(User obj);
	
	/**
	 * 获得一个User对象集合
	 */
	List<User> selectUserByObj(User obj);


	/**
	 * 插入User中属性值不为null的数据到数据库
	 */
	int insertNotNullUser(User value);
	
	/**
	 * 批量插入,包括null值
	 */
	int insertUserByBatch(List<User> value);
	/**
	 * 通过id删除
	 */
	int deleteUserById(Integer id);

	/**
	 * 通过id更新属性不为null的数据
	 */
	int updateNotNullUserById(User user);
}