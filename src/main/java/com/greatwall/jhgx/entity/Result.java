package com.greatwall.jhgx.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8428115135646593500L;

    /**
     * 结果
     */
    private String result;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }

    public Result(String result, String msg, T data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }


    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), msg, data);
    }

    public static Result success(String msg) {
        return new Result(ResultEnum.SUCCESS.getCode(), msg, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), StringUtils.EMPTY, data);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return new Result<>(ResultEnum.FAIL.getCode(), msg, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultEnum.FAIL.getCode(), StringUtils.EMPTY, data);
    }

    public static Result fail(String msg) {
        return new Result(ResultEnum.FAIL.getCode(), msg, null);
    }

    public static boolean isSuccess(Result result) {
        return result != null && StringUtils.equals(ResultEnum.SUCCESS.getCode(), result.result);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

