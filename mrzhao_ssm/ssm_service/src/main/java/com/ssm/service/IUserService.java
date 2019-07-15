package com.ssm.service;

import com.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface IUserService extends UserDetailsService {

    /**、
     * 查询所有的方法
     * @return
     */
    List<UserInfo> findAll(int page,int pageSize)throws Exception;

    /**
     * 添加一个用户的方法
     * @param userInfo
     */
    void save(UserInfo userInfo)throws Exception;

    /**
     * 根据id 查询一条用户信息
     * @param userid
     * @return
     */
    UserInfo findById(String userid)throws Exception;
}
