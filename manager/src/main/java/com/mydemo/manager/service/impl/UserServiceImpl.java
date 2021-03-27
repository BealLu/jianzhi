package com.mydemo.manager.service.impl;

import com.mydemo.manager.entity.JzUser;
import com.mydemo.manager.entity.JzUserExample;
import com.mydemo.manager.mapper.JzUserMapper;
import com.mydemo.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JzUserMapper userMapper;
    @Override
    public List<JzUser> findAll() {
        return  userMapper.selectByExample(null);
    }

    @Override
    public JzUser findOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int setStatus(Integer[] ids, String sta) {
        try {
            for (Integer id : ids) {
                JzUser jzUser = userMapper.selectByPrimaryKey(id);
                jzUser.setStatus(sta);
                userMapper.updateByPrimaryKey(jzUser);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return -1;
        }
        return 1;
    }

    @Override
    public List<JzUser> findBySta(String sta) {
        if (sta==""||sta==null){
            return userMapper.selectByExample(null);
        }
        JzUserExample example=new JzUserExample();
        JzUserExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(sta);
        List<JzUser> jzUsers = userMapper.selectByExample(example);
        return jzUsers;
    }
}
