package com.briup.apps.poll.web.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问卷相关接口")
@RestController
@RequestMapping("/")
public class QuestionnaireQuestionController {
	
	@Autowired
	private IQuestionnaireQuestionService questionnaireQuestionService;
	
	@ApiOperation(value="查询问卷调查信息",notes="包括问题信息")
	@GetMapping("/findAllVM")
	public MsgResponse findAllVM(){
		try {
			List<QuestionnaireQuestionVM> list=questionnaireQuestionService.findAllVM();
			return MsgResponse.success("success",list);
		} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存更新问卷问题信息",notes="保存问卷问题信息的时候无需输入id")
	@PostMapping("saveOrUpdateQQVM")
	public MsgResponse saveOrUpdateQQVM(QuestionnaireQuestionVM questionnaireQuestionVM) {
		try {
			questionnaireQuestionService.saveOrUpdate(questionnaireQuestionVM);
			return MsgResponse.success("success", questionnaireQuestionVM);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
