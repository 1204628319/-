package com.greatwall.jhgx.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("member")
public class Member {
    @TableId
    private Long id;
    private String merchantId;
    private String agencyType;
    private String realName;
    private String certId;
    private String merName;
    private String merState;
    private String merCity;//
    private String merAddress;
    private String merOrderId;
    private String consRate;
    private String consFee;
    private String settleCardNo;
    private String settleMobile;
    private String notifyUrl;

    /**
     * 注册状态 notSign-未开始进件 signing-处理中 signed-进件成功 refused-已拒绝  fail-失败 abnormal-异常
     */
    private String signStatus;

    /**
     * 支付请求信息
     */
    private String requestMsg;

    /**
     * 支付返回信息
     */
    private String responseMsg;

    /**
     * 支付回调信息
     */
    private String callBackMsg;

    /**
     * 订单查询返回结果
     */
    private String queryResultMsg;

    private String createTime;
    private String updateTime;

    @TableField(exist = false)
    private String signStatusName;
}
