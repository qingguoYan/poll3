package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;
@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
    @Autowired
    private SurveyVMMapper surveyVMMapper;
    
	@Override
	public List<Survey> findAll() throws Exception {
		SurveyExample example=new SurveyExample();
		return surveyMapper.selectByExample(example);
	}

	@Override
	public Survey findById(long id) throws Exception {
	
		return surveyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Survey> query(String keywords) throws Exception {
		SurveyExample example=new SurveyExample();
		example.createCriteria().andCodeLike("%"+keywords+"%");
		return surveyMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Survey survey) throws Exception {
		if(survey.getId()!=null){
			surveyMapper.updateByPrimaryKey(survey);
		}else{
			surveyMapper.insert(survey);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		surveyMapper.deleteByPrimaryKey(id);
	
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids){
			surveyMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		
		return surveyVMMapper.selectAll();
	}

	@Override
	public SurveyVM findByIdSurveyVM(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.findByIdSurveyVM(id);
	}

	@Override
	public List<SurveyVM> queryVM(String keywords) throws Exception {
		/*SurveyExample example=new SurveyExample();
		example.createCriteria().andCodeLike("%"+keywords+"%");*/
		return surveyVMMapper.queryVM(keywords);
	}

	}


	

