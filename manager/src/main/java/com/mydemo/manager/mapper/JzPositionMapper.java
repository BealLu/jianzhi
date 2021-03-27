package com.mydemo.manager.mapper;

import com.mydemo.manager.entity.JzPosition;
import com.mydemo.manager.entity.JzPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JzPositionMapper {
    long countByExample(JzPositionExample example);

    int deleteByExample(JzPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JzPosition record);

    int insertSelective(JzPosition record);

    List<JzPosition> selectByExample(JzPositionExample example);

    JzPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JzPosition record, @Param("example") JzPositionExample example);

    int updateByExample(@Param("record") JzPosition record, @Param("example") JzPositionExample example);

    int updateByPrimaryKeySelective(JzPosition record);

    int updateByPrimaryKey(JzPosition record);
}