package com.niezhiliang.security.demo.mapper;

import com.niezhiliang.security.demo.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niezhiliang.security.demo.entity.RoleMenuInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-07-18
 */
public interface MenuMapper extends BaseMapper<Menu> {

    RoleMenuInfo selectSubMenu(Integer roleId);
}
