package com.dk.ajax.demo.service.jpa;

import com.dk.ajax.demo.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Cheri
 * @title: JpaUserService
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2121:27
 */
public interface JpaUserService {

    public User insertuser(User user);

    public User getuser(Integer id);

    List<User> getUserList();

    public Page<User> getPageUserList();
}
