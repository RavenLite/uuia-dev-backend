package uuia.info.devbackend.component;

import io.jsonwebtoken.Claims;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import uuia.info.devbackend.exception.UserLoginException;
import uuia.info.devbackend.exception.UserLoginInvalidException;
import uuia.info.devbackend.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import static uuia.info.devbackend.util.JwtUtil.resetResponse;
import static uuia.info.devbackend.util.ResultCode.E_603;
import static uuia.info.devbackend.util.ResultCode.E_604;


/**
 * JWT 拦截器
 * @Author: Raven
 * @Date: 2019/8/2 10:20 AM
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("Authorization");

        // 校验失败
        if (authHeader == null || !authHeader.startsWith("Bearer:")) {
            resetResponse(response, E_603);
            return false;
        }

        // 取得token
        String token = authHeader.substring(7);

        // 验证token
        try {
            Claims claims = JwtUtil.checkToken(token);
            request.setAttribute("userId", claims.getSubject());
        }catch (UserLoginInvalidException e) {
            resetResponse(response, E_604);
        } catch (UserLoginException e) {
            resetResponse(response, E_603);
        }

        return true;
    }

}