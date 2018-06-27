package com.briup.apps.poll.web.controller;

import java.util.List;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="学校相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
@Autowired
private ISchoolService schoolService;
@ApiOperation(value="查询学校信息",notes="单表")
@GetMapping("findAllSchool")
public MsgResponse findAllSchool(){
try{
	List<School>list=schoolService.findAll();
	//返回成功信息
	return MsgResponse.success("success", list);
}catch (Exception e){
	e.printStackTrace();
	//返回失败信息
	return MsgResponse.error(e.getMessage());
}
}
@ApiOperation(value="通过关键字查询")
@GetMapping("findAllKeywords")
/*
 * 通过关键字模糊查询
 */
public MsgResponse findAllKeywords(String keywords)
{
	try
	{
		return MsgResponse.success("success",schoolService.query(keywords));
	}catch(Exception e)
	{
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="Id搜索学校信息")
@GetMapping("findById")
public MsgResponse findSchoolById(@RequestParam long id){
		try {
			School school= schoolService.findById(id);
			//返回成功信息
			return MsgResponse.success("success",school );
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
@ApiOperation(value="保存或修改学校信息")
@GetMapping("saveOrupdateSchool")
public MsgResponse saveOrupdateSchool(School school){
	  //调用service层代码完成课程信息的删除
	  try {
		schoolService.saveOrupdate(school);
		return MsgResponse.success("success", "成功");
	  }catch (Exception e){
	  	e.printStackTrace();
	  	//返回失败信息
	  	return MsgResponse.error(e.getMessage());
	  }
}
@GetMapping("deleteSchoolById")
public MsgResponse deleteSchoolById(@RequestParam long id){
	  //调用service层代码完成课程信息的删除
	  try {
		schoolService.deleteById(id);
		return MsgResponse.success("success", "删除成功");
	  }catch (Exception e){
	  	e.printStackTrace();
	  	//返回失败信息
	  	return MsgResponse.error(e.getMessage());
	  }
	 
}
@ApiOperation(value="批量删除学校信息")
@GetMapping("batchDelete")
public MsgResponse batchDelete(@RequestParam List<Long> ids){
	  try {
		 schoolService.batchDelete(ids);
		return MsgResponse.success("success","删除成功");
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	} 
}

}