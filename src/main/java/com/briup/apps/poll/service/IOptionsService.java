package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {

	List<Options> findAll() throws Exception;
	Options findById(long id) throws Exception;
//	List<Options> query(String keywords) throws Exception;
	void saveOrUpdate(Options options) throws Exception;
	void deleteById(long id) throws Exception;
}
