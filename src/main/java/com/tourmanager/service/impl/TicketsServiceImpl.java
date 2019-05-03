package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbTicketsMapper;
import com.tourmanager.pojo.TbTickets;
import com.tourmanager.pojo.TbTicketsExample;
import com.tourmanager.pojo.TbTicketsExample.Criteria;
import com.tourmanager.service.TicketsService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TicketsServiceImpl implements TicketsService {

	@Autowired
	private TbTicketsMapper ticketsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTickets> findAll() {
		return ticketsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbTickets> page=   (Page<TbTickets>) ticketsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTickets tickets) {
		ticketsMapper.insert(tickets);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTickets tickets){
		ticketsMapper.updateByPrimaryKeySelective(tickets);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTickets findOne(Integer id){
		return ticketsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			ticketsMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTickets tickets, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTicketsExample example=new TbTicketsExample();
		Criteria criteria = example.createCriteria();
		
		if(tickets!=null){			
			if(!StringUtils.isEmpty(tickets.getAttrname())) {
				criteria.andAttrnameLike("%"+tickets.getAttrname()+"%");
			}	
		}
		
		Page<TbTickets> page= (Page<TbTickets>)ticketsMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
