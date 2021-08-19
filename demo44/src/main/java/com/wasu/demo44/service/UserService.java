package com.wasu.demo44.service;

import com.wasu.demo44.dao.UserDao;
import com.wasu.demo44.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName:UserService
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 13:50
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUsers() {
        return userDao.findAll();
    }


    public Optional<User> getUser(String id) {
        return userDao.findById(id);
    }

    /**
     * 新增和修改都是save  id为存在为修改  id不存在为新增
     *
     * @param user
     * @return
     */
    public User createUser(User user) {
        user.setId(null);
        return userDao.save(user);
    }

    public void deleteUser(String id) {
        userDao.findById(id).ifPresent(user -> userDao.delete(user));
    }


    public void updateUser(String id, User user) {
        userDao.findById(id).ifPresent(u -> {
            u.setName(user.getName());
            u.setAge(user.getAge());
            u.setDescription(user.getDescription());
            userDao.save(u);
        });
    }

    /**
     * 多条件查询
     * @param from
     * @param to
     * @return
     */
    public List<User> findByAgeBetween(Integer from,Integer to){
        return userDao.findByAgeBetween(from, to);
    }


    /**
     * 排序与分页
     * @param size
     * @param page
     * @param user
     * @return
     */
    public Page<User> getUserByCondition(int size,int page,User user){
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (!StringUtils.isEmpty(user.getName())) {
            criteria.and("name").is(user.getName());
        }
        if (!StringUtils.isEmpty(user.getDescription())) {
            criteria.and("description").regex(user.getDescription());
        }
        query.addCriteria(criteria);
        Sort sort = Sort.by(Sort.Direction.DESC, "age");
        Pageable pageable = PageRequest.of(page, size, sort);
        List<User> users = mongoTemplate.find(query.with(pageable),User.class);
        return PageableExecutionUtils.getPage(users, pageable, () -> mongoTemplate.count(query, User.class));
    }
}

