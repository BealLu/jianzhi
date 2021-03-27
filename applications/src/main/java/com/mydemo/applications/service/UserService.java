package com.mydemo.applications.service;

import com.mydemo.applications.entity.District;
import com.mydemo.applications.entity.JzUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<District> findAddressPid(Integer id);
    JzUser findOne(int id);
    int addUser(JzUser user);
    int updateUser(JzUser user);
    JzUser login(String name,String pwd);
    Map findPersonal(Integer id);
}
