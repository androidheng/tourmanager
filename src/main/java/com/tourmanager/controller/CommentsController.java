package com.tourmanager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.tourmanager.pojo.TbComments;
import com.tourmanager.service.CommentsService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbComments> findAll(){			
		return commentsService.findAll();
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
	@RequestMapping("/add")
	public Result add(@RequestBody TbComments comments){
		try {
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
	@RequestMapping("/findOne")
	public TbComments findOne(Integer id){
		return commentsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
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
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbComments comments=new TbComments();
		if(!StringUtils.isEmpty(key)) {
			comments.setAid(Integer.parseInt(key));
		}
		return commentsService.findPage(comments, page, limit);		
	}
	
}
