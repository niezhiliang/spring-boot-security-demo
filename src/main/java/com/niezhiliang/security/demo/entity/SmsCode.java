package com.niezhiliang.security.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/08/01 09:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsCode {

    private String code;

    private LocalDateTime expireTime;

    /**
     * 判断当前验证码是否过期
     * @return
     */
    boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }


}
