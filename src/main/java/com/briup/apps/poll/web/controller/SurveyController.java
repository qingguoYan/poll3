package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程调查相关接口")
@RestController
@RequestMapping("/Survey")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询所有课程调查",notes="单表")
	@PostMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try{
			List<Survey> list=surveyService.findAll();
			//返回成功信息
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有课程调查",notes="课程调查中包含，班级等信息")
	@PostMapping("findAllVM")
	public MsgResponse findAllVM(){
		try{
			List<SurveyVM> list=surveyService.findAllSurveyVM();
			//返回成功信息
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("findById")
	public MsgResponse findById(@RequestParam long id){
		try{
			Survey survey=surveyService.findById(id);
			//返回成功信息
			return MsgResponse.success("success",survey);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("findByIdVM")
	public MsgResponse findByIdVM(@RequestParam long id){
		try{
			SurveyVM survey=surveyService.findByIdSurveyVM(id);
			//返回成功信息
			return MsgResponse.success("success",survey);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("findkeywords")
	public MsgResponse query(String keywords){
		try{
			List<Survey> list=surveyService.query(keywords);
			//返回成功信息
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("findkeywordsVM")
	public MsgResponse queryVM(String keywords){
		try{
			List<SurveyVM> list=surveyService.queryVM(keywords);
			//返回成功信息
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	

	@PostMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Survey survey){
		try{
			surveyService.saveOrUpdate(survey);
			//返回成功信息
			return MsgResponse.success("success",survey);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(@RequestParam long id){
		try{
			surveyService.deleteById(id);
			//返回成功信息
			return MsgResponse.success("success",id);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("batchdeleteSurvey")
	public MsgResponse batchDeleteSurvey(@RequestParam List<Long> ids){
		try{
			surveyService.batchDelete(ids);
			//返回成功信息
			return MsgResponse.success("success",ids);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
}
