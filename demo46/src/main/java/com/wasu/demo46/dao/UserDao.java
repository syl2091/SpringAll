package com.wasu.demo46.dao;

import com.wasu.demo46.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends ReactiveMongoRepository<User,String> {
}
