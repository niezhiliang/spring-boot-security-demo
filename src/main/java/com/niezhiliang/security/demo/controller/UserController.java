package com.niezhiliang.security.demo.controller;


import com.niezhiliang.security.demo.constant.CodeEnum;
import com.niezhiliang.security.demo.exception.MySecurityException;
import com.niezhiliang.security.demo.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-07-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 登录失效和未登录跳转接口
     * @return
     */
    @RequestMapping(value = "unlogin")
    public String login() {
       throw new MySecurityException(CodeEnum.LOGIN_EXPIRED);
    }

    /**
     * 用户登出系统
     * @return
     */
    @RequestMapping(value = "signout")
    public String signout() {
       return ResultUtils.success("退出成功");
    }

    @RequestMapping(value = "/login/mobile")
    public String  phoneLogin() {

        return "success";
    }
}
