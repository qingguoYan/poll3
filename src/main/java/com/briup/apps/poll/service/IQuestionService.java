package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Question;

public interface IQuestionService {
	 List<Question>findAll() throws Exception;
	 Question findById(long id) throws Exception;
	 //关键字查询
	 List<Question> query(String keywords) throws Exception;
	 void saveOrUpdate(Question question) throws Exception;
	 void deleteById(long id) throws Exception;
	 
	 //批量删除
	 void batchDelete(List<Long> id) throws Exception;
}
