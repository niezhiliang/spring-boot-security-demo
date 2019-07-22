package com.niezhiliang.security.demo.service.impl;

import com.niezhiliang.security.demo.entity.User;
import com.niezhiliang.security.demo.mapper.UserMapper;
import com.niezhiliang.security.demo.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
