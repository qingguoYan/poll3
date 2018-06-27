package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程相关的接口")
@RestController
@RequestMapping("/course")//通过什么路由访问
public class CourseController {
	
	@Autowired//依赖注入（为了调用service层的代码）
	private ICourseService courseService;
	
	@ApiOperation(value="查询所有课程信息",notes="单表")
	@GetMapping("findAllCourse")//参数和方法类保持一致
	public  MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			//返回成功信息
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询课程信息")
	@GetMapping("findByIdCourse")
	public  MsgResponse findCourseByIdl(@RequestParam long id){
		try {
			Course course=courseService.findById(id);
			//返回成功信息
			return MsgResponse.success("success",course);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过关键字模糊查询课程信息")
	@GetMapping("findAllKeywords")
	/*
	 * 通过关键字模糊查询
	 */
	public MsgResponse findAllKeywords(String keywords)
	{
		try
		{
			return MsgResponse.success("success",courseService.query(keywords));
		}catch(Exception e)
		{
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	@ApiOperation(value="保存和更新课程信息")
	@GetMapping("saveOrUpdateCourse")
	public  MsgResponse saveOrUpdate(Course course){
		try {
		     courseService.saveOrUpdate(course);
			//返回成功信息
			return MsgResponse.success("success",course);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="单个删除课程信息")
	  @GetMapping("deleteCourseById")
	  public MsgResponse deleteCourseById(@RequestParam long id){
		  //调用service层代码完成课程信息的删除
		  try {
			courseService.deleteById(id);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 
	  }
	
	@ApiOperation(value="批量删除课程信息")
	  @GetMapping("batchDelete")
	  public MsgResponse batchDelete(@RequestParam List<Long> ids){
		  try {
			 courseService.batchDelete(ids);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 
	  }
	}


