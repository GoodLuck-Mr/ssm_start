package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.IRoleDao;
import com.ssm.domain.Role;
import com.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> findAll(int page ,int pageSize)throws Exception {

        PageHelper.startPage(page,pageSize);
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id)throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
}
