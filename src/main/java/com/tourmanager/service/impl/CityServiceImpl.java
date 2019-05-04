package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.tourmanager.mapper.TbCityMapper;
import com.tourmanager.pojo.TbCity;
import com.tourmanager.pojo.TbCityExample;
import com.tourmanager.pojo.TbCityExample.Criteria;
import com.tourmanager.service.CityService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private TbCityMapper cityMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbCity> findAll() {
		return cityMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCity> page=   (Page<TbCity>) cityMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbCity city) {
		cityMapper.insert(city);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbCity city){
		cityMapper.updateByPrimaryKeySelective(city);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbCity findOne(Integer id){
		return cityMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		cityMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbCity city, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCityExample example=new TbCityExample();
		Criteria criteria = example.createCriteria();
		
		if(city!=null){			
				
			if(!StringUtils.isEmpty(city.getCname())) {
				criteria.andCnameLike("%"+city.getCname()+"%");
			}
			if(!StringUtils.isEmpty(city.getCtype())) {
				criteria.andCtypeEqualTo(city.getCtype());
			}
		}
		
		Page<TbCity> page= (Page<TbCity>)cityMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public TbCity findCity(TbCity city) {
			TbCityExample example=new TbCityExample();
			Criteria criteria = example.createCriteria();
			criteria.andCnameEqualTo(city.getCname());
			List<TbCity> list = cityMapper.selectByExample(example);	
			if(list.size()>0)
				return list.get(0);
			return null;
		}
	
}
