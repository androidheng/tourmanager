package com.tourmanager.mapper;

import com.tourmanager.pojo.TbHotel;
import com.tourmanager.pojo.TbHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHotelMapper {
    int countByExample(TbHotelExample example);

    int deleteByExample(TbHotelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbHotel record);

    int insertSelective(TbHotel record);

    List<TbHotel> selectByExample(TbHotelExample example);

    TbHotel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbHotel record, @Param("example") TbHotelExample example);

    int updateByExample(@Param("record") TbHotel record, @Param("example") TbHotelExample example);

    int updateByPrimaryKeySelective(TbHotel record);

    int updateByPrimaryKey(TbHotel record);
}