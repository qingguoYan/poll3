package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
  List<Course> findAll() throws Exception;
  Course findById(long id) throws Exception;//id搜索
  List<Course> query(String keywords) throws Exception;//关键字搜索
 
  void deleteById(long id) throws Exception;
  void batchDelete(List<Long> ids) throws Exception;//批量删除
  void saveOrUpdate(Course course) throws Exception;//保存或者
}
