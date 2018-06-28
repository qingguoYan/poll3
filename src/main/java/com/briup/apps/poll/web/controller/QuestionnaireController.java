package com.briup.apps.poll.web.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问卷相关接口")
@RestController
@RequestMapping("/Questionnaire")
public class QuestionnaireController {
	@Autowired
	private IQuestionnaireService questionnaireService;
	
	@ApiOperation(value="查询所有问卷调查信息",notes="查询所有")
	@GetMapping("findAllQuestionaire")
	public MsgResponse findAllAnswers(){
		try{
		 List<Questionnaire> list=questionnaireService.findAll();
		 return MsgResponse.success("success", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="通过id查询问卷信息",notes="id查询")
	@GetMapping("findAllQuestionnaireById")
	public MsgResponse findAllById(long id){
		try {
			questionnaireService.findById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="模糊查询",notes="通过关键字查询")
	@GetMapping("findAllQuestionnaireQuery")
	      public MsgResponse  findAllQery(String keywords){
		try {
			List<Questionnaire> list=questionnaireService.query(keywords);
			return MsgResponse.success("success", list);
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存更新问卷信息",notes="保存问卷信息的时候无需输入id")
	@PostMapping("saveOrUpdateQuestionnaire")
	public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire) {
		try {
			questionnaireService.saveOrUpdate(questionnaire);
			return MsgResponse.success("success", questionnaire);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="删除问卷信息",notes="删除信息通过id")
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			questionnaireService.deleteById(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
			
	@ApiOperation(value="批量删除问卷信息",notes="批量删除")
	@PostMapping("batchDelete")
	public MsgResponse  batchDelete(List<Long> ids){
		try {
			questionnaireService.batchDelete(ids);
			return MsgResponse.success("success",ids);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}