package com.niezhiliang.security.demo.controller;

import com.niezhiliang.security.demo.entity.Msg;
import com.niezhiliang.security.demo.exception.MySecurityException;
import com.niezhiliang.security.demo.service.IMsgService;
import com.niezhiliang.security.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/18 11:28
 */
@RestController
@RequestMapping(value = "msg")
public class MsgController {

    @Autowired
    private IMsgService msgService;


    /**
     * 信息列表
     * @return
     */
    @RequestMapping(value = "list")
    @PreAuthorize("hasAuthority('msg:list')")
    public String list() {

        List<Msg> msgList = msgService.list();

        return ResultUtils.success(msgList);
    }

    /**
     * 信息添加
     * @return
     */
    @RequestMapping(value = "add")
    @PreAuthorize("hasAuthority('msg:add')")
    public String add() {

        Msg msg = new Msg();
        msg.setCreateAt(new Date());
        msg.setMsg(UUID.randomUUID().toString());
        msg.setUpdateAt(new Date());
        this.msgService.save(msg);
        return ResultUtils.success("添加成功");
    }

    /**
     * 信息删除
     * @return
     */
    @RequestMapping(value = "delete")
    @PreAuthorize("hasAuthority('msg:delete')")
    public String delete(Integer id) {
        msgService.removeById(id);
        return ResultUtils.success("删除成功");
    }

    /**
     * 信息修改
     * @return
     */
    @RequestMapping(value = "update")
    @PreAuthorize("hasAuthority('msg:update')")
    public String update(Msg msg) {
        if (msg.getId() == null) {
            throw new MySecurityException("id不能为空");
        }

        msg.setUpdateAt(new Date());
        this.msgService.updateById(msg);
        return ResultUtils.success("编辑成功");
    }

}
