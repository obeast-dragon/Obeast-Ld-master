package com.obeast.common.exception;

import com.obeast.common.api.IErrorCode;

/**
 * @author wxl
 * @version 1.0
 * @description:
 * @date 2022/8/6 14:55
 */
public class BeastExcetion extends Exception{

    private IErrorCode errorCode;

    private Object data;


    public BeastExcetion(String message, IErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BeastExcetion(String message, Object data) {
        super(message);
        this.data = data;
    }

    public BeastExcetion(Throwable cause) {
        super(cause);
    }

    public BeastExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public Object getData() {
        return data;
    }
}
