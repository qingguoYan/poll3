package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireVMService;
@Service
public class QuestionnaireVMServiceImpl implements IQuestionnaireVMService{
@Autowired
private QuestionnaireMapper questionnaireMapper;

@Autowired
private QuestionnaireVMMapper questionnaireVMMapper;

@Autowired
private QuestionnaireQuestionMapper qqMapper;

	@Override
	public List<Questionnaire> findAll() {
		QuestionnaireExample example=new QuestionnaireExample();
		return questionnaireMapper.selectByExampleWithBLOBs(example);
		
	}

	@Override
	public List<QuestionnaireVM> findQuestionById(long id) {
		return questionnaireVMMapper.selectById(id);	
	}
   /*
    * 1.先分别得到问卷和问题实体
    * 2.判断是保存还是更新操作
    * 3.分别保存或者更新问卷和实体
    */
	@Override
	public void saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds) throws Exception {
	   
		
		if(questionnaire.getId()==null){
			//保存操作
		     questionnaireMapper.insert(questionnaire);
		     //维护问卷与问题的关系
		     long questionnaireId=questionnaire.getId();
		     for(long questionId: questionIds){
		    	 QuestionnaireQuestion qq=new QuestionnaireQuestion();
		    	 qq.setQuestionnaireId(questionnaireId);
		       	 qq.setQuestionId(questionId);
		    	 qqMapper.insert(qq);
		     }
		     
		     
		}else{
			/*
			 * 1.修改问卷信息
			 * 2.根据问卷id删除qeustionnairequestion中的问题
			 * 3.添加新的问题
			 */
			
			questionnaireMapper.updateByPrimaryKey(questionnaire);
			QuestionnaireQuestionExample example=new QuestionnaireQuestionExample();
			example.createCriteria().andIdEqualTo(questionnaire.getId());
			 for(long questionId: questionIds){
		    	 QuestionnaireQuestion qq=new QuestionnaireQuestion();
		       	 qq.setQuestionId(questionId);
		    	 qq.setQuestionnaireId(questionnaire.getId());
		    	 qqMapper.insert(qq);
		     }
			
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void deleteByBatchID(long[] ids) throws Exception {
		for(long id : ids){
			questionnaireMapper.deleteByPrimaryKey(id);
		}
		
	}

}
