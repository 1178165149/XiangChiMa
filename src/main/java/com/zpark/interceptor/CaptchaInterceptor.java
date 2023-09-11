package com.zpark.interceptor;

import com.zpark.controller.CaptchaController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码拦截器
 */
public class CaptchaInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //校验验证码
        HttpSession session = request.getSession();
        //从 session 中获取验证码
        Object codeInSession = session.getAttribute(CaptchaController.SESSION_VERIFY_KEY);
        //用户传来的验证码
        String code = request.getParameter(CaptchaController.PARAMETER_VERIFY_KEY);
        //验证码错误时
        if (!codeInSession.equals(code)){
            //从session中移除验证码
            session.removeAttribute(CaptchaController.SESSION_VERIFY_KEY);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("验证码错误");
            return false;
        }
        return true;
    }
}
