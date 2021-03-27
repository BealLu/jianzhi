package com.mydemo.applications.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mydemo.applications.entity.*;
import com.mydemo.applications.mapper.JzPositionMapper;
import com.mydemo.applications.mapper.JzUserMapper;
import com.mydemo.applications.mapper.PositionDescMapper;
import com.mydemo.applications.mapper.PositionTypeMapper;
import com.mydemo.applications.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private JzPositionMapper jzPositionMapper;
    @Autowired
    private PositionDescMapper positionDescMapper;
    @Autowired
    private PositionTypeMapper positionTypeMapper;
    @Autowired
    private JzUserMapper userMapper;
    @Override
    public int addPosition(PositionPojo positionPojo) {
        try {
            PositionDesc positionDesc = new PositionDesc();
            positionDesc.setAddress(positionPojo.getAddress());
            positionDesc.setDemand(positionPojo.getDemand());
            positionDesc.setDescc(positionPojo.getDesc());
            positionDesc.setPhone(positionPojo.getPhone());
            positionDesc.setSalary(positionPojo.getSalar());
            positionDesc.setTitle(positionPojo.getTitle());
            positionDesc.setUserId(Integer.parseInt(positionPojo.getUserId()));
            //System.out.println(positionDesc);
            positionDescMapper.insert(positionDesc);
            //System.out.println("插入后："+positionDesc);
            positionPojo.setDescFk(positionDesc.getId());

            JzPosition jzPosition = new JzPosition();
            jzPosition.setDescFk(positionPojo.getDescFk());
            jzPosition.setIspublish("0");//默认不发布
            jzPosition.setSalary(positionPojo.getSalar());
            jzPosition.setStatus("0");//默认审核未通过
            jzPosition.setTitle(positionPojo.getTitle());
            jzPosition.setType1(positionPojo.getType1());
            jzPosition.setType2(positionPojo.getType2());
            jzPosition.setType3(positionPojo.getType3());
            jzPosition.setUserId(Integer.parseInt(positionPojo.getUserId()));
            //System.out.println(jzPosition);
            jzPositionMapper.insert(jzPosition);
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            return -1;
        }

        return 1;

    }

    @Override
    public List<PositionType> findTypePid(Integer pid) {
        PositionTypeExample example=new PositionTypeExample();
        PositionTypeExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        return positionTypeMapper.selectByExample(example);
    }

    @Override
    public Map findDesc(Integer id,Integer userId) {
        PositionDesc positionDesc = positionDescMapper.selectByPrimaryKey(id);
        JzUser jzUser = userMapper.selectByPrimaryKey(positionDesc.getUserId());
        JzUser user = userMapper.selectByPrimaryKey(userId);
        Map<String,Object> map = new HashMap<>();
        JzPositionExample example=new JzPositionExample();
        JzPositionExample.Criteria criteria = example.createCriteria();
        criteria.andDescFkEqualTo(id);
        List<JzPosition> jzPositions = jzPositionMapper.selectByExample(example);
        map.put("user",jzUser);
        map.put("guanzhu",user.getGuanzhu());
        map.put("desc",positionDesc);
        map.put("posi",jzPositions.get(0));
        return map;
    }

    @Override
    public List<JzPosition> findAllPosi(SearchEntity entity) {
       JzPositionExample example=new JzPositionExample();
        JzPositionExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");//只显示审核通过的
        if (!ObjectUtils.isEmpty(entity)) {
            if (entity.getTitle()!=null&&entity.getTitle().length()>0){
                criteria.andTitleLike("%"+entity.getTitle()+"%");
            }
            if (entity.getType1()!=null){
                criteria.andType1EqualTo(entity.getType1());
            }
            if (entity.getType2()!=null){
                criteria.andType2EqualTo(entity.getType2());
            }
            if (entity.getType3()!=null){
                criteria.andType3EqualTo(entity.getType3());
            }

        }
            return jzPositionMapper.selectByExample(example);
    }

    @Override
    public List<PositionType> findAllType() {
        return positionTypeMapper.selectByExample(null);
    }

    @Override
    public int addgunzhu(Integer descId, Integer userId) {
        try {
            JzPositionExample example=new JzPositionExample();
            JzPositionExample.Criteria criteria = example.createCriteria();
            criteria.andDescFkEqualTo(descId);
            List<JzPosition> jzPositions = jzPositionMapper.selectByExample(example);
            Integer posiId=jzPositions.get(0).getId();
            JzUser jzUser = userMapper.selectByPrimaryKey(userId);
            String guanzhu = jzUser.getGuanzhu();
            if (!StringUtils.isEmpty(guanzhu)){
                Set<Integer> set = JSON.parseObject(guanzhu, Set.class);
               set.add(posiId);
                String jsonString = JSON.toJSONString(set);
                jzUser.setGuanzhu(jsonString);
                userMapper.updateByPrimaryKey(jzUser);
            }else {
                Set<Integer> set=new HashSet<>();
                set.add(posiId);
                String jsonString = JSON.toJSONString(set);
                jzUser.setGuanzhu(jsonString);
                userMapper.updateByPrimaryKey(jzUser);
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return 1;
    }

    @Override
    public int remguanzhu(Integer descId, Integer userId) {
        try {
            JzPositionExample example=new JzPositionExample();
            JzPositionExample.Criteria criteria = example.createCriteria();
            criteria.andDescFkEqualTo(descId);
            List<JzPosition> jzPositions = jzPositionMapper.selectByExample(example);
            Integer posiId=jzPositions.get(0).getId();
            JzUser jzUser = userMapper.selectByPrimaryKey(userId);
            String guanzhu = jzUser.getGuanzhu();
            Set<Integer> set = JSON.parseObject(guanzhu, Set.class);
            set.remove(posiId);
            String jsonString = JSON.toJSONString(set);
            jzUser.setGuanzhu(jsonString);
            userMapper.updateByPrimaryKey(jzUser);
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return 1;
    }

    @Override
    public int addPublish(Integer id) {
        JzPosition jzPosition = jzPositionMapper.selectByPrimaryKey(id);
        jzPosition.setIspublish("1");//设置发布
        int i = jzPositionMapper.updateByPrimaryKey(jzPosition);
        return i;
    }

    @Override
    public int remPublish(Integer id) {
        JzPosition jzPosition = jzPositionMapper.selectByPrimaryKey(id);
        jzPosition.setIspublish("0");//设置取消发布
        jzPosition.setStatus("0");//设置未审核
        int i = jzPositionMapper.updateByPrimaryKey(jzPosition);
        return i;


    }

    @Override
    public PositionPojo findOne(Integer id) {
        PositionPojo positionPojo = new PositionPojo();
        JzPosition jzPosition = jzPositionMapper.selectByPrimaryKey(id);
        PositionDesc positionDesc = positionDescMapper.selectByPrimaryKey(jzPosition.getDescFk());
        positionPojo.setAddress(positionDesc.getAddress());
        positionPojo.setDescFk(positionDesc.getId());
        positionPojo.setDesc(positionDesc.getDescc());
        positionPojo.setDemand(positionDesc.getDemand());
        positionPojo.setId(id);
        positionPojo.setPhone(positionDesc.getPhone());
        positionPojo.setSalar(positionDesc.getSalary());
        positionPojo.setTitle(positionDesc.getTitle());
        positionPojo.setType1(jzPosition.getType1());
        positionPojo.setType2(jzPosition.getType2());
        positionPojo.setType3(jzPosition.getType3());
        positionPojo.setUserId(jzPosition.getUserId().toString());
        return positionPojo;
    }

    @Override
    public int update(PositionPojo positionPojo) {
        try {
            Integer posiId = positionPojo.getId();
            Integer descFk = positionPojo.getDescFk();
            PositionDesc positionDesc = positionDescMapper.selectByPrimaryKey(descFk);
            positionDesc.setAddress(positionPojo.getAddress());
            positionDesc.setDemand(positionPojo.getDemand());
            positionDesc.setDescc(positionPojo.getDesc());
            positionDesc.setPhone(positionPojo.getPhone());
            positionDesc.setSalary(positionPojo.getSalar());
            positionDesc.setTitle(positionPojo.getTitle());
            positionDesc.setUserId(Integer.parseInt(positionPojo.getUserId()));
            positionDescMapper.updateByPrimaryKey(positionDesc);


            JzPosition jzPosition = jzPositionMapper.selectByPrimaryKey(posiId);
            jzPosition.setDescFk(descFk);
            jzPosition.setIspublish("0");//默认不发布
            jzPosition.setSalary(positionPojo.getSalar());
            jzPosition.setStatus("0");//默认审核未通过
            jzPosition.setTitle(positionPojo.getTitle());
            jzPosition.setType1(positionPojo.getType1());
            jzPosition.setType2(positionPojo.getType2());
            jzPosition.setType3(positionPojo.getType3());
            jzPosition.setUserId(Integer.parseInt(positionPojo.getUserId()));
            jzPositionMapper.updateByPrimaryKey(jzPosition);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return -1;
        }
        return 1;
    }




    /*public int addJzPosition(PositionPojo positionPojo){
        JzPosition jzPosition = new JzPosition();
        jzPosition.setDescFk(positionPojo.getDescFk());
        jzPosition.setIspublish("0");//默认不发布
        jzPosition.setSalary(positionPojo.getSalar());
        jzPosition.setStatus("0");//默认审核未通过
        jzPosition.setTitle(positionPojo.getTitle());
        jzPosition.setType1(positionPojo.getType1());
        jzPosition.setType2(positionPojo.getType2());
        jzPosition.setType3(positionPojo.getType3());
        jzPosition.setUserId(Integer.parseInt(positionPojo.getUserId()));
        int insert = jzPositionMapper.insert(jzPosition);
        return insert;
    }

    public int addPositionDesc(PositionPojo positionPojo){
        PositionDesc positionDesc = new PositionDesc();
        positionDesc.setAddress(positionPojo.getAddress());
        positionDesc.setDemand(positionDesc.getDemand());
        positionDesc.setDesc(positionDesc.getDesc());
        positionDesc.setPhone(positionDesc.getPhone());
        positionDesc.setSalary(positionDesc.getSalary());
        positionDesc.setTitle(positionDesc.getTitle());
        positionDesc.setUserId(positionDesc.getUserId());
        System.out.println(positionDesc);
        int insert = positionDescMapper.insert(positionDesc);
        System.out.println("插入后："+positionDesc);
        positionPojo.setDescFk(positionDesc.getId());
        addJzPosition(positionPojo);
        return insert;
    }*/
}
