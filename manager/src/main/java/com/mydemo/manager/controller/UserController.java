package com.mydemo.manager.controller;

import com.mydemo.common.Result;
import com.mydemo.manager.entity.JzUser;
import com.mydemo.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public List<JzUser> findAll() {
        return userService.findAll();
    }
    @RequestMapping("/findOne")
    public JzUser findOne(Integer id){
        return userService.findOne(id);
    }
    @RequestMapping("/findBySta")
    public List<JzUser> findBySta(String sta){
        return userService.findBySta(sta);
    }
    @RequestMapping("/setStatus")
    public Result setStatus(Integer[] ids , String sta){
        int i = userService.setStatus(ids, sta);
        if (i==1){
            return new Result(true,"修改成功");
        }
        return new Result(false,"修改失败");
    }
}
