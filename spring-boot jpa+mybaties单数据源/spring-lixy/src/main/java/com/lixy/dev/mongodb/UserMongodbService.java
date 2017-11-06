package com.lixy.dev.mongodb;

import com.lixy.dev.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*@Service
@EnableMongoRepositories(basePackages="com.lixy.dev.mongodb" ) //扫描指定目录下面的MongoRepositories接口*/
public class UserMongodbService {

    @Autowired
    private UserMongodbRepository userMongodbDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("save")
    public  String save(){
        User sysUser = new User();
        sysUser.setId(7);
        sysUser.setName("张三");
        sysUser.setPassword("123456");
        sysUser.setUsername("hhh");
        userMongodbDao.save(sysUser);
        return "ok";
    }

//    @RequestMapping("find")
    public List find(){
        return userMongodbDao.findAll();
    }
//
//    @RequestMapping("findByName")
    public User findByName(){
        return userMongodbDao.findByName("张三");
    }

    /**
     * mongoTemplate
     * @param id
     * @return
     */
    public User findById(Object id) {
        return mongoTemplate.findById(id, User.class);
    }
}