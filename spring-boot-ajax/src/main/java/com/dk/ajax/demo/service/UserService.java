package com.dk.ajax.demo.service;

import com.dk.ajax.demo.dao.UserDao;
import com.dk.ajax.demo.dao.mapper.UserMapper;
import com.dk.ajax.demo.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Cheri
 * @title: UserService
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2018:28
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<User> queryAllUser(){
        return userDao.getAllUser();
    }

    public User queryUserById(String id){
        return userDao.getUserById(id);
    }


    public User findUserById(int id){
        // 从缓存中获取信息
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            System.out.println("==========从缓存中获取了用户 >>"+user);
            return user;
        }else {
            User user =userMapper.findUserById(id);
            System.out.println("==========从数据表中获得数据>>>"+user);
            // 插入缓存
            if(user!=null){
                operations.set(key, user, 30, TimeUnit.SECONDS);
            }

            return user;
        }
    }

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     * @param id
     * @return
     */
    public User queryUserById(int id){
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            long start = System.currentTimeMillis();
            User user = operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            System.out.println(user.getName());
            System.out.println("==============================");
            long end = System.currentTimeMillis();
            System.out.println("查询redis花费的时间是:" + (end - start)+"s");
            return user;
        }else{
            long start = System.currentTimeMillis();
            User user = userMapper.selectUserById(id);
            System.out.println("==========从数据表中获得数据=========");
            System.out.println(user.getName());
            System.out.println("==============================");

            // 写入缓存
            operations.set(key, user, 5, TimeUnit.HOURS);
            long end = System.currentTimeMillis();
            System.out.println("查询mysql花费的时间是:" + (end - start)+"s");
            return user;
        }
    }

    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }

    public int register(User user) {
        return userMapper.register(user);
    }

    public PageInfo findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUser();
        PageInfo<User> userList = new PageInfo<>(users);
        return userList;
    }

    public List<User> findAllUserByName(String name){
       List<User> userList = userMapper.selectAllUserByName(name);
       return userList;
    }

    public int addUser(User user){
       return userMapper.insertUser(user);
    }

    /**
     * 更新用户策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
     * @param user
     * @return
     */
    public int updateUser(User user) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        int result = userMapper.updateUser(user);
        if (result != 0) {
            String key = "user_" + user.getId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                System.out.println("删除缓存中的key=========>" + key);
            }

            // 再将更新后的数据加入缓存
            User userNew = userMapper.selectUserById(user.getId());
            if (userNew != null) {
                operations.set(key, userNew, 3, TimeUnit.HOURS);
            }
        }
        return result;
    }

    /**
     * 删除用户策略：删除数据表中数据，然后删除缓存
     * @param id
     * @return
     */
    public int deleteUserById(int id) {
        int result = userMapper.deleteUserById(id);
        String key = "user_" + id;
        if (result != 0) {
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除了缓存中的key:" + key);
            }
        }
        return result;
    }
}
