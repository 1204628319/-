package com.greatwall.jhgx.entity;

import lombok.Data;

@Data
public class PayCallBackVo {
    /**
     * 交易订单号
     */
    private String merOrderId;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 返回码 00 支付成功，其它-失败
     */
    private String resCode;

    /**
     * 交易金额
     */
    private String transAmt;

    /**
     * 交易时间
     */
    private String transTime;

    /**
     * 代付状态，在支付成功后返回
     */
    private String settStatus;

    /**
     * 代付描述，在支付成功后返回
     */
    private String settMsg;

    /**
     * 签名规则,参数名ASCII码从小到大排序md5(key=value&key=value&key=密钥)
     */
    private String sign;
}
