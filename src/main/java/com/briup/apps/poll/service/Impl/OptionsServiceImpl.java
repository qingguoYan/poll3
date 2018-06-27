package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;

import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;
@Service
public class OptionsServiceImpl implements IOptionsService{
@Autowired
  private OptionsMapper optionsMapper;
	@Override
	public List<Options> findAll() throws Exception {
		OptionsExample example=new OptionsExample();
		return optionsMapper.selectByExample(example);
	}

	@Override
	public Options findById(long id) throws Exception {
		return optionsMapper.selectByPrimaryKey(id);
	}

//	@Override
//	public List<Options> query(String keywords) throws Exception {
//		
//		OptionsExample example=new OptionsExample();
//		example.createCriteria().andNameLike(keywords);
//		return optionsMapper.selectByExample(example);
//	}

	@Override
	public void saveOrUpdate(Options options) throws Exception {
		if( options.getId()!=null){
			optionsMapper.updateByPrimaryKey(options);
		}
		else{
			optionsMapper.insert(options);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		optionsMapper.deleteByPrimaryKey(id);
		
	}

}
