package com.ssm.dao;

import com.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {

    /**
     * 根据userID 查询中间表 返回查询角色表
     * @param userid
     * @return
     */
    @Select("select r.* from role r , users_role ur where r.id = ur.roleid and ur.userid = #{userid}")
    @Results(id = "perMap",value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.ssm.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findUserId(String userid) throws Exception;

    /**
     * 查询所有的角色信息
     * @return
     */
    @Select("select * from role")
    List<Role> findAll()throws Exception;

    /**
     * 根据id查询角色详情
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{id}")
    @ResultMap("perMap")
    Role findById(String id)throws Exception;
}
