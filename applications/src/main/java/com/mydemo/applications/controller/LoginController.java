package com.mydemo.applications.controller;

import com.alibaba.fastjson.JSON;
import com.mydemo.applications.entity.JzUser;
import com.mydemo.applications.service.UserService;
import com.mydemo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public JzUser login(String username, String pwd, HttpSession session){
        JzUser login = userService.login(username, pwd);
       return login;
    }
}
