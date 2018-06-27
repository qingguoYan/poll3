package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	@GetMapping("findAllClazz")
	/**
	 * 调用util下MsgResponse.java文件下返回信息
	 * @return
	 */
	//List<Clazz> findAll() throws Exception;
	public MsgResponse findAllClazz(){	
		try {
		List<Clazz> list=clazzService.findAll();
		return MsgResponse.success("success", list);
		}
		catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){	
		try {
		List<ClazzVM> list=clazzService.findAllClazzVM();
		return MsgResponse.success("success", list);
		}
		/*
		 * 错误返回信息
		 */
		catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findByIdClazz")
	public MsgResponse findByIClazz(@RequestParam long id){
		try {
			Clazz clazz = clazzService.findById(id);
			return MsgResponse.success("ID："+id+"find success",clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	//List<Course>query(String keywords) throws Exception;
	@GetMapping("findKeyWords")
	public MsgResponse findKeyWords(String keywords){
		try {
			List<Clazz> list=clazzService.query(keywords);
			return MsgResponse.success("find key words:"+keywords,list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//void saveOrUpdate(Clazz clazz) throws Exception;
	@PostMapping("saveorUpdateClazz")
	public MsgResponse saveorUpdateClazz(Clazz clazz){
		try {
			clazzService.saveOrUpdate(clazz);
			
			return MsgResponse.success("更改数据成功",clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//void deleteById(long id)throws Exception;
	@GetMapping("deleteByIdClazz")
	public MsgResponse deleteByIdClazz(@RequestParam long id){
		try {
			clazzService.deleteById(id);
			return MsgResponse.success("DELETE：",id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//void batchDelete(List<Long> ids)throws Exception;
	@GetMapping("batchDeleteClazz")
	public MsgResponse batchDeleteClazz(@RequestParam List<Long> ids){
		try {
			clazzService.batchDelete(ids);
			return MsgResponse.success("batchDeleteClazz：",ids);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
