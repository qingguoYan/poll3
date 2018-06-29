package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

public interface IQuestionService {
	//查找所有问题，并查找出问题的所有选项
	 List<QuestionVM> findAll() throws Exception; 
	 
	 //更新或者保存问题，并保存更新问题选项
	 void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception;
	 
	 //删除问题，级联删除选项
	 void deleteById(long id) throws Exception;
	 
	 //关键字查询
	List<Question> query(String keywords) throws Exception;
	
	//批量删除题目
	
	void deleteBach(Long[] id)throws Exception;
}
