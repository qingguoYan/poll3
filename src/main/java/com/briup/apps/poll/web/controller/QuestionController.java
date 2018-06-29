package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题模块接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@ApiOperation(value="删除问题",notes="同时级联删除options")
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionQuestionById(long id){
		try{
			questionService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		}catch(Exception e){
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或者更新问题",notes="如果id为空，执行保存操作，如果id不为空，执行更新操作")
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestion(QuestionVM questionVM){
         try {
			questionService.saveOrUpdateQuestionVM(questionVM);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	
	}
	
	@ApiOperation(value="查找所有问题",notes="并查找出所有问题的选项")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try{
			 List<QuestionVM> list=questionService.findAll();
			 return MsgResponse.success("success", list);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
	
	@ApiOperation(value="批量删除问题",notes="输入问题id")
	@GetMapping("deleteBatch")
	public MsgResponse deleteBatch(Long[] ids){
		try{
			 questionService.deleteBach(ids);
			 return MsgResponse.success("success", null);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
	
	@ApiOperation(value="关键字查询",notes="输入题目的关键字")
	@GetMapping("findByQuery")
	public MsgResponse findByQuery(String keywords){
		try{
			 List<Question> list=questionService.query(keywords);
			 return MsgResponse.success("success", list);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
	}

