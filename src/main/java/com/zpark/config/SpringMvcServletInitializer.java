package com.zpark.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class SpringMvcServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //读取 spring 容器配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //读取 spring web mvc 容器配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcContextConfiguration.class};
    }

    //注册 DispatcherServlet 用于处理哪些 url
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //全栈编码 utf-8
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8", true)};
    }


    // 注册 Servlet 文件上传大小
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // 指定上传文件允许的最大大小 默认值为1MB
        long maxFileSize = 1 * 1024 * 1024 * 2;
        // 指定multipart/form-data请求允许的最大大小。 默认值为10MB
        long maxRequestSize = 1 * 1024 * 1024 * 2;
        // 指定文件将写入磁盘的大小阈值。 默认值为0
        int fileSizeThreshold = 0;

        MultipartConfigElement multipart =
                new MultipartConfigElement("", maxFileSize, maxRequestSize, fileSizeThreshold);

        registration.setMultipartConfig(multipart);

    }

}
