package com.mydemo.applications.controller;

import com.mydemo.applications.entity.IndexPojo;
import com.mydemo.applications.entity.JzUser;
import com.mydemo.applications.service.IndexService;
import com.mydemo.applications.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class indexController {
    @Autowired
    private UserService userService;
    @Autowired
    private IndexService indexService;
    @RequestMapping("/findUser")
    public JzUser findUser(Integer id){
        return userService.findOne(id);
    }
    @RequestMapping("/findNewPosi")
    public List<IndexPojo> findNewPosi(){
        return indexService.findNewPosi();
    }
}
