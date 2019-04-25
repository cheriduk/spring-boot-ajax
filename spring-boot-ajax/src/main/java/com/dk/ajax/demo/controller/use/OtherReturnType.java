package com.dk.ajax.demo.controller.use;

import com.dk.ajax.demo.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheri
 * @title: OtherReturnType
 * @projectName spring-boot-ajax
 * @description: TODO
 * @date 2019/4/2023:52
 */
@Controller
@RequestMapping("/otherType")
public class OtherReturnType {

    @RequestMapping("/all")
    public String queryAllUser(Model model){
        return "/use/returnType";
    }

    @RequestMapping("/string")
    @ResponseBody
    public String otherType(String id){
        System.out.println("id="+id);
        String jsonStr = "{'name':'JACK'}";
        JSONObject jsonObj = JSONObject.fromObject(jsonStr);

        //拓展部分*******************************************
        User user = (User) jsonObj.toBean(jsonObj,User.class);
        System.out.println(user);
        //***************************************************

        System.out.println(jsonStr);
        return jsonObj.toString();
    }
}
