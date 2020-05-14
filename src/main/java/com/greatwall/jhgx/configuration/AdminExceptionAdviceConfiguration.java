package com.greatwall.jhgx.configuration;

import com.greatwall.component.ccyl.common.exception.BusinessException;
import com.greatwall.component.ccyl.common.exception.IdempotencyException;
import com.greatwall.component.ccyl.common.exception.ParameterException;
import com.greatwall.component.ccyl.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 统一异常处理
 * @author TianLei
 */
@Slf4j
@RestControllerAdvice
public class AdminExceptionAdviceConfiguration {

    /**
     * IllegalArgumentException异常处理返回json
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public Result badRequestException(IllegalArgumentException e) {
        return defHandler("参数解析失败", e);
    }


    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result badRequestException(HttpMessageNotReadableException e) {
        return defHandler("参数解析失败", e);
    }

    /**
     * 不支持的请求方法
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return defHandler("不支持当前请求方法", e);
    }

    /**
     * ParameterException 参数异常处理
     */
    @ExceptionHandler({ParameterException.class})
    public Result handelParameterException(ParameterException e) {
        return defHandler(e.getMessage(), e);
    }

    /**
     * sql异常处理
     */
    @ExceptionHandler({SQLException.class})
    public Result handleSQLException(SQLException e) {
        return defHandler("服务运行SQLException异常", e);
    }

    /**
     * BusinessException 业务异常处理
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        return defHandler(e.getMessage(), e);
    }

    /**
     * IdempotencyException幂等性异常处理
     */
    @ExceptionHandler(IdempotencyException.class)
    public Result handleIdempotencyException(IdempotencyException e) {
        return Result.failed(e.getMessage());
    }

    /**
     * 所有异常统一处理
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return defHandler("未知异常", e);
    }

    private Result defHandler(String msg, Exception e) {
        log.error(msg, e);
        return Result.failed(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleDefaultMessageSourceResolvable(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        BindingResult result = e.getBindingResult();
        StringBuilder message = new StringBuilder();
        for (FieldError error: result.getFieldErrors()) {
            message.append(error.getDefaultMessage()).append( '。');
        }
        return Result.failed(message.toString());
    }
}
