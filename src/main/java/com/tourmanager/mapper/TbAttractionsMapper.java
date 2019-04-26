package com.tourmanager.mapper;

import com.tourmanager.pojo.TbAttractions;
import com.tourmanager.pojo.TbAttractionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAttractionsMapper {
    int countByExample(TbAttractionsExample example);

    int deleteByExample(TbAttractionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAttractions record);

    int insertSelective(TbAttractions record);

    List<TbAttractions> selectByExample(TbAttractionsExample example);

    TbAttractions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAttractions record, @Param("example") TbAttractionsExample example);

    int updateByExample(@Param("record") TbAttractions record, @Param("example") TbAttractionsExample example);

    int updateByPrimaryKeySelective(TbAttractions record);

    int updateByPrimaryKey(TbAttractions record);
}