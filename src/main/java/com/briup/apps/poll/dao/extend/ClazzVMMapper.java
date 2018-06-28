package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.ClazzVM;

public interface ClazzVMMapper {
	List<ClazzVM> SelectAll();
    int insert(ClazzVM record);
    int updateByPrimaryKeyWithBLOBs(ClazzVM  record);



	ClazzVM selectByPrimaryKey(long id);



	List<ClazzVM> selectByExampleWithBLOBs(String keywords);



	//List<ClazzVM> selectByExampleWithBLOBs(ClazzExample example);
    

}
