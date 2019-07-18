package com.ssm.dao;

import com.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {


    /**
     * 查询产品Product所有的方法
     * @return
     */
    @Select("select * from product ")
    List<Product> findAll() throws Exception;

    /**
     * 添加一条产品的方法
     * @param product
     */
   @Insert("insert into PRODUCT " +
           "values (#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void  save(Product product)throws Exception;

    /**
     *根据id查询一条产品信息
     * @param id
     * @return
     */
   @Select("select * from product where id = #{id}")
   Product findById(String id)throws Exception;
}
