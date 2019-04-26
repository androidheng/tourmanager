package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbMessageMapper;
import com.tourmanager.pojo.TbMessage;
import com.tourmanager.pojo.TbMessageExample;
import com.tourmanager.pojo.TbMessageExample.Criteria;
import com.tourmanager.service.MessageService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private TbMessageMapper messageMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbMessage> findAll() {
		return messageMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbMessage> page=   (Page<TbMessage>) messageMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbMessage message) {
		messageMapper.insert(message);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbMessage message){
		messageMapper.updateByPrimaryKeySelective(message);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbMessage findOne(Integer id){
		return messageMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer id) {
			messageMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbMessage message, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbMessageExample example=new TbMessageExample();
		Criteria criteria = example.createCriteria();
		
		if(message!=null){			
				
		}
		
		Page<TbMessage> page= (Page<TbMessage>)messageMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
