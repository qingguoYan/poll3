package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;

public interface IGradeService {
	
	
	/*
	 *查询所有 
	 */
	List<Grade> findAll() throws Exception;
	/*
	 * ID查询
	 */
	List<GradeVM> findAllGradeVM() throws Exception;
	GradeVM findById(long id)throws Exception;
	/*
	 *关键字查询
	 */
	List<GradeVM> query(String keywords) throws Exception;
	/*
	 * 
	 */
	void saveOrUpdate(Grade grade) throws Exception;
	void deleteById(long id)throws Exception;
	void batchDelete(List<Long> ids)throws Exception;

}
