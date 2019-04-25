package com.dk.ajax.demo.service.jpa.impl;

import com.dk.ajax.demo.dao.jpa.UserRepository;
import com.dk.ajax.demo.model.User;
import com.dk.ajax.demo.service.jpa.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cheri
 * @title: JpaUserService
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2121:20
 */
@Service
public class JpaUserServiceImpl implements JpaUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User insertuser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public User getuser(Integer id){
        User user = userRepository.findById(id).get();
        return user;
    }

    /**
     * 获取所有用户列表
     * @return
     */
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    /**
     * 获取分页的用户
     * @return
     */
    @Override
    public Page<User> getPageUserList() {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(0,5,sort);
        return userRepository.findAll(pageable);
    }

}
