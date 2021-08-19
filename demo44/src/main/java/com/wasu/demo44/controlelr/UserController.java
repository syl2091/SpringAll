package com.wasu.demo44.controlelr;

import com.wasu.demo44.entity.User;
import com.wasu.demo44.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:Controller
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/19 13:57
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id,User user){
        userService.updateUser(id,user);
    }

    /**
     * 根据用户id查找不存在返回null
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id).orElse(null);
    }

    /**
     * 多条件查询
     * @param from
     * @param to
     * @return
     */
    @GetMapping("/{from}/{to}")
    public List<User> findByAgeBetween(@PathVariable Integer from ,@PathVariable Integer to){
        return userService.findByAgeBetween(from, to);
    }


    @GetMapping("/condition")
    public Page<User> getUserByCondition(int size,int page,User user){
        return userService.getUserByCondition(size, page, user);
    }



}
