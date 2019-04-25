package com.dk.ajax.demo.dao.mapper;

import com.dk.ajax.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Cheri
 * @title: UserMapper
 * @projectName spring-boot-ajax
 * @description: mybatis方式实现数据库访问与操作
 * @date 2019/4/2021:34
 */

@Repository
public interface UserMapper {

    User selectUserById(int id);

    User login(String name,String password);

    int register(User user);

    List<User> selectAllUser();

    @Select("select * from user where name=#{0}")
    List<User> selectAllUserByName(String name);

    @Insert("insert into user(name,age) values(#{name},#{age})")
    public int insertUser(User user);

    int updateUser(@Param("user") User user);

    int deleteUserById(int id);

    @Select("SELECT * FROM user where id=#{id}")
    User findUserById(@Param("id") int id);

}
