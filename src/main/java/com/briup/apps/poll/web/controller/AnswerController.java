package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="答案相关接口")
@RestController
@RequestMapping("/answers")
public class AnswerController {

	@Autowired
	private IAnswersService answersService;
	@ApiOperation(value="查询所有答案",notes="一键查所有")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers(){
		try{
		 List<Answers> list=answersService.findAll();
		 return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="查询所有答案",notes="一键查所有答案携带问卷信息")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM(){
		try{
		 List<AnswersVM> list=answersService.findAllAnswersVM();
		 return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="保存更新答案信息",notes="保存答案的时候无需输入id")
	@PostMapping("saveOrUpdateAnswers")
	public MsgResponse saveOrUpdateAnswers(Answers answers) {
		try {
		    answersService.saveOrUpdate(answers);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id删除答案信息",notes="通过id删除")
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id) {
		try {
			answersService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="批量删除答案信息",notes="批量删除")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(List<Long> id) {
		try {
			answersService.batchDelete(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查询答案信息",notes="通过id查询")
	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			answersService.findById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="模糊查询答案信息",notes="模糊查询")
	@GetMapping("queryAnswers")
	public MsgResponse queryAnswers(String keywords) {
		try {
			List<Answers> list=answersService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
