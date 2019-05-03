package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;
import com.tourmanager.mapper.TbGradeMapper;
import com.tourmanager.pojo.TbGrade;
import com.tourmanager.pojo.TbGradeExample;
import com.tourmanager.pojo.TbGradeExample.Criteria;
import com.tourmanager.service.GradeService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private TbGradeMapper gradeMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbGrade> findAll() {
		return gradeMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbGrade> page=   (Page<TbGrade>) gradeMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbGrade grade) {
		gradeMapper.insert(grade);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbGrade grade){
		gradeMapper.updateByPrimaryKeySelective(grade);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbGrade findOne(Integer id){
		return gradeMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		gradeMapper.deleteByPrimaryKey(id);
				
	}
	
	
		@Override
	public PageResult findPage(TbGrade grade, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbGradeExample example=new TbGradeExample();
		Criteria criteria = example.createCriteria();
		
		if(grade!=null){			
				
			if(!StringUtils.isEmpty("")) {
				
			}
		}
		
		Page<TbGrade> page= (Page<TbGrade>)gradeMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbGrade> findAllByName(String attrname) {
			TbGradeExample example=new TbGradeExample();
			Criteria criteria = example.createCriteria();
			criteria.andAttrnameEqualTo(attrname);
			return gradeMapper.selectByExample(example);		
		}
	
}
