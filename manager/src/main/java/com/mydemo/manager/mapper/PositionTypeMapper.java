package com.mydemo.manager.mapper;

import com.mydemo.manager.entity.PositionType;
import com.mydemo.manager.entity.PositionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionTypeMapper {
    long countByExample(PositionTypeExample example);

    int deleteByExample(PositionTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionType record);

    int insertSelective(PositionType record);

    List<PositionType> selectByExample(PositionTypeExample example);

    PositionType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByExample(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByPrimaryKeySelective(PositionType record);

    int updateByPrimaryKey(PositionType record);
}