package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.Answers;

public interface AnswersVMMapper {

	List<Answers>findAll() throws Exception;
	 Answers findById(long id) throws Exception;
	 //关键字查询
	 List<Answers> query(String keywords) throws Exception;
	 void saveOrUpdate(Answers answer) throws Exception;
	 void deleteById(long id) throws Exception;
	 
	 //批量删除
	 void batchDelete(List<Long> id) throws Exception;
}
