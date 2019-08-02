package uuia.info.devbackend.util;

/**
 * 枚举了一些常用API操作码
 * @Author: Raven
 * @Date: 2019/8/2 10:20 AM
 */
public enum ResultCode implements IErrorCode {
    // 外层code
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),

    // 内层error data
    E_600(600, "用户不存在"),
    E_601(601, "密码错误"),
    E_602(602, "操作项不存在"),
    E_603(603, "用户未登录，请重新登录"),
    E_604(604, "登录信息过期，请重新登录"),
    E_605(605, "插入失败"),
    E_606(606, "原密码输入错误"),
    E_607(607, "新密码与原密码相同"),

    E_701(701, "输入项不全");



    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
