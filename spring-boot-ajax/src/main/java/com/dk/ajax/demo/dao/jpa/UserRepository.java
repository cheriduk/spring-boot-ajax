package com.dk.ajax.demo.dao.jpa;

import com.dk.ajax.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cheri
 * @title: UserRepository
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2121:03
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
