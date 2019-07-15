package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Product;
import com.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    //定义私有模型视图
    private  ModelAndView view = new ModelAndView();

    /**
     * 这是查询所有产品
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            //指定参数名称  且设置默认值
            @RequestParam(name = "page",required = true,defaultValue ="1")Integer page
            ,@RequestParam(name = "pageSize",required = true,defaultValue ="6")Integer pageSize
    ) throws Exception {

        List<Product> list = productService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        view.addObject("pageInfo", pageInfo);
        view.setViewName("product-list");
        return view;
    }

    @RequestMapping(path= "/save.do",method = RequestMethod.POST)
    public String save(Product product) throws Exception {
        productService.save(product);
        //重定向
        return "redirect:findAll.do";
    }





}
