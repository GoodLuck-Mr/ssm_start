package com.ssm.service;

import com.ssm.domain.Role;
import java.util.List;

public interface IRoleService {

    /**
     * 定义查询所有角色方法
     * @return
     */
    List<Role> findAll(int page ,int pageSize)throws Exception;

    /**
     * 定义根据id查询一条角色信息
     * @param id
     * @return
     */
    Role findById(String id)throws Exception;

    /**
     * 定义添加一条角色的方法
     * @param role
     */
    void save(Role role)throws Exception;
}
