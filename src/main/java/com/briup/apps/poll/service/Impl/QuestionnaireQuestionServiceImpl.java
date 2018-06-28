package com.briup.apps.poll.service.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.extend.QuestionnaireQuestionVM;
import com.briup.apps.poll.dao.extend.QuestionnaireQuestionVMMapper;
import com.briup.apps.poll.service.IQuestionnaireQuestionService;
@Service
public class QuestionnaireQuestionServiceImpl implements IQuestionnaireQuestionService{
    @Autowired
    private QuestionnaireQuestionVMMapper questionnaireQuestionVMMapper;

	@Override
	public List<QuestionnaireQuestionVM> findAllVM() throws Exception {
		// TODO Auto-generated method stub
		return questionnaireQuestionVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(QuestionnaireQuestionVM questionnaireQuestionVM) throws Exception {
		// TODO Auto-generated method stub
		questionnaireQuestionVMMapper.saveOrUpdate(questionnaireQuestionVM);
		if(questionnaireQuestionVM.getId()!=null){
			//更新
			questionnaireQuestionVMMapper.updateByPrimaryKey(questionnaireQuestionVM);
		}else{
			//插入
			questionnaireQuestionVMMapper.insert(questionnaireQuestionVM);
		}
		
	}
}
