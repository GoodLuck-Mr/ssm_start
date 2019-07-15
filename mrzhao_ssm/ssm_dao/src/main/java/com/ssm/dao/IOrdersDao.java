package com.ssm.dao;

import com.ssm.domain.Member;
import com.ssm.domain.Orders;
import com.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IOrdersDao {

    /**
     * 查询所有的 订单方法
     *
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.ssm.dao.IProductDao.findById"))})
    List<Orders> findAll() throws Exception;

    /**
     * 根据id查询一条数据的详情
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "com.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.ssm.dao.ITravellerDao.findByOrdersId"))})
    Orders findById(String ordersId) throws Exception;
}
