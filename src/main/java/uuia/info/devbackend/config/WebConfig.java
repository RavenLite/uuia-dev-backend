package uuia.info.devbackend.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uuia.info.devbackend.component.JwtInterceptor;

/**
 * web配置
 * @Author: Raven
 * @Date: 2019/8/2 10:20 AM
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器//放掉某些特定不需要校验token的路由
        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/sign-in", "/sign-up", "/activation");

    }

}
