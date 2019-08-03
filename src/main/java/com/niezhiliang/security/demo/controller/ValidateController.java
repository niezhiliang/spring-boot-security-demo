package com.niezhiliang.security.demo.controller;

import com.niezhiliang.security.demo.utils.RedisTools;
import com.niezhiliang.security.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/08/01 09:10
 */
@RestController
public class ValidateController {

    @Autowired
    private RedisTools redisTools;


    /**
     * 验证码发送
     * @return
     */
    @GetMapping(value = "/code/sms")
    public String createSmsCode(String phone) {

        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        redisTools.save(phone,code,1);

        return ResultUtils.success(code);

    }

}
