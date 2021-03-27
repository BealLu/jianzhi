package com.mydemo.manager.service.impl;

import com.mydemo.manager.entity.Content;
import com.mydemo.manager.mapper.ContentMapper;
import com.mydemo.manager.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public List<Content> findAll() {
        return contentMapper.selectByExample(null);
    }

    @Override
    public Content findOne(int id) {

        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int dele(Integer[] ids) {
        try {
            for (Integer id : ids) {
                contentMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    @Override
    public int update(Content content) {

        return contentMapper.updateByPrimaryKey(content);
    }

    @Override
    public int add(Content content) {

        return contentMapper.insert(content);
    }

    @Override
    public int setStatus(Integer[] ids, String status) {
        try {
            for (Integer id : ids) {
                Content content = findOne(id);
                content.setStatus(status);
                contentMapper.updateByPrimaryKey(content);
            }
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }
}
