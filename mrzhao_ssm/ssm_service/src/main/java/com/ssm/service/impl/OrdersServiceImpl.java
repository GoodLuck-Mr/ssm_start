package com.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.ssm.dao.IOrdersDao;
import com.ssm.domain.Orders;
import com.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 查询所有的订单方法
     * @return
     */
    @Override
    public List<Orders> findAll(int page,int pageSize) throws Exception {
        //需要在mybatis方法前 使用，
        // pageNum 表示当前，pageSize 表示显示条数
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }

    /**
     * 根据id查询一条订单详情
     * @param ordersId
     * @return
     */
    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }

}
