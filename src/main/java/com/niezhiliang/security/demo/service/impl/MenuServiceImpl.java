package com.niezhiliang.security.demo.service.impl;

import com.niezhiliang.security.demo.entity.Menu;
import com.niezhiliang.security.demo.mapper.MenuMapper;
import com.niezhiliang.security.demo.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
