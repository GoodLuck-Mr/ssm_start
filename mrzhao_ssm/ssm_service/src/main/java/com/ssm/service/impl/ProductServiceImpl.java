package com.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.ssm.dao.IProductDao;
import com.ssm.domain.Product;
import com.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    /**
     * 查询所有产品
     * @return
     */
    @Override
    public List<Product> findAll(Integer page,Integer pageSize) throws Exception {
        //需要在mybatis方法前 使用，
        // pageNum 表示当前，pageSize 表示显示条数
        PageHelper.startPage(page, pageSize);

        return productDao.findAll();
    }

    /**
     * 添加一条产品信息数据
     * @param product
     */
    @Override
    public void save(Product product) throws Exception {

        productDao.save(product);
    }


}
