package com.zpark.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 结果集工具类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;           //状态码
    private String msg;             //消息
    private Map<String, T> data;    //数据

    public static <T> Result<T> SUCCESS(String msg){
        return new Result<>(200, msg, new HashMap<>());
    }

    public static <T> Result<T> ERROR(String msg){
        return new Result<>(404, msg, new HashMap<>());
    }

    public Result<T> put(String key, T value){
        data.put(key, value);
        return this;
    }


}
