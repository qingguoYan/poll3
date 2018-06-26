package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="问题模块接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	@PostMapping("batchDelete")
	public String batchDelete(List<Long> id){
		try{
			System.out.println("开始进行删除工作");
			questionService.batchDelete(id);
			return "操作成功";
		}catch(Exception e){
			return "操作失败"+e.getMessage();
		}
	}
	@PostMapping("saveOrUpdate")
	public String save(Question question){
		try{
			questionService.saveOrUpdate(question);	
			return "操作成功";
			 
		}catch(Exception e){
			e.printStackTrace();
			return "操作失败"+e.getMessage();
		}
	}
	
	@PostMapping("deleteById")
	public String deleteById(long id){
		try{
			questionService.deleteById(id);	
			return "操作成功";
			 
		}catch(Exception e){
			e.printStackTrace();
			return "操作失败"+e.getMessage();
		}
	}
	
	@PostMapping("findById")
	public MsgResponse findById(@RequestParam long id){
		try{
			Question qustion=questionService.findById(id);
			 return MsgResponse.success("success", qustion);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
	
	@PostMapping("query")
	public MsgResponse query(String keywords){
		try{
			List<Question> list=questionService.query(keywords);
			 return MsgResponse.success("success", list);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
	}
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try{
			 List<Question> list=questionService.findAll();
			 return MsgResponse.success("success", list);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
	}

