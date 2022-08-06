package com.obeast.common.api;


import lombok.Data;

//统一返回结果的类
@Data
public class R<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    protected R() {
    }

    protected R(Integer code, String message, T data, Boolean isSuccess) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = isSuccess;
    }

    /**
     * @description: 无返回值
     * @author wxl
     * @date 2022/7/15 17:56
     * @return null
     **/
    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("success");
        return r;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> R<T> success(T data) {
        return new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, true);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> R<T> success(T data, String message) {
        return new R<>(ResultCode.SUCCESS.getCode(), message, data, true);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> R<T> error(IErrorCode errorCode) {
        return new R<>(errorCode.getCode(), errorCode.getMessage(), null, false);
    }



    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> R<T> error(IErrorCode errorCode, String message) {
        return new R<>(errorCode.getCode(), message, null, false);
    }

    /**
     * 失败返回结果
     * @param message 错误信息
     * @param data 返回数据
     */
    public static <T> R<T> error(String message, T data) {
        return new R<>(ResultCode.FAILED.getCode(), message, data, false);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> R<T> error(String message) {
        return new R<>(ResultCode.FAILED.getCode(), message, null, false);
    }

    /**
     * 失败返回结果
     */
    public static <T> R<T> error() {
        return error(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> R<T> validateFailed() {
        return error(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> R<T> validateFailed(String message) {
        return new R<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null, false);
    }

    /**
     * 未登录返回结果
     */
    public static <T> R<T> unauthorized(T data) {
        return new R<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data, false);
    }

    /**
     * 未登录返回结果
     */
    public static <T> R<T> unauthorized(String message) {
        return new R<>(ResultCode.UNAUTHORIZED.getCode(), message, null, false);
    }

    /**
     * 未授权返回结果
     */
    public static <T> R<T> forbidden(T data) {
        return new R<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data, false);
    }

    public long getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
