package com.lixy.dev.base.dao;

import com.lixy.dev.base.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
	public List<User> getList(Map<String,Object> map);
}
