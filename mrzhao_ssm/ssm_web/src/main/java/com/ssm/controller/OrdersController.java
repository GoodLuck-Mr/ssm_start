package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;
import com.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;
    //定义模型视图解析器
    private ModelAndView view = new ModelAndView();

    /**
     * 根据id查询订单详情
     *
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        Orders orders = ordersService.findById(ordersId);
        view.addObject("orders",orders);
        view.setViewName("orders-show");
        return view;
    }


    /**
     * 查询所有订单的方法
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            //指定参数名称  且设置默认值
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        //PageInfo分页数据
        PageInfo pageInfo = new PageInfo(ordersList);
        view.addObject("pageInfo", pageInfo);
        view.setViewName("orders-list");
        return view;
    }

}
