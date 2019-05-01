package com.tourmanager.mapper;

import com.tourmanager.pojo.TbFood;
import com.tourmanager.pojo.TbFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFoodMapper {
    int countByExample(TbFoodExample example);

    int deleteByExample(TbFoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFood record);

    int insertSelective(TbFood record);

    List<TbFood> selectByExample(TbFoodExample example);

    TbFood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFood record, @Param("example") TbFoodExample example);

    int updateByExample(@Param("record") TbFood record, @Param("example") TbFoodExample example);

    int updateByPrimaryKeySelective(TbFood record);

    int updateByPrimaryKey(TbFood record);
}