package com.ssm.dao;

import com.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {


    /**
     * 根据用户名查询用户表
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results(id = "rolesMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles" ,column = "id",
                    javaType =java.util.List.class, many = @Many(select = ("com.ssm.dao.IRoleDao.findUserId")))
    })
    UserInfo findUserName(String username)throws Exception;

    /**
     * 查询所有用户的方法
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll()throws Exception;

    /**
     * 添加一个用户的方法
     * @param userInfo
     */
    @Insert("insert into users  values (#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo)throws Exception;


    /**
     * 根据id查询一条数据的方法
     * @param userid
     * @return
     */
    @Select("select * from users where id = #{userid}")
    @ResultMap("rolesMap")
    UserInfo findById(String userid) throws Exception;
}












