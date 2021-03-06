package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbStrategyMapper;
import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.pojo.TbStrategyExample;
import com.tourmanager.pojo.TbUser;
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
	public List<TbStrategy> findAll(TbStrategy strategy) {
		TbStrategyExample example=new TbStrategyExample();
		Criteria criteria = example.createCriteria();
		
		if(strategy!=null){			
			if(!StringUtils.isEmpty(strategy.getCity())) {
				criteria.andCityLike("%"+strategy.getCity()+"%");
			}
			if(!StringUtils.isEmpty(strategy.getCitytype())) {
				criteria.andCitytypeEqualTo(strategy.getCitytype());
			}
			if(!StringUtils.isEmpty(strategy.getStatus())) {
				criteria.andStatusEqualTo(strategy.getStatus());
			}
		}
		
		return strategyMapper.selectByExampleWithBLOBs(example);
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
		strategyMapper.updateByPrimaryKeySelective(strategy);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	/* (non-Javadoc)
	 * @see com.tourmanager.service.StrategyService#findOne(java.lang.Integer)
	 */
	@Override
	public TbStrategy findOne(Integer id){
		return strategyMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer id) {
			strategyMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbStrategy strategy, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbStrategyExample example=new TbStrategyExample();
		Criteria criteria = example.createCriteria();
		
		if(strategy!=null){			
			if(!StringUtils.isEmpty(strategy.getCity())) {
				criteria.andCityLike("%"+strategy.getCity()+"%");
			}
			if(!StringUtils.isEmpty(strategy.getCitytype())) {
				criteria.andCitytypeEqualTo(strategy.getCitytype());
			}
			if(!StringUtils.isEmpty(strategy.getStatus())) {
				criteria.andStatusEqualTo(strategy.getStatus());
			}
		}
		
		Page<TbStrategy> page= (Page<TbStrategy>)strategyMapper.selectByExampleWithBLOBs(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbStrategy> findNoLoginAll() {
			return strategyMapper.findNoLoginAll();
		}

		@Override
		public List<TbStrategy> findBanner() {
			return strategyMapper.findBanner();
		}
		@Override
		public List<TbStrategy> findLoginAll(TbUser user) {
			System.out.println("登录以后查询");
			TbStrategyExample example=new TbStrategyExample();
			Criteria criteria = example.createCriteria();
			criteria.andStartageLessThan(user.getAge());
			criteria.andEndageGreaterThan(user.getAge());
			return strategyMapper.selectByExample(example);
		}

		@Override
		public List<TbStrategy> findAllDis() {
			
			return strategyMapper.findAllDis();
		}

		@Override
		public List<TbStrategy> findAllDisWithLogo() {
			return strategyMapper.findAllDisWithLogo();
		}
	
}
