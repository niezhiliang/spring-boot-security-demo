package com.niezhiliang.security.demo.handler;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.security.demo.constant.CodeEnum;
import com.niezhiliang.security.demo.constant.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 10:56
 * 处理权限不足
 */
@Component
public class MyAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=utf-8");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.PERMISSION_DENIED.getCode());
        resultVO.setMsg(CodeEnum.PERMISSION_DENIED.getMsg());
        response.getWriter().write(JSONObject.toJSONString(resultVO));
    }
}