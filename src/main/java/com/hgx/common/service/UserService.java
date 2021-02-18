package com.hgx.common.service;
import java.util.List;
import com.hgx.common.entity.User;

/**
 * User的服务接口
 * @author
 */
public interface UserService {
	/**
	 * 获得所以数据集
	 */
	List<User> getList(User user);

	/**
	 * 获取User信息
	 */
	User getUserById(Integer id);

	/**
	 * 新增不为null的数据
	 */
	String saveNotNull(User user);

	/**
	 * 更新不为null的数据
	 */
	String updateNotNullById(User user);

	/**
	 * 删除
	 */
	String deleteById(Integer id);
}
