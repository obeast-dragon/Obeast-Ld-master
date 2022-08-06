package com.obeast.common.api;


/**
 * @author wxl
 * @date 2022/8/6 15:04
 * @description: 错误码枚举
 **/
public enum ResultCode implements IErrorCode {
    /**
     * SUCCESS(200, "操作成功")
     * FAILED(500, "操作失败")
     * UNAUTHORIZED(401, "暂未登录或token已经过期")
     * VALIDATE_FAILED(402, "参数检验失败")
     * FORBIDDEN(403, "没有相关权限")
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    VALIDATE_FAILED(402, "参数检验失败"),
    FORBIDDEN(403, "没有相关权限");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
