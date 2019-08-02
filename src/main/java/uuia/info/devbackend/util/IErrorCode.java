package uuia.info.devbackend.util;

/**
 * 封装API的错误码
 * @Author: Raven
 * @Date: 2019/8/2 10:20 AM
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}