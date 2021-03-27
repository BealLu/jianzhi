package com.mydemo.applications.service.impl;

import com.alibaba.fastjson.JSON;
import com.mydemo.applications.entity.*;
import com.mydemo.applications.mapper.DistrictMapper;
import com.mydemo.applications.mapper.JzPositionMapper;
import com.mydemo.applications.mapper.JzUserMapper;
import com.mydemo.applications.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
     private JzUserMapper jzUserMapper;
    @Autowired
    private JzPositionMapper jzPositionMapper;
    @Override
    public List<District> findAddressPid(Integer id) {
        DistrictExample example=new DistrictExample();
        DistrictExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(id);
        return districtMapper.selectByExample(example);
    }

    @Override
    public JzUser findOne(int id) {
        return jzUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(JzUser user) {
        return jzUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public JzUser login(String name, String pwd) {
        JzUserExample example=new JzUserExample();
        JzUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPasswordEqualTo(pwd);
        List<JzUser> jzUsers = jzUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(jzUsers)){
            return null;
        }
        return jzUsers.get(0);
    }

    @Override
    public Map findPersonal(Integer id) {
        JzUser jzUser = jzUserMapper.selectByPrimaryKey(id);
        JzPositionExample example=new JzPositionExample();
        JzPositionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        List<JzPosition> jzPositions = jzPositionMapper.selectByExample(example);
        String guanzhu = jzUser.getGuanzhu();
        List<JzPosition> jzPositions1=new ArrayList<>();

        if (!StringUtils.isEmpty(guanzhu)) {
            Set<Integer> set = JSON.parseObject(guanzhu, Set.class);
            for (Integer integer : set) {
                JzPosition jzPosition = jzPositionMapper.selectByPrimaryKey(integer);
                jzPositions1.add(jzPosition);
            }
        }else {
            jzPositions1=null;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("user",jzUser);
        map.put("publish",jzPositions);
        map.put("guanzhu",jzPositions1);
        return map;
    }

    @Override
    public int addUser(JzUser user) {
        user.setStatus("0");//默认为审核
        return jzUserMapper.insert(user);
    }
}
