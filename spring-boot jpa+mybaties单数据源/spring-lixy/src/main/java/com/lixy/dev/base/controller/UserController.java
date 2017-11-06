package com.lixy.dev.base.controller;

import com.lixy.dev.base.model.User;
import com.lixy.dev.base.service.UserService;
import com.lixy.dev.base.util.CommonUtil;
import com.lixy.dev.mongodb.UserMongodbService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName UserController
 * @author abel
 * @date 2016年11月10日
 */
@Import(UserMongodbService.class )
@Controller
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/***
	 * api :localhost:8099/users?id=99 
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<User> list(HttpServletRequest request) {
		logger.error("测试日志");
		Map<String, Object> map = CommonUtil.getParameterMap(request);
		return userService.getList(map);
	}

	/**
	 * 通过spring data jpa 调用方法
	 * api :localhost:8099/users/byname?username=xxx
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/byname", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(HttpServletRequest request) {
		Map<String, Object> map = CommonUtil.getParameterMap(request);
		String username = (String) map.get("username");
		return userService.getUserByName(username);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public void getUser() {
		User user = new User();
		user.setName("chenjie");
		user.setPassword("123");
		user.setUsername("pass");
		userService.saveUser(user);
	}


	//===================mongodb=====================

	@Autowired
	private UserMongodbService userMongodbService;

	@RequestMapping(value ="/monSave")
	@ResponseBody
	public String mongodb(){
		userMongodbService.save();
		//db.user.find()
		User user= userMongodbService.findByName();
		return user.getName();
	}

	@RequestMapping(value ="/find")
	@ResponseBody
	public List find(){
		logger.info("mongodb find all");
		return userMongodbService.find();
	}


	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/findById")
	@ResponseBody
	public User findById(int id) {
		return userMongodbService.findById(id);
	}

	//===================mongodb=====================
}
