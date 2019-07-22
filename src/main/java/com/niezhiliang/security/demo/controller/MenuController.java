package com.niezhiliang.security.demo.controller;


import com.niezhiliang.security.demo.entity.RoleMenuInfo;
import com.niezhiliang.security.demo.mapper.MenuMapper;
import com.niezhiliang.security.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取角色所有权限
     * @param roleId
     * @return
     */
    @RequestMapping(value = "list")
    public String getMenuList(Integer roleId) {

        RoleMenuInfo menuTree = menuMapper.selectSubMenu(roleId);
        return ResultUtils.success(menuTree);
    }

}
