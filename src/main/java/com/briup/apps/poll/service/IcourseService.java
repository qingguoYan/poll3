package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface IcourseService {
 List<Course>findAll() throws Exception;
 Course findById(long id) throws Exception;
 //关键字查询
 List<Course> query(String keywords) throws Exception;
 void saveOrUpdate(Course course) throws Exception;
 void deleteById(long id) throws Exception;
 
 //批量删除
 void batchDelete(List<Long> id) throws Exception;
}
