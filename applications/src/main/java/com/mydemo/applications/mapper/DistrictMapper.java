package com.mydemo.applications.mapper;

import com.mydemo.applications.entity.District;
import com.mydemo.applications.entity.DistrictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictMapper {
    long countByExample(DistrictExample example);

    int deleteByExample(DistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}