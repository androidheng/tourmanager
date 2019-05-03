package com.tourmanager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tourmanager.pojo.TbGrade;
import com.tourmanager.service.GradeService;
import com.tourmanager.utils.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbGrade> findAll(){			
		return gradeService.findAll();
	}
	@ResponseBody
	@RequestMapping("/findAllByName")
	public Result findAllByName(@RequestBody TbGrade grade){			
		return new Result(true, gradeService.findAllByName(grade.getAttrname())) ;
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return gradeService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param grade
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbGrade grade){
		if(StringUtils.isEmpty(grade.getId())) {
			try {
			grade.setCreatetime(DateUtils.getCurrentDay());	
			gradeService.add(grade);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			gradeService.update(grade);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
		}
		
	}
	

	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOne")
	public TbGrade findOne(Integer id){
		return gradeService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(Integer id){
		try {
			gradeService.delete(id);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param key
	 * @param page
	 * @param limit
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key, int page, int limit  ){
		TbGrade grade=new TbGrade();
		if(!StringUtils.isEmpty(key)) {
			
		}
		return gradeService.findPage(grade, page, limit);		
	}
	
}
