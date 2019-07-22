package com.niezhiliang.security.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niezhiliang.security.demo.entity.*;
import com.niezhiliang.security.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/18 14:22
 */
@Configuration
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleMenuService roleMenuService;

    @Autowired
    private IMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getAccount,name);
        User user = userService.getOne(userQueryWrapper);

        //用户名不存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        UserRole userRole = userRoleService.getOne(new QueryWrapper<UserRole>()
                .lambda()
                .eq(UserRole::getUserId,user.getId()));
        Role role = roleService.getById(userRole.getRoleId());

        List<Integer> roleMenuList = roleMenuService.list(new QueryWrapper<RoleMenu>()
                .lambda().eq(RoleMenu::getRId,role.getId())).stream()
                .map(RoleMenu::getMId).collect(Collectors.toList());

       String permissions = menuService.listByIds(roleMenuList).stream()
                .map(Menu::getPerms).collect(Collectors.joining(","));

        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);


        MyUser myUser = new MyUser(user.getAccount(),user.getPassword(),user.getIsEnable() == 1 ? true : false,true,true,
                true,authorities);
        myUser.setPassword(user.getPassword());
        return myUser;
    }
}
