package com.hgx.common.service.impl;
import java.util.List;

import com.hgx.common.dao.UserDao;
import com.hgx.common.service.UserService;
import com.hgx.common.utils.Assist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hgx.common.entity.User;
/**
 * User的服务接口的实现类
 * @author
 */
@Service
public class UserServiceImpl implements UserService {

	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getList(User user) {
		return userDao.selectUser(null);
	}
	@Override
	public User getUserById(Integer id) {
		return userDao.selectUserById(id);
	}

	@Override
	public String saveNotNull(User user) {
		if (user == null) {
			return Assist.resultFormat(Assist.C500, "user不能为null");
		}
		if(user.getUsername() == null  ){
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = userDao.insertNotNullUser(user);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String updateNotNullById(User user) {
		if (user == null) {
			return Assist.resultFormat( Assist.C500, null);
		}
		int result = userDao.updateNotNullUserById(user);
		return Assist.resultFormat(Assist.C200, result);
	}

	@Override
	public String deleteById(Integer id) {
		if (id == null) {
			return Assist.resultFormat(Assist.C500, null);
		}
		int result = userDao.deleteUserById(id);
		return Assist.resultFormat(Assist.C200, result);
	}


}