package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbFeedback;
import com.tourmanager.service.FeedbackService;
import com.tourmanager.utils.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<TbFeedback> findAll(){			
		return feedbackService.findAll();
	}
	/**
	 * 返回全部列表 根据用户id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllByUId")
	public Result findAllByUId(@RequestBody TbFeedback feedback){			
		return new Result(true, feedbackService.findAllByUId(feedback.getUid()));
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return feedbackService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param feedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Result add(@RequestBody TbFeedback feedback){
		try {
			feedback.setCreatetime(DateUtils.getCurrent());
			feedbackService.add(feedback);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param feedback
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbFeedback feedback){
		try {
			feedbackService.update(feedback);
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
	@ResponseBody
	@RequestMapping("/findOne")
	public TbFeedback findOne(Integer id){
		return feedbackService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			feedbackService.delete(ids);
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
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbFeedback feedback=new TbFeedback();
		if(!StringUtils.isEmpty(key)) {
			feedback.setUsername(key);
		}
		return feedbackService.findPage(feedback, page, limit);		
	}
	
}
