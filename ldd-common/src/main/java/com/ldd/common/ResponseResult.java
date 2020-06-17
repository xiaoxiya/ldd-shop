package com.ldd.common;

/**
 * @author xiaoxiya
 * @date 2020/6/16 20:45
 * @describe 通用返回对象
 */
public class ResponseResult<T> {

    private String code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>("success", "操作成功", data);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<T>("success", message, data);
    }

    /**
     * 失败返回结果
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> failed(T data) {
        return new ResponseResult<T>("failed", "操作成功", data);
    }

    /**
     * 失败返回结果
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResponseResult<T> failed(T data, String message) {
        return new ResponseResult<T>("failed", message, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
