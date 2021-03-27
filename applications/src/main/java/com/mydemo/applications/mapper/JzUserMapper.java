package com.mydemo.applications.mapper;

import com.mydemo.applications.entity.JzUser;
import com.mydemo.applications.entity.JzUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JzUserMapper {
    long countByExample(JzUserExample example);

    int deleteByExample(JzUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JzUser record);

    int insertSelective(JzUser record);

    List<JzUser> selectByExample(JzUserExample example);

    JzUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JzUser record, @Param("example") JzUserExample example);

    int updateByExample(@Param("record") JzUser record, @Param("example") JzUserExample example);

    int updateByPrimaryKeySelective(JzUser record);

    int updateByPrimaryKey(JzUser record);
}