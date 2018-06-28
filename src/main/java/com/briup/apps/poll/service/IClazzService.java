package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;

public interface IClazzService {
	/*
	 *查询所有 
	 */
	List<Clazz> findAll() throws Exception;
	List<ClazzVM> findAllClazzVM() throws Exception;
	void saveOrUpdate(ClazzVM clazzVM) throws Exception;
	ClazzVM selectById(long id)throws Exception;
	/*
	 *关键字查询
	 */
	List<ClazzVM> query(String keywords) throws Exception;
	/*
	 * 
	 */
	
	void deleteById(long id)throws Exception;
	void batchDelete(List<Long> ids)throws Exception;

}
