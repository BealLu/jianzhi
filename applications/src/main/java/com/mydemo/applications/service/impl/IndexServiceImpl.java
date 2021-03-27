package com.mydemo.applications.service.impl;

import com.mydemo.applications.entity.IndexPojo;
import com.mydemo.applications.entity.JzPosition;
import com.mydemo.applications.entity.JzUser;
import com.mydemo.applications.entity.PositionPojo;
import com.mydemo.applications.mapper.JzPositionMapper;
import com.mydemo.applications.mapper.JzUserMapper;
import com.mydemo.applications.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private JzPositionMapper positionMapper;
    @Autowired
    private JzUserMapper userMapper;
    @Override
    public List<IndexPojo> findNewPosi() {
       List<IndexPojo> pojos = new ArrayList<>();
        List<JzPosition> newPosi = positionMapper.findNewPosi();
        for (JzPosition jzPosition : newPosi) {
            IndexPojo indexPojo = new IndexPojo();
            JzUser jzUser = userMapper.selectByPrimaryKey(jzPosition.getUserId());
            indexPojo.setPosiId(jzPosition.getDescFk());
            indexPojo.setPic(jzUser.getPic());
            indexPojo.setPosiName(jzPosition.getTitle());
            indexPojo.setUsername(jzUser.getUsername());
            indexPojo.setUserId(jzUser.getId());
            pojos.add(indexPojo);
        }
        return pojos;
    }
}
