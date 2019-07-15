package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.IUserDao;
import com.ssm.domain.Role;
import com.ssm.domain.UserInfo;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    //导入加密类
    @Autowired
    private BCryptPasswordEncoder bcpe;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo info = null;
        try {
            info = userDao.findUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
		username;
	    password;
		tenabled;
		accountNonExpired;
		credentialsNonExpired;
		accountNonLocked;
		Collections.unmodifiableSet(sortAuthorities(authorities));*/
        User user = new User(info.getUsername(),info.getPassword(), true, true,
                true, true, getAuthority(info.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    /**
     * 查询所有的方法
     * @return
     */
    @Override
    public List<UserInfo> findAll(int page,int pageSize) throws Exception{
        PageHelper.startPage(page,pageSize);
        return userDao.findAll();
    }

    /**
     * 添加一条数据的方法，并对密码进行加密处理
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bcpe.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String userid) throws Exception {
        return userDao.findById(userid);
    }
}
