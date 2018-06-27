package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;


public interface IAnswersService {

	List<Answers>findAll() throws Exception;
	List<AnswersVM> findAllAnswersVM() throws Exception;
	 Answers findById(long id) throws Exception;
	 //关键字查询
	 List<Answers> query(String keywords) throws Exception;
	 void saveOrUpdate(Answers answer) throws Exception;
	 void deleteById(long id) throws Exception;
	 
	 //批量删除
	 void batchDelete(List<Long> id) throws Exception;
}
