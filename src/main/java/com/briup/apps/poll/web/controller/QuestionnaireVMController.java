package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireVMService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问卷模块接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireVMController {
@Autowired
private IQuestionnaireVMService qnvs;



@ApiOperation(value="查找所有问卷",notes="仅仅只查找问卷")
@PostMapping("findAllQuestionnaire")

public MsgResponse findAllQuestionnaire(){
         try{
        	 List<Questionnaire> list=qnvs.findAll();
        	return MsgResponse.success("success", list);
         }catch(Exception e){
        	 e.printStackTrace();
        	 return MsgResponse.error(e.getMessage());
         }
}

@ApiOperation(value="预览问卷信息",notes="预览包括问卷上的问题")
@GetMapping("findAllQuestionnaireById")
public MsgResponse findAllQuestionnaireById(long id){
	try{
		List<QuestionnaireVM> list=qnvs.findQuestionById(id);
		return MsgResponse.success("success", list);
	}catch(Exception e){
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
  }

@ApiOperation(value="更新或者保存问题",notes="如果id为空，为保存操作，否则为更新操作")
@GetMapping("saveOrUpdateQuestionnaire")
public MsgResponse savaOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
	try{
	
		qnvs.saveOrUpdateQuestionnaire(questionnaire, questionIds);
		
		return MsgResponse.success("success", null);
	}catch(Exception e){
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
 }

@ApiOperation(value="删除问卷",notes="会把问卷和问题的关系删除掉,但是保留问题")
@GetMapping("deleteById")
public MsgResponse deleteById(long id){
	try{
	qnvs.deleteById(id);
	return MsgResponse.success("success", null);
	}catch(Exception e){
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}

@ApiOperation(value="批量删除问卷",notes="会把问卷和问题的关系删除掉,但是保留问题")
@GetMapping("deleteByBatchId")
public MsgResponse deleteByBatchId(long[] ids){
	try{
	qnvs.deleteByBatchID(ids);
	return MsgResponse.success("success", null);
	}catch(Exception e){
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
}