package com.briup.apps.poll.service.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.service.IQuestionnaireService;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{
    @Autowired
    private QuestionnaireMapper questionnnaireMapper;
	@Override
	//查询所有信息
	public List<Questionnaire> findAll() throws Exception {
		//模板里面有很多特性
		QuestionnaireExample example=new QuestionnaireExample();
		//空模板，没有任何条件
		return questionnnaireMapper.selectByExampleWithBLOBs(example);
	} 
	//通过id查询
	@Override
	public Questionnaire findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnnaireMapper.selectByPrimaryKey(id);
	}
	
	//关键字查询
	@Override
	public List<Questionnaire> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		QuestionnaireExample example=new QuestionnaireExample();
		//添加一个条件，name属性中包含keywords关键字
	    example.createCriteria().andNameLike(keywords);
	    return questionnnaireMapper.selectByExample(example);
	}
	//保存或者更新
	@Override
	public void saveOrUpdate(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		if(questionnaire.getId()!=null){
			//更新
			questionnnaireMapper.updateByPrimaryKey(questionnaire);
		}else{
			//插入
			questionnnaireMapper.insert(questionnaire);
		}
		
	}
	//删除
	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionnnaireMapper.deleteByPrimaryKey(id);		
	}
	//批量删除,循环着去删除 ids是一个集合，每次从ids里面取一个id去删除
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id : ids){
			questionnnaireMapper.deleteByPrimaryKey(id);
		}
		
	}
}
