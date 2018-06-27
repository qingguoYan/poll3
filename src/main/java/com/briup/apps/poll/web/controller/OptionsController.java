package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="问题选项模块接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	
	@PostMapping("saveOrUpdate")
	public String save(Options options){
		try{
			optionsService.saveOrUpdate(options);	
			return "操作成功";
			 
		}catch(Exception e){
			e.printStackTrace();
			return "操作失败"+e.getMessage();
		}
	}
	
	@PostMapping("deleteById")
	public String deleteById(long id){
		try{
			optionsService.deleteById(id);	
			return "操作成功";
			 
		}catch(Exception e){
			e.printStackTrace();
			return "操作失败"+e.getMessage();
		}
	}
	
	@PostMapping("findById")
	public MsgResponse findById(@RequestParam long id){
		try{
			Options options=optionsService.findById(id);
			 return MsgResponse.success("success", options);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
	
//	@PostMapping("query")
//	public MsgResponse query(String keywords){
//		try{
//			List<Options> list=optionsService.query(keywords);
//			 return MsgResponse.success("success", list);
//			}catch(Exception e){
//				e.printStackTrace();
//				return MsgResponse.error(e.getMessage());
//			}	
//	}
	@GetMapping("findAllOptions")
	public MsgResponse findAllQuestion(){
		try{
			 List<Options> list=optionsService.findAll();
			 return MsgResponse.success("success", list);
			}catch(Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}	
		}
}
