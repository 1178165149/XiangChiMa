package com.zpark.mapper;

import com.zpark.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //添加一个用户
    int add(User user);

    //根据手机号查询用户
    User selectUserByPhone(User user);

}
