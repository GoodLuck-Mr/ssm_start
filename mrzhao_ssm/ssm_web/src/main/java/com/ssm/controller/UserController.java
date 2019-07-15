package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.UserInfo;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //定义私有
    private ModelAndView view = new ModelAndView();

    /**
     * 查询所有用户的方法，跳转用户管理页面
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize)throws Exception {
        List<UserInfo> userInfos = userService.findAll(page, pageSize);
        PageInfo info = new PageInfo(userInfos);
        view.addObject("pageInfo", info);
        view.setViewName("user-list");
        return view;
    }

    /**
     * 添加一条用户，并跳转到用户管理界面
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        //重定向
        return "redirect:findAll.do";

    }


    /**
     * 查询用户详情
     *
     * @return
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String userid) throws Exception {
        UserInfo userInfo = userService.findById(userid);
        view.addObject("user", userInfo);
        view.setViewName("user-show");
        return view;
    }
}
