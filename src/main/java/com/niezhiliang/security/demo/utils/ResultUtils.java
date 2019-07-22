package com.niezhiliang.security.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.security.demo.constant.CodeEnum;
import com.niezhiliang.security.demo.constant.ResultVO;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/04 11:18
 */
public class ResultUtils {
    /**
     * 成功返回
     * @return
     */
    public static String success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.SUCCESS_CODE.getCode());
        resultVO.setMsg(CodeEnum.SUCCESS_CODE.getMsg());
        return JSONObject.toJSONString(resultVO);
    }
    /**
     * 成功返回
     * @param obj
     * @return
     */
    public static String success(Object obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.SUCCESS_CODE.getCode());
        resultVO.setMsg(CodeEnum.SUCCESS_CODE.getMsg());
        resultVO.setData(obj);
        return JSONObject.toJSONString(resultVO);
    }

    /**
     * 成功返回
     * @param msg
     * @return
     */
    public static String success(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.SUCCESS_CODE.getCode());
        resultVO.setMsg(msg);
        return JSONObject.toJSONString(resultVO);
    }


    /**
     * 成功返回
     * @param obj
     * @return
     */
    public static String success(Object obj,String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(CodeEnum.SUCCESS_CODE.getCode());
        resultVO.setMsg(msg);
        resultVO.setData(obj);
        return JSONObject.toJSONString(resultVO);
    }

}
