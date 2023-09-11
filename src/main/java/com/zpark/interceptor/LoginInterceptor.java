package com.zpark.interceptor;

import com.zpark.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从 session 里获取用户信息
        User user = (User) request.getSession().getAttribute("user");

        if (Objects.isNull(user)){
            //未登录
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write("请先完成登录");
            return false;
        }

        return true;

    }
}
