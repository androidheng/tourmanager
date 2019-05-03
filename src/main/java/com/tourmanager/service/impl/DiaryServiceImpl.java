package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbDiaryMapper;
import com.tourmanager.pojo.TbDiary;
import com.tourmanager.pojo.TbDiaryExample;
import com.tourmanager.pojo.TbDiaryExample.Criteria;
import com.tourmanager.service.DiaryService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private TbDiaryMapper diaryMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbDiary> findAll() {
		return diaryMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbDiary> page=   (Page<TbDiary>) diaryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbDiary diary) {
		diaryMapper.insert(diary);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbDiary diary){
		diaryMapper.updateByPrimaryKeySelective(diary);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbDiary findOne(Integer id){
		return diaryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			diaryMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbDiary diary, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbDiaryExample example=new TbDiaryExample();
		Criteria criteria = example.createCriteria();
		
		if(diary!=null){			
			if(!StringUtils.isEmpty(diary.getTitle())) {
				criteria.andTitleLike("%"+diary.getTitle()+"%");
			}
		}
		
		Page<TbDiary> page= (Page<TbDiary>)diaryMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbDiary> findByKeyAll(String key) {
			TbDiaryExample example=new TbDiaryExample();
			Criteria criteria = example.createCriteria();
			if(!StringUtils.isEmpty(key)){			
				criteria.andCnameLike("%"+key+"%");	
			}
			return diaryMapper.selectByExample(example);
		}

		@Override
		public List<TbDiary> findNoLoginAll() {
			return diaryMapper.findNoLoginAll();
		}
	
}
