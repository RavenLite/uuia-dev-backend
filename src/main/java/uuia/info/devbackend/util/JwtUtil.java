package uuia.info.devbackend.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import uuia.info.devbackend.exception.UserLoginException;
import uuia.info.devbackend.exception.UserLoginInvalidException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


/**
 * @Author: Raven
 * @Date: 2019/8/2 10:20 AM
 */
public class JwtUtil {

    // 私钥
    final static String BASE64_ENCODED_SECRET_KEY = "9f2unr1#@FF#@@$fqwadjkd1iodn";

    // 过期时间,测试使用一小时
    final static long TOKEN_EXP = 1000 * 60 * 60;


    public static String getToken(String userId) {
        return Jwts.builder().setSubject(userId).claim("userId", userId).
                setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
                .signWith(SignatureAlgorithm.HS256, BASE64_ENCODED_SECRET_KEY).compact();
    }

    /**
     * 检查token,只要不正确就会抛出异常
     **/
    public static Claims checkToken(String token) throws UserLoginInvalidException, UserLoginException, IOException {

        try {
            return Jwts.parser().setSigningKey(BASE64_ENCODED_SECRET_KEY).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new UserLoginInvalidException("登录信息过期，请重新登录");
        } catch (Exception e) {
            throw new UserLoginException("用户未登录，请重新登录");
        }
    }

    public static void resetResponse(HttpServletResponse response, ResultCode code) throws IOException {
        // 重置response
        response.reset();
        // 设置编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        // 设置response内容
        PrintWriter pw = response.getWriter();
        pw.write(JSON.toJSONString(CommonResult.fail(code)));

        pw.flush();
        pw.close();
    }
}