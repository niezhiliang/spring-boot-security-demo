package com.niezhiliang.security.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 19:49
 */
@Data
public class RoleMenuInfo {

    private Integer roleId;

    private String roleName;

    private List<MenuTree> menuTreeList;
}
