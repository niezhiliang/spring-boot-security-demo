package com.niezhiliang.security.demo.handler;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niezhiliang.security.demo.constant.CodeEnum;
import com.niezhiliang.security.demo.constant.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 11:30
 * 处理登录失败
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=utf-8");

        String message;
        if (exception instanceof UsernameNotFoundException) {
            message = "用户不存在！";
        } else if (exception instanceof BadCredentialsException) {
            message = "用户名或密码错误！";
        } else if (exception instanceof LockedException) {
            message = "用户已被锁定！";
        } else if (exception instanceof DisabledException) {
            message = "用户不可用！";
        } else if (exception instanceof AccountExpiredException) {
            message = "账户已过期！";
        } else if (exception instanceof CredentialsExpiredException) {
            message = "用户密码已过期！";
//        } else if (exception instanceof ValidateCodeException || exception instanceof FebsCredentialExcetion) {
//            message = exception.getMessage();
        } else {
            message = "认证失败，请联系网站管理员！";
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.ERROR_CODE.getCode());
        resultVO.setMsg(message);
        response.getWriter().write(mapper.writeValueAsString(resultVO));
    }
}
