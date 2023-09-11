package com.zpark.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class User {

    private Integer uid;

    @NotEmpty(message = "账号不能为空", groups = {Register.class})
    private String username;

    @NotNull(message = "密码不能为空", groups = {Register.class, Login.class})
    @Size(min = 8, max = 16, message = "密码不符合格式", groups = {Register.class, Login.class})
    private String password;

    @NotEmpty(message = "手机号不能为空", groups = {Register.class, Login.class})
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号不符合格式", groups = {Register.class, Login.class})
    private String phone;

    private String sex;

    private String address;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regtime;


    public static interface Login{}

    public static interface Register{}

}
