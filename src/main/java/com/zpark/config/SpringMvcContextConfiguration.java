package com.zpark.config;

import com.zpark.interceptor.CaptchaInterceptor;
import com.zpark.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.zpark")
@EnableWebMvc
public class SpringMvcContextConfiguration implements WebMvcConfigurer {


    //静态资源放行
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        System.out.println("viewResolver...");
        return new InternalResourceViewResolver("/view/", ".html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //验证码拦截器
        registry.addInterceptor(new CaptchaInterceptor())
                .addPathPatterns("/users/register");  //注册请求时，先验证验证码的正确性

        //登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/meal/**", "/users","/users/register", "/users/login"
                        , "/captcha","/meal/upload");
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(10485760); // 设置上传文件大小的最大值，此处为10MB
        return multipartResolver;
    }
    
}
