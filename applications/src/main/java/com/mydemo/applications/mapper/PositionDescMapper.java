package com.mydemo.applications.mapper;

import com.mydemo.applications.entity.PositionDesc;
import com.mydemo.applications.entity.PositionDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionDescMapper {
    long countByExample(PositionDescExample example);

    int deleteByExample(PositionDescExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionDesc record);

    int insertSelective(PositionDesc record);

    List<PositionDesc> selectByExample(PositionDescExample example);

    PositionDesc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionDesc record, @Param("example") PositionDescExample example);

    int updateByExample(@Param("record") PositionDesc record, @Param("example") PositionDescExample example);

    int updateByPrimaryKeySelective(PositionDesc record);

    int updateByPrimaryKey(PositionDesc record);
}