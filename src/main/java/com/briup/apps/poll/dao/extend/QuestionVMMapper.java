package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionVM;
/*
 * 一对多
 */
public interface QuestionVMMapper {
    List<QuestionVM> selectAll() throws Exception;
    
    List<QuestionVM> selectByQuestionnaireId(long id) throws Exception;
}
