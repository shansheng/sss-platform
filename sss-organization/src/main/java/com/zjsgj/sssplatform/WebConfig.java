package com.zjsgj.sssplatform;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //跨域请求配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")// 对接口配置跨域设置
                .allowedHeaders("*")// 允许任何头
                .allowedMethods("GET","PUT","POST","DELETE","HEAD","OPTIONS")// 允许方法（post、get等）
                //.allowedOrigins("*")// 允许任何域名使用
                .allowedOrigins()
                .allowCredentials(true);
    }

}
