package com.niezhiliang.security.demo.controller;


import com.niezhiliang.security.demo.entity.Role;
import com.niezhiliang.security.demo.exception.MySecurityException;
import com.niezhiliang.security.demo.service.IRoleService;
import com.niezhiliang.security.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-07-18
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 添加角色
     * @return
     */
    @RequestMapping(value = "add")
    @PreAuthorize("hasAuthority('role:add')")
    public String add() {

        Role role = new Role();
        role.setRoleName("admin"+new Random().nextInt(100));
        roleService.save(role);

        return ResultUtils.success("角色添加成功");
    }

    /**
     * 角色删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    @PreAuthorize("hasAuthority('role:delete')")
    public String delete(Integer id) {
        if (id == null) {
            throw new MySecurityException("id不能为空");
        }
        roleService.removeById(id);
        return ResultUtils.success("删除成功");
    }

    /**
     * 角色修改
     * @param role
     * @return
     */
    @RequestMapping(value = "update")
    @PreAuthorize("hasAuthority('role:update')")
    public String update(Role role) {

        if (role.getId() == null) {
            throw new MySecurityException("id不能为空");
        }
        roleService.updateById(role);
        return ResultUtils.success("修改成功");
    }

    /**
     * 角色列表
     * @return
     */
    @RequestMapping(value = "list")
    @PreAuthorize("hasAuthority('role:list')")
    public String list() {

        return ResultUtils.success(roleService.list());
    }

}
