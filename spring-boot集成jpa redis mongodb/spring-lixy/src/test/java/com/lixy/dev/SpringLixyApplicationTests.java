package com.lixy.dev;

import com.lixy.dev.base.model.User;
import com.lixy.dev.base.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringLixyApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {

	}
	@Test
	public void testInsert() {
/*		User user = new User();
		user.setName("chenjie");
		user.setUsername("12");
		userService.saveUser(user);*/

	}

}
