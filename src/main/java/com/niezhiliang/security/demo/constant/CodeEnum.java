package com.niezhiliang.security.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 14:09
 */
@AllArgsConstructor
@Getter
public enum CodeEnum {

    SUCCESS_CODE(1,"请求成功"),

    ERROR_CODE(0,"其他错误"),

    USERNAME_NOT_EXIT(10001,"用户名不存在"),

    PERMISSION_DENIED(10002,"很抱歉，您没有该访问权限"),

    LOGIN_EXPIRED(10003,"登录失效，请重新登录")
    ;



    private Integer code;

    private String msg;



}
