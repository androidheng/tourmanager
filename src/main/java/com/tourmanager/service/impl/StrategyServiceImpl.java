package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbStrategyMapper;
import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.pojo.TbStrategyExample;
import com.tourmanager.pojo.TbStrategyExample.Criteria;
import com.tourmanager.service.StrategyService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class StrategyServiceImpl implements StrategyService {

	@Autowired
	private TbStrategyMapper strategyMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbStrategy> findAll() {
		return strategyMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbStrategy> page=   (Page<TbStrategy>) strategyMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbStrategy strategy) {
		strategyMapper.insert(strategy);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbStrategy strategy){
		strategyMapper.updateByPrimaryKey(strategy);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbStrategy findOne(Integer id){
		return strategyMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			strategyMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbStrategy strategy, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbStrategyExample example=new TbStrategyExample();
		Criteria criteria = example.createCriteria();
		
		if(strategy!=null){			
				
		}
		
		Page<TbStrategy> page= (Page<TbStrategy>)strategyMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
