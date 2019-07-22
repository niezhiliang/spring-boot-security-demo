package com.niezhiliang.security.demo.service.impl;

import com.niezhiliang.security.demo.entity.Msg;
import com.niezhiliang.security.demo.mapper.MsgMapper;
import com.niezhiliang.security.demo.service.IMsgService;
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
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements IMsgService {

}
