package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.service.IClazzService;
@Service
public class ClazzServiceImpl implements IClazzService{
	@Autowired
	private ClazzMapper clazzMapper;
	
	@Autowired
	private ClazzVMMapper clazzVMMapper;

	@Override
	public List<Clazz> findAll() throws Exception {
		// TODO Auto-generated method stub
		ClazzExample example=new ClazzExample();
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Clazz findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return clazzMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Clazz> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		ClazzExample example=new ClazzExample();
		example.createCriteria().andNameLike(keywords);
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		if (clazz.getId()!=null) {
			clazzMapper.updateByPrimaryKeyWithBLOBs(clazz);
			}else {
				clazzMapper.insert(clazz);
			}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			clazzMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		return clazzVMMapper.SelectAll();
	}


	

}
