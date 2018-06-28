package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.ClazzVM;

public interface ClazzVMMapper {
	List<ClazzVM> SelectAll();
	ClazzVM selectByPrimaryKey(Long id);
	

    
    int insert(ClazzVM record);
    int updateByPrimaryKeyWithBLOBs(ClazzVM  record);
    

}
