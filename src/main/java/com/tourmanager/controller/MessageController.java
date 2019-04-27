package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourmanager.pojo.TbMessage;
import com.tourmanager.service.MessageService;
import com.tourmanager.utils.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbMessage> findAll(){			
		return messageService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return messageService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param message
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	public Result add(@RequestBody TbMessage message){
		if(!StringUtils.isEmpty(message.getId())) {
			try {
				message.setCreatetime(DateUtils.getCurrent());
				messageService.add(message);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				messageService.update(message);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
	
	}
	
	/**
	 * 修改
	 * @param message
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbMessage message){
		try {
			messageService.update(message);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbMessage findOne(Integer id){
		return messageService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbMessage message){
		try {
			messageService.delete(message.getId());
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbMessage message=new TbMessage();
		if(!StringUtils.isEmpty(key)) {
//			message.
		}
		return messageService.findPage(message, page, limit);		
	}
	
}
