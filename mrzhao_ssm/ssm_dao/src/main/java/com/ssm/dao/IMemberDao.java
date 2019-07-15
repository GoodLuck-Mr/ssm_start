package com.ssm.dao;

import com.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {
    /**
     * 根据id查询一条会员详情
     *
     * @param id
     * @return
     */
    @Select("select * from member where id =#{id}")
    Member findById(String id) throws Exception;

}
