package com.lixy.dev.base.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixy.dev.base.dao.UserDao;
import com.lixy.dev.base.dao.UserJpaDao;
import com.lixy.dev.base.model.User;
import com.lixy.dev.base.service.UserService;

/**
 * 
 * @ClassName UserServiceImpl
 * @author abel
 * @date 2016年11月10日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserJpaDao userJpaDao;

	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<User> getList(Map<String, Object> map) {
		return userDao.getList(map);
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public User getUserByName(String name) {
		return userJpaDao.findByName(name);
	}

	@Override
	public void saveUser(User user) {
		userJpaDao.save(user);
	}


}
