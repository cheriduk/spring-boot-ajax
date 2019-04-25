package com.dk.ajax.demo.controller.jpa;

import com.dk.ajax.demo.model.User;
import com.dk.ajax.demo.service.jpa.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cheri
 * @title: JpaUserController
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2121:06
 */
@RestController
@RequestMapping(value = "/jpa")
public class JpaUserController {

    @Autowired
    JpaUserService jpaUserService;


    @GetMapping("/insert")
    public User insertuser(User user){
        user = jpaUserService.insertuser(user);
        return user;
    }

    @GetMapping(value = "/user/{id}")
    public User getuser(@PathVariable("id") Integer id){
        User user =jpaUserService.getuser(id);
        return user;
    }

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return jpaUserService.getUserList();
    }

    @GetMapping(value="/getPageUserList")
    public Page<User> getPageUserList(){
        return jpaUserService.getPageUserList();
    }
}
