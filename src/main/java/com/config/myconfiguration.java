package com.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
public class myconfiguration implements WebMvcConfigurer {
    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new myInterceptor()).addPathPatterns("/**");
    }
    //配置静态资源访问映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/layui/**").addResourceLocations("classpath:/static/layui/");
//            registry.addResourceHandler("/MySign_in/**").addResourceLocations("classpath:/static/MySign_in/");
            registry.addResourceHandler("/blog/**").addResourceLocations("classpath:/static/");
    }
}
