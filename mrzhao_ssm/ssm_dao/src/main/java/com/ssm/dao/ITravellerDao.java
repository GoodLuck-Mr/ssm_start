package com.ssm.dao;

import com.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ITravellerDao {

    /**
     * 根据订单id查询 order_traveller(中间表) 返回TravellerId 查询
     * @param ordersId
     * @return
     * @throws Exception
     */
   // @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    @Select("select t.* from traveller t , order_traveller ot where t.id = ot.TRAVELLERID and ot.ORDERID= #{ordersId} ")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;

}
