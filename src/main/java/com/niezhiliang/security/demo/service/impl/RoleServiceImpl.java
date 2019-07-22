package com.niezhiliang.security.demo.service.impl;

import com.niezhiliang.security.demo.entity.Role;
import com.niezhiliang.security.demo.mapper.RoleMapper;
import com.niezhiliang.security.demo.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-07-18
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
