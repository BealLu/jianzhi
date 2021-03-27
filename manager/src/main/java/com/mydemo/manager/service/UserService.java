package com.mydemo.manager.service;

import com.mydemo.manager.entity.JzUser;

import java.util.List;

public interface UserService {
    List<JzUser> findAll();
    JzUser findOne(Integer id);
    int setStatus(Integer[] ids,String sta);
    List<JzUser> findBySta(String sta);
}
