package com.lixy.dev.mongodb;

import com.lixy.dev.base.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/30.
 */
@Component
public interface UserMongodbRepository extends MongoRepository<User,Long> {

    User findByName(String name); //自定义的方法

}
