package com.briup.apps.poll.service;
import java.util.List;
import com.briup.apps.poll.bean.Questionnaire;

public interface IQuestionnaireService {
	//查询所有
	List<Questionnaire> findAll() throws Exception;
	//通过id查询
	Questionnaire findById(long id) throws Exception;
	 //关键字查询
	 List<Questionnaire> query(String keywords) throws Exception;
	 //保存或者更新
	 void saveOrUpdate(Questionnaire questionnaire) throws Exception;
	 //通过id删除
	 void deleteById(long id) throws Exception;
	 //批量删除
	 void batchDelete(List<Long> ids) throws Exception;
}
