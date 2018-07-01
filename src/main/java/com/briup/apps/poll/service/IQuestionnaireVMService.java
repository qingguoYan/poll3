package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireVMService {
	//查询所有问卷
   List<Questionnaire> findAll() throws Exception;
   
   //查询所有问卷及问卷的问题
   List<QuestionnaireVM> findQuestionById(long id) throws Exception;
   
   //保存或更新问卷信息
   
   void saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds) throws Exception;
   
   //删除问卷
   void deleteById(long id) throws Exception;
   
   //批量删除
   void deleteByBatchID(long[] ids)throws Exception;
}
