package com.lixy.dev;

import com.lixy.dev.base.dao.UserDao;
import com.lixy.dev.base.dao.UserJpaDao;
import com.lixy.dev.base.model.User;
import com.lixy.dev.base.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringLixyApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;
    @Autowired
	private UserDao userDao;
	@Autowired
	private UserJpaDao userJpaDao;
	@Autowired
	private UserService userService;
	@Test
	public void testInsert() {
		System.out.println("list:"+userDao.getList(new HashMap<>()));
		System.out.println("jpa:" + userJpaDao.findByName("chenjie"));
		User user = new User();
		user.setName("xix");
		user.setUsername("90");
		user.setPassword("99");
//		userDao.insertUser(user);
		userService.saveUser(user);
	/*	userJpaDao.findAll().stream()
		 					.forEach(a->{
								System.out.println("name:"+a.getName()+",password:"+a.getPassword());
							});*/
	}

}
