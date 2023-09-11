package com.zpark.controller;

import com.zpark.entity.User;
import com.zpark.service.UserService;
import com.zpark.utils.BindingResultHelper;
import com.zpark.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    //从session里获取登录用户信息
    @GetMapping
    public User sessionUser(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }

    //退出登录
    @PostMapping("logout")
    public Result logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return Result.SUCCESS("已退出登录");
    }


    //注册
    @PostMapping("register")
    public Result register(@Validated(User.Register.class) User user, BindingResult result){

        if (result.hasErrors()){
            Map<String, String> map = BindingResultHelper.toErrorMap(result);
            return Result.ERROR("参数错误").put("errorMsg", map);
        }

        boolean register = userService.register(user);

        return register ? Result.SUCCESS("注册成功").put("username", user.getUsername()) : Result.ERROR("注册失败");

    }


    //登录
    @PostMapping("login")
    public Result login(@Validated(User.Login.class) User user, BindingResult result, HttpServletRequest request){

        if (result.hasErrors()){
            Map<String, String> map = BindingResultHelper.toErrorMap(result);
            return Result.ERROR("参数错误").put("errorMsg", map);
        }

        User _user = userService.login(user);

        if (_user != null){
            //登录成功
            request.getSession().setAttribute("user", _user);
            return Result.SUCCESS("登录成功");
        }else {
            //登录失败
            return Result.ERROR("手机号或密码错误");
        }


    }

}
