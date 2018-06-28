package com.briup.apps.poll.dao.extend;
import java.util.List;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
public interface QuestionnaireQuestionVMMapper {
	List<QuestionnaireQuestionVM> selectAll();
	void saveOrUpdate(QuestionnaireQuestionVM questionnaireQuestionVM);
	void insert(QuestionnaireQuestionVM questionnaireQuestionVM);
	void updateByPrimaryKey(QuestionnaireQuestionVM questionnaireQuestionVM);
} 
