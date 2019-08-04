package uuia.info.devbackend.component;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Raven
 * @Date: 2019/8/3 10:20 PM
 */
public class IDGenerator {
    public static String generateAppId(Date createTime) {
        String source = "UUIA-APP-" + createTime.getTime();
        return UUID.nameUUIDFromBytes(source.getBytes()).toString();
    }

    public static String generateUserId(Date createTime, String openId) {
        String source = "UUIA-USER-" + openId + createTime.getTime();
        return UUID.nameUUIDFromBytes(source.getBytes()).toString();
    }

    public static String generateUserId(Date createTime) {
        // 选取当前线程的随机数生成器
        String source = "UUIA-USER-" + ThreadLocalRandom.current().nextLong() + createTime.getTime();
        return UUID.nameUUIDFromBytes(source.getBytes()).toString();
    }

    public static String generateUuid(String userId, String appId) {
        String source = "UUID-" + userId + appId;
        return UUID.nameUUIDFromBytes(source.getBytes()).toString();
    }
}
