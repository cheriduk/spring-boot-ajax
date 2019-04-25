package com.dk.ajax.demo.controller;

import com.dk.ajax.demo.model.User;
import com.dk.ajax.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheri
 * @title: UserController
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2018:24
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/all")
    public String queryAllUser(Model model){
        List<User> userList = userService.queryAllUser();
        model.addAttribute("userList",userList);
        System.out.println("user记录数："+userList.size());
        return "queryAllUser";
    }

    @PostMapping("/ajax")
    @ResponseBody
    public Map<String,Object> queryUserById(String userid){
        System.out.println("into---------ajax------->>>");
        User user = userService.queryUserById(userid);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("user",user);
        map.put("isOk","success");
        return map;
    }


    @RequestMapping("getUser/{id}")
    @ResponseBody
    public String queryUserById(@PathVariable int id){
        return userService.queryUserById(id).toString();
    }

    @RequestMapping("/pageList")
    @ResponseBody
    public PageInfo<User> findUserList(int pageNum, int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }

    @RequestMapping("/ListByName")
    @ResponseBody
    public List<User> findAllUserByName(String name){
        List<User> userList = userService.findAllUserByName(name);
        return userList;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(User user){
        int count = userService.addUser(user);
        System.out.println("新增user记录数："+count);
        String jsonStr = "{'count':"+count+"}";
        JSONObject jsonObj = JSONObject.fromObject(jsonStr);
        return jsonObj.toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> findUserById(User user){
        int count = userService.updateUser(user);
        Map<String, Object> result = new HashMap<>();
        if (count !=0){
            result.put("isOk","update user success");
            result.put("count",count);
        }else {
            result.put("isOk","update user fail");
            result.put("count",count);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteUserById(@RequestParam int id){
        int result = userService.deleteUserById(id);
        if(result != 0){
            return "delete success";
        }
        return "delete fail";
    }

    @RequestMapping("/toFindUser")
    public String queryUserById(){
        return "toFindUser";
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.POST)
    @ResponseBody
    public User findUser(@RequestParam("id") int id) {
        return userService.findUserById(id);
    }

}
