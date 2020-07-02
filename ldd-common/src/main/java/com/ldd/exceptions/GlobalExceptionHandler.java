package com.ldd.exceptions;

import com.ldd.common.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaoxiya
 * @date 2020/7/2 19:48
 * @describe Spring 统一异常处理有 3 种方式，分别为：
 * 使用 @ ExceptionHandler 注解
 * 实现 HandlerExceptionResolver 接口
 * 使用 @controlleradvice 注解
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 捕获controller层的异常
     * 如果 @ExceptionHandler 注解中未声明要处理的异常类型，则默认为参数列表中的异常类型。
     * @param e 异常类型
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public ResponseResult handle(Exception e) {
        //记录日志
        LOGGER.error("异常信息：{},异常详细信息为：{}",e.getMessage(), e);
        return ResponseResult.failed(e.getMessage());
    }

    /**
     * 捕获自定义异常
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseResult handle(ApiException e) {
        LOGGER.error("异常信息：{},异常详细信息为：{}",e.getMessage(), e);
        if (e.getErrorCode() != null) {
            return ResponseResult.failed(e.getErrorCode());
        }
        return ResponseResult.failed(e.getMessage());
    }
}
