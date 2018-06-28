package com.briup.apps.poll.service;

import java.util.List;


import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
 
	List<Survey> findAll()throws Exception;
	
	List<SurveyVM> findAllSurveyVM() throws Exception;
	
	Survey findById(long id)throws Exception;
	
	SurveyVM findByIdSurveyVM(long id)throws Exception;
	
	List<SurveyVM> queryVM(String keywords) throws Exception;
	/*
	 * 关键字查询
	 */

	List<Survey> query(String keywords)throws Exception;
	/*
	 * 
	 */
	void saveOrUpdate(Survey survey)throws Exception;
	
	void deleteById(long id)throws Exception;
	
	void batchDelete(List<Long> ids)throws Exception;
}
