package uuia.info.devbackend.exception;

/**
 * @Author: Raven
 * @Date: 2019/8/2 10:21 AM
 */
public class UserLoginInvalidException extends Exception {
    public UserLoginInvalidException(String message) {
        super(message);
    }
}