package com.ssm.service;

import com.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    //查询所有产品
    List<Product> findAll(Integer page,Integer pageSize) throws Exception;

    //添加一条产品
    void  save(Product product) throws Exception;
}
