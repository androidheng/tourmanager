package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbCommentsMapper;
import com.tourmanager.pojo.TbComments;
import com.tourmanager.pojo.TbCommentsExample;
import com.tourmanager.pojo.TbCommentsExample.Criteria;
import com.tourmanager.service.CommentsService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private TbCommentsMapper commentsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbComments> findAll() {
		return commentsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbComments> page=   (Page<TbComments>) commentsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbComments comments) {
		commentsMapper.insert(comments);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbComments comments){
		commentsMapper.updateByPrimaryKey(comments);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbComments findOne(Integer id){
		return commentsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			commentsMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbComments comments, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCommentsExample example=new TbCommentsExample();
		Criteria criteria = example.createCriteria();
		
		if(comments!=null){			
				
		}
		
		Page<TbComments> page= (Page<TbComments>)commentsMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
