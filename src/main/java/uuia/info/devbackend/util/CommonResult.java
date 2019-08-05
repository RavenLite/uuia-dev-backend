package uuia.info.devbackend.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回通用对象
 * @Author: Raven
 * @Date: 2019/8/2 10:20 AM
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> fail(IErrorCode errorCode) {
        JSONObject data = new JSONObject();
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), (T) data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param detail 获取的数据
     */
    public static <T> CommonResult<T> fail(IErrorCode errorCode, T detail) {
        JSONObject data = new JSONObject();
        data.put("data", detail);
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), (T) data);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> fail() {
        return fail(ResultCode.FAILED);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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
