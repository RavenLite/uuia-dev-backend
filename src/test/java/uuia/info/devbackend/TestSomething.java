package uuia.info.devbackend;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @Author: Raven
 * @Date: 2019/8/8 6:37 PM
 */
public class TestSomething {
    @Test
    public void test(){
        show("louge123", "q948185662");
    }

    private void show(String password, String username){
        System.out.println(sha256(password + username));
    }

    private String sha256(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(str.getBytes());
            return toHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String toHex(byte[] bytes) {
        StringBuilder str = new StringBuilder();
        for (byte b : bytes) {
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] temp = new char[2];
            temp[0] = chars[(b >>> 4) & 0x0F];
            temp[1] = chars[b & 0x0F];

            str.append(new String(temp));
        }
        return str.toString();
    }
}
