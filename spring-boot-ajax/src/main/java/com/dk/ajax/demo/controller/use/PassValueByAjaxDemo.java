package com.dk.ajax.demo.controller.use;

import com.dk.ajax.demo.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheri
 * @title: PassValueByAjaxDemo
 * @projectName spring-boot-ajax
 * @description: Ajax 传值方式的演示
 * @date 2019/4/2021:58
 */
@Controller
@RequestMapping("/passValue")
public class PassValueByAjaxDemo {

    @RequestMapping("/all")
    public String queryAllUser(Model model){
        return "/use/passValueByAjax";
    }

    /**
     * 不使用任何注解。
     * @param id
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/first")
    @ResponseBody
    public Map<String,Object> firstWay(String id, String name, String age){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",name);
        map.put("isOk","success");
        System.out.println(id+"->"+name+"->"+age);
        return map;
    }

    /**
     * 使用注解@PathVariable    $.get
     * 只要保证 {userId1}中的名称与 PathVariable()中名称一致即可
     * @param userId
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/second/{userId1}")
    @ResponseBody
    public Map<String,Object> secondWay(@PathVariable("userId1")String userId, String name, String age){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",name);
        map.put("isOk","success");
        System.out.println(userId+"->"+name+"->"+age);
        return map;
    }

    /**
     * 使用注解@RequestParam    $.get
     * 注意点：id要与前端页面url中参数名一致
     * @param userId
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/third")
    @ResponseBody
    public Map<String,Object> thirdWay(@RequestParam("id")String userId, String name, String age){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",name);
        map.put("isOk","success");
        System.out.println(userId+"->"+name+"->"+age);
        return map;
    }


    @RequestMapping("/fourth1")
    @ResponseBody
    public Map<String,Object> fourthWay1(@RequestBody Map<String, Object> params){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",params.get("name"));
        map.put("isOk","success");
        System.out.println(params.get("userId")+"->"+params.get("name")+"->"+params.get("age"));
        return map;
    }

    @RequestMapping("/fourth2")
    @ResponseBody
    public Map<String,Object> fourthWay2(@RequestBody User user){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",user.getName());
        map.put("isOk","success");
        System.out.println(user.getId()+"->"+user.getName()+"->"+user.getAge());
        return map;
    }

    @RequestMapping("/fourth3")
    @ResponseBody
    public Map<String,Object> fourthWay3(@RequestBody JSONObject params){
        String userId = params.getString("id");
        String name = params.getString("name");
        String age = params.getString("age");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",name);
        map.put("isOk","success");
        System.out.println(userId+"->"+name+"->"+age);
        return map;
    }

    @RequestMapping("/fifth")
    @ResponseBody
    public Map<String,Object> fifthWay(HttpServletRequest request){
        String  name =  request.getParameter("name");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("data",name);
        map.put("isOk","success");
        System.out.println(name);
        return map;
    }
}
