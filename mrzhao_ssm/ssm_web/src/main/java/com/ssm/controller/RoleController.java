package com.ssm.controller;

import com.github.pagehelper.PageInfo;
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
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        List<Role> roleList = roleService.findAll(page, pageSize);
        PageInfo info = new PageInfo(roleList);
        view.addObject("pageInfo", info);
        view.setViewName("role-list");
        return view;
    }

    /**
     * 添加根据id查询角色详情
     *
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        Role role = roleService.findById(id);
        view.addObject("role", role);
        view.setViewName("role-show");
        return view;


    }


    /**
     * 添加一条角色
     * @param role
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Role role)throws Exception{
        roleService.save(role);
        //重定向
        return "redirect:findAll.do";
    }
}
