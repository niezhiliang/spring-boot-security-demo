package com.niezhiliang.security.demo.exception;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.security.demo.constant.CodeEnum;
import com.niezhiliang.security.demo.constant.ResultVO;
import lombok.Getter;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 14:05
 */

public class MySecurityException extends RuntimeException {

    @Getter
    private String response;


    public MySecurityException(CodeEnum codeEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(codeEnum.getCode());
        resultVO.setMsg(codeEnum.getMsg());
        this.response = JSONObject.toJSONString(resultVO);
    }

    public MySecurityException(String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.ERROR_CODE.getCode());
        resultVO.setMsg(message);
        this.response = JSONObject.toJSONString(resultVO);
    }

    public MySecurityException(String message, String response) {
        super(message);
        this.response = response;
    }
}
