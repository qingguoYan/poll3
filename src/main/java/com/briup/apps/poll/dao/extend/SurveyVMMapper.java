package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.SurveyVM;

public interface SurveyVMMapper {
	
	List<SurveyVM> selectAll() throws Exception;
	
	
	 SurveyVM findByIdSurveyVM(long id) throws Exception;
	 //关键字查询
	 List<SurveyVM> queryVM(String keywords) throws Exception;



}
