package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;

public interface IClazzService {
	/*
	 *查询所有 
	 */
	List<Clazz> findAll() throws Exception;
	/*
	 * ID查询
	 */
	List<ClazzVM> findAllClazzVM() throws Exception;
	Clazz findById(long id)throws Exception;
	/*
	 *关键字查询
	 */
	List<Clazz>query(String keywords) throws Exception;
	/*
	 * 
	 */
	void saveOrUpdate(Clazz clazz) throws Exception;
	void deleteById(long id)throws Exception;
	void batchDelete(List<Long> ids)throws Exception;

}
