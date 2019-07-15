package com.ssm.controller;

import com.ssm.domain.Role;
import com.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    //定义私有模型视图
    private ModelAndView view = new ModelAndView();

    /**
     * 查询所有角色，跳转角色显示页面
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception {
        List<Role> roleList = roleService.findAll();
        view.addObject("roleList", roleList);
        view.setViewName("role-list");
        return view;
    }

    /**
     * 添加根据id查询角色详情
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id)throws Exception{
        Role role=  roleService.findById(id);
        view.addObject("role",role);
        view.setViewName("role-show");
        return view;


    }


}
