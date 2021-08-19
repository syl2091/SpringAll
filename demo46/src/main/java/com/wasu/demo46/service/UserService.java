package com.wasu.demo46.service;

import com.wasu.demo46.dao.UserDao;
import com.wasu.demo46.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName:User
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 16:12
 */
@Service
public class UserService  {
    @Autowired
    private UserDao userDao;

    public Flux<User> getUsers(){
        return userDao.findAll();
    }

    public Mono<User> getUser(String id){
        return userDao.findById(id);
    }

    public Mono<User> createUser(User user){
        return userDao.save(user);
    }

    public Mono<Void> deleteUser(String id){
        return userDao.findById(id).flatMap(user -> userDao.delete(user));
    }

    public Mono<User> updateUser(String id,User user){
        return userDao.findById(id).flatMap(u->{
          u.setName(user.getName());
          u.setAge(user.getAge());
          u.setDescription(user.getDescription());
          return userDao.save(u);
        });
    }


}
