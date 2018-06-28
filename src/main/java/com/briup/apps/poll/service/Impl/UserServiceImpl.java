package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.bean.extend.UserVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.dao.extend.UserVMMapper;
import com.briup.apps.poll.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired	
	private UserMapper userMapper;
	@Autowired	
	private UserVMMapper userVMMapper;
	private ClazzMapper clazzMapper;
	
///查找全部
	@Override
	public List<User> findAll() throws Exception {
		UserExample example =new UserExample();
		return userMapper.selectByExample(example);
	
	}
	
	public List<UserVM> findAllVM() throws Exception {
		return userVMMapper.selectAll();
	} 
///查找全部

///通过ID查找
	@Override
	public User findById(long id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	}

///通过ID查找
	
///关键字查找
	@Override
	public List<User> query(String keywords) throws Exception {
		UserExample example =new UserExample();
		example.createCriteria().andNameLike(keywords);
		return userMapper.selectByExample(example);
	}
	@Override
	public List<UserVM> queryVM(String keywords) throws Exception {
		UserExample example =new UserExample();
		example.createCriteria().andNameLike(keywords);
		return userVMMapper.query(keywords);
	}
	

///关键字查找

///通过ID删除
	@Override
	public void deleteById(long id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
		
	}
	
///通过ID删除
	
///添加和保存
	@Override
	public void saveOrUpdate(User user) throws Exception {
		//ID不为空 更新一条记录
		if(user.getId()!=null){
			userMapper.updateByPrimaryKey(user);
		}
	    else{
		//ID为空 添加一条记录
		userMapper.insert(user);
	}
	}
	
	@Override
	public void save(UserVM userVM) throws Exception {
			User user = new User();
			user.setId(userVM.getId());
			user.setBirth(userVM.getBirth());
			user.setGender(userVM.getGender());
			user.setHiredate(userVM.getHiredate());
			user.setType(userVM.getType());
			userMapper.insert(user);
			List<Clazz> clazzs = userVM.getCalzz();
			for(Clazz clazz:clazzs){
				clazz.setChargeId(user.getId());
				clazzMapper.insert(clazz);
			}
		
		
	}
/// 添加和保存
	
///批量删除
	public void batchDelete(List<Long> ids) throws Exception{
		for(long id:ids){
			userMapper.deleteByPrimaryKey(id);
			
		}
		
	}
///批量删除



}
