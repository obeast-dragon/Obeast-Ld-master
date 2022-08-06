package com.obeast.common.api;

/**
 * @author wxl
 * @date 2022/8/6 15:03
 * @description:
 **/
public interface IErrorCode {

    /**
     * 错误码
     * */
    Integer getCode();

    /**
     * 错误信息
     * */
    String getMessage();
}
