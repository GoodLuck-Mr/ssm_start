package com.ssm.service;

import com.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 查询所有的订单
     * @return
     */
    List<Orders> findAll(int page,int pageSize) throws Exception;

    /**
     * 根据id查询一条订单详情
     * @param ordersId
     * @return
     */
    Orders findById(String ordersId) throws Exception;
}
