package com.obeast.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author wxl
 * @date 2022/8/5 9:27
 * @description:
 **/
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        log.error("全局异常捕获>>>:" + e);
        return "全局异常捕获,错误原因>>>" + e.getMessage();
    }
}
