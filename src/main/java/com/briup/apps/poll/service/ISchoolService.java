package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;


public interface ISchoolService {
    List<School> findAll() throws Exception;
    /**
     * 通过id查询
     */
    School findById(long id) throws Exception;
    /**
     * 通过关键字查询
     */
    List<School> query(String keywords) throws Exception;
    /**
     * 保存和更新
     */
    void saveOrupdate(School school) throws Exception;
    /**
     *通过id删除
     */
    void deleteById(long id) throws Exception;
    /**
     * 批量删除
     */
    void batchDelete(List<Long> ids) throws Exception;
}