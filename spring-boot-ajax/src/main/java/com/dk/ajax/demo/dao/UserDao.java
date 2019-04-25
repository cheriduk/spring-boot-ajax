package com.dk.ajax.demo.dao;

import com.dk.ajax.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Cheri
 * @title: UserDao
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2018:33
 */

@Repository
public class UserDao {

    private final static List <User> list =new ArrayList(5);

    public List<User> getAllUser(){

        User user1 = new User(1,"mary1",12);
        User user2 = new User(2,"mary2",13);
        User user3 = new User(3,"mary3",14);
        User user4 = new User(4,"mary4",15);
        User user5 = new User(5,"mary5",16);

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        //List<User> userList = new ArrayList<User>(list);
        //暂时这样处理

        return list;
    }

    public User getUserById(String id){
        return list.get(Integer.parseInt(id));
    }
}
