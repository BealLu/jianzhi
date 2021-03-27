package com.mydemo.applications.mapper;

import com.mydemo.applications.entity.JzPosition;
import com.mydemo.applications.entity.JzPositionExample;
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

    List<JzPosition> findNewPosi();
}