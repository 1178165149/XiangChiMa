package com.zpark.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("captcha")
public class CaptchaController {

    //session key name
    public static final String SESSION_VERIFY_KEY = "captcha";
    //用户传参键
    public static final String PARAMETER_VERIFY_KEY = "code";


    //生成验证码
    @GetMapping
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        GifCaptcha captcha = new GifCaptcha(130, 48, 4);
        captcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        //获取验证码文本
        String code = captcha.text();
        System.out.println("code = " + code);

        //将验证码存入session中
        request.getSession().setAttribute(SESSION_VERIFY_KEY, code);
        //把验证码输出到页面
        CaptchaUtil.out(captcha, request, response);

    }

}
