package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.extend.UserVM;

public interface IUserService  {
	/*
	 * 查询所有数据
	 */
	List<User> findAll() throws Exception;
	
	List<UserVM> findAllVM() throws Exception;
	/*
	 * 通过ID查询一行数据
	 */
	User findById(long id) throws Exception;
	
	
	/*
	 * 通过关键字查询一行数据
	 */
    List<User> query(String keywords) throws Exception;
    
    List<UserVM> queryVM(String keywords) throws Exception;
	/*
	 * 通过删除一行数据
	 */
	void deleteById(long id) throws Exception;
	/*
	 * 保存和更新数据
	 */
	void saveOrUpdate(User user) throws Exception;
	
	void save(UserVM userVM) throws Exception;
	/*
	 * 批量删除
	 */
	void batchDelete(List<Long> ids) throws Exception;
	
	
	
	
	
	
	
}
