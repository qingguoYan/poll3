package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.extend.UserVM;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired	
	private IUserService userService;
	

///查找全部
	@GetMapping("findAllUser") 
	public MsgResponse findAllUser(){
		try{
			List<User> list =userService.findAll();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
	        return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所以教师信息",notes="教师用户信息中包含的班级信息")
	@GetMapping("findAllUserVM") 
	public MsgResponse findAllUserVM(){
		try{
			List<UserVM> list =userService.findAllVM();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
	        return MsgResponse.error(e.getMessage());
		}
	}
///查找全部
	
///通过ID查找
	@GetMapping("findByIdUser") 
    public MsgResponse findByIdUser(long id){
    	try{
			User user =userService.findById(id);
			return MsgResponse.success("success",user);
		}catch(Exception e){
			e.printStackTrace();
	        return MsgResponse.error(e.getMessage());
    }
    }
///通过ID查找
	
///关键字查找
	@GetMapping("queryUser") 
    public MsgResponse queryUser(String keywords){
        try{
        	List<User> list =userService.query(keywords);
    		return MsgResponse.success("success",list);
    	}catch(Exception e){
    		e.printStackTrace();
    	    return MsgResponse.error(e.getMessage());
    }
    }
	
	@GetMapping("queryUserVM") 
    public MsgResponse queryUserVM(String keywords){
        try{
        	List<UserVM> list =userService.queryVM(keywords);
    		return MsgResponse.success("success",list);
    	}catch(Exception e){
    		e.printStackTrace();
    	    return MsgResponse.error(e.getMessage());
    }
    }
    
///关键字查找
	
///通过ID查找
	@GetMapping("deleteByIdUser") 
    public MsgResponse deleteByIdUser(long id){
        		
        try{
        	userService.deleteById(id);
		    return MsgResponse.success("success",id);
        }catch(Exception e){
        	e.printStackTrace();
        	return MsgResponse.error(e.getMessage());
    }	
	}
///通过ID查找
	
///保存和更新
	@GetMapping("saveOrUpdateUser") 
	 public MsgResponse saveOrUpdateUser(User user){
	    	try{
	    		userService.saveOrUpdate(user);
	    		return MsgResponse.success("success",user);
	    	}catch(Exception e){
	        	e.printStackTrace();
	        	return MsgResponse.error(e.getMessage());
	    }		
	    }
	
	@GetMapping("saveUserVM") 
	 public MsgResponse saveUserVM(UserVM userVM){
	    	try{
	    		userService.save(userVM);
	    		return MsgResponse.success("success",userVM);
	    	}catch(Exception e){
	        	e.printStackTrace();
	        	return MsgResponse.error(e.getMessage());
	    }		
	    }
///保存和更新
	
///批量删除
    @GetMapping("batchDeleteUser") 
    public MsgResponse batchDeleteUser(List<Long> ids){
        		
        try{
        	userService.batchDelete(ids);
		    return MsgResponse.success("success",ids);
        }catch(Exception e){
        	e.printStackTrace();
        	return MsgResponse.error(e.getMessage());
    }	
	}
///批量删除
   

}
