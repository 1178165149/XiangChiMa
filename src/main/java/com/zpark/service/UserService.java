package com.zpark.service;

import com.zpark.entity.User;
import com.zpark.mapper.UserMapper;
import com.zpark.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    //注册
    public boolean register(User user){
        //设置注册时间
        user.setRegtime(LocalDateTime.now());

        //加密密码
        String password = user.getPassword();
        String encrypt = MD5.encrypt(password);

        user.setPassword(encrypt);
        return userMapper.add(user) == 1 ? true : false;

    }

    //登录
    public User login(User user){

        //根据手机号查询出的数据库用户
        User u = userMapper.selectUserByPhone(user);
        //不存在此手机号的情况
        if (u == null){
            return null;
        }
        //用户传来的要校验的明文登录密码和数据库密文密码进行校验
        boolean flag = MD5.validate(user.getPassword(), u.getPassword());
        return flag ? u : null;

    }
}
