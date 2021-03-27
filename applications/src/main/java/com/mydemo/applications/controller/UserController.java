package com.mydemo.applications.controller;

import com.mydemo.applications.entity.District;
import com.mydemo.applications.entity.JzUser;
import com.mydemo.applications.service.UserService;
import com.mydemo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAddressPid")
    public List<District> findAddressPid(Integer pid){
        return userService.findAddressPid(pid);
    }
    @RequestMapping("/findOne")
    public JzUser findOne(Integer id){
        return userService.findOne(id);
    }
    @RequestMapping("/updateUser")
    public Result updateUser(@RequestBody JzUser user){
        int i = userService.updateUser(user);
        if (i>0){
            return new Result(true,"修改成功");
        }
        return new Result(false,"修改失败");
    }
    @RequestMapping("/addUser")
    public Result addUser(@RequestBody JzUser user){
        System.out.println(user.toString());
        int i = userService.addUser(user);
        System.out.println(i);
        if (i>0){
            return new Result(true,"注册成功");
        }
        return new Result(false,"注册失败");
    }
    @RequestMapping("/findPersonal")
    public Map findPersonal(Integer id){
        return userService.findPersonal(id);
    }
 }
