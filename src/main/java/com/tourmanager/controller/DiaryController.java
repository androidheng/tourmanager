package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbDiary;
import com.tourmanager.service.DiaryService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryService diaryService;
	
	/**
	 * 返回列表通过key
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findByKeyAll")
	public Result findByKeyAll(String key){	
		List<TbDiary> list = diaryService.findByKeyAll(key);
		return new Result(true, list);
	}
	@ResponseBody
	@RequestMapping("/findNoLoginAll")
	public Result findNoLoginAll(String key){	
		List<TbDiary> list = diaryService.findNoLoginAll();
		return new Result(true, list);
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbDiary> findAll(){			
		return diaryService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return diaryService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param diary
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Result add(@RequestBody TbDiary diary){
		try {
			diary.setClicks(0);
			diaryService.add(diary);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param diary
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbDiary diary){
		try {
			diaryService.update(diary);
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
	public TbDiary findOne(Integer id){
		return diaryService.findOne(id);		
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
			diaryService.delete(ids);
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
		TbDiary diary=new TbDiary();
		diary.setTitle(key);
		return diaryService.findPage(diary, page, limit);		
	}
	
}
