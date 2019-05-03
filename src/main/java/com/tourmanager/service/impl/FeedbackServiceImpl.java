package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbFeedbackMapper;
import com.tourmanager.pojo.TbFeedback;
import com.tourmanager.pojo.TbFeedbackExample;
import com.tourmanager.pojo.TbFeedbackExample.Criteria;
import com.tourmanager.service.FeedbackService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private TbFeedbackMapper feedbackMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbFeedback> findAll() {
		return feedbackMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbFeedback> page=   (Page<TbFeedback>) feedbackMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbFeedback feedback) {
		feedbackMapper.insert(feedback);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbFeedback feedback){
		feedbackMapper.updateByPrimaryKeySelective(feedback);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbFeedback findOne(Integer id){
		return feedbackMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			feedbackMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbFeedback feedback, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbFeedbackExample example=new TbFeedbackExample();
		Criteria criteria = example.createCriteria();
		
		if(feedback!=null){			
			if(!StringUtils.isEmpty(feedback.getUsername())) {
				criteria.andUsernameLike("%"+feedback.getUsername()+"%");
			}
		}
		
		Page<TbFeedback> page= (Page<TbFeedback>)feedbackMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbFeedback> findAllByUId(Integer uid) {
			TbFeedbackExample example=new TbFeedbackExample();
			Criteria criteria = example.createCriteria();
			criteria.andUidEqualTo(uid);
			return feedbackMapper.selectByExample(example);
		}
	
}
