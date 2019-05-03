package com.tourmanager.mapper;

import com.tourmanager.pojo.TbTickets;
import com.tourmanager.pojo.TbTicketsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTicketsMapper {
    int countByExample(TbTicketsExample example);

    int deleteByExample(TbTicketsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTickets record);

    int insertSelective(TbTickets record);

    List<TbTickets> selectByExample(TbTicketsExample example);

    TbTickets selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTickets record, @Param("example") TbTicketsExample example);

    int updateByExample(@Param("record") TbTickets record, @Param("example") TbTicketsExample example);

    int updateByPrimaryKeySelective(TbTickets record);

    int updateByPrimaryKey(TbTickets record);
}