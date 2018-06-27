package com.briup.apps.poll.dao.extend;

import java.util.List;


import com.briup.apps.poll.bean.extend.AnswersVM;

public interface AnswersVMMapper {

	List<AnswersVM>findAll() throws Exception;
	 AnswersVM findById(long id) throws Exception;
	 //关键字查询
	 List<AnswersVM> query(String keywords) throws Exception;
	 void saveOrUpdate(AnswersVM answer) throws Exception;
	 void deleteById(long id) throws Exception;
	 
	 //批量删除
	 void batchDelete(List<Long> id) throws Exception;
}
