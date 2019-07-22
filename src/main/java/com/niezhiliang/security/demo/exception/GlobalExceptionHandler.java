package com.niezhiliang.security.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 14:12
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理系统异常信息
     */
    @ExceptionHandler(value = MySecurityException.class)
    @ResponseBody
    public String FreeServiceExceptionHandler(MySecurityException e) throws RuntimeException {
        return e.getResponse();
    }
}
