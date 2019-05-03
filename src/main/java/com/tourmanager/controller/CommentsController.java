package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbComments;
import com.tourmanager.service.CommentsService;
import com.tourmanager.utils.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public Result findAll(@RequestBody TbComments comments){			
		return new Result(true,commentsService.findAll(comments.getAttrname())) ;
	}
	@ResponseBody
	@RequestMapping("/findAllByUid")
	public Result findAllByUid(@RequestBody TbComments comments){			
		return new Result(true,commentsService.findAllByUid(comments.getUid())) ;
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return commentsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param comments
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Result add(@RequestBody TbComments comments){
		try {
			comments.setCreatetime(DateUtils.getCurrentDay());
			commentsService.add(comments);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param comments
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbComments comments){
		try {
			commentsService.update(comments);
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
	public TbComments findOne(Integer id){
		return commentsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			commentsService.delete(ids);
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
		TbComments comments=new TbComments();
		if(!StringUtils.isEmpty(key)) {
			comments.setAttrname(key);
		}
		return commentsService.findPage(comments, page, limit);		
	}
	
}
