package com.mydemo.applications.service.impl;

import com.mydemo.applications.entity.Content;
import com.mydemo.applications.entity.ContentExample;
import com.mydemo.applications.mapper.ContentMapper;
import com.mydemo.applications.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public List<Content> findContent() {
        ContentExample example=new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");
        List<Content> contents = contentMapper.selectByExample(example);
        return contents;
    }
}
