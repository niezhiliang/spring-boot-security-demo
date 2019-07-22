package com.niezhiliang.security.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2019/07/19 14:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {

    private Integer code;

    private Object data;

    private String msg;

}
