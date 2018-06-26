package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.IcourseService;
@Service
public class CourseServiceImpl implements IcourseService{
@Autowired
private CourseMapper courseMapper;
	@Override
	public List<Course> findAll() throws Exception {
		CourseExample example=new CourseExample();
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Course findById(long id) throws Exception {
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Course> query(String keywords) throws Exception {
		CourseExample example=new CourseExample();
	    example.createCriteria().andNameLike(keywords);;
	    return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Course course) throws Exception {
		if(course.getId()!=null){
			courseMapper.updateByPrimaryKey(course);
		}
		else{
			courseMapper.insert(course);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		
		courseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id : ids){
			courseMapper.deleteByPrimaryKey(id);
		}
		
	}

}
