package com.wasu.demo44.dao;

import com.wasu.demo44.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User,String> {

    List<User> findByAgeBetween(Integer from,Integer to);
    List<User> findByAgeBetweenAndNameEqualsAndDescriptionIsLike(Integer from,Integer to,String name,String description);

}
