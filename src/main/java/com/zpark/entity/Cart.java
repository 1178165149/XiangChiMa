package com.zpark.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Cart {

    private Integer cid;

    private Integer uid;

    private Integer mid;

    private Integer cnt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime opttime;

    //一对一 一个购物车数据对应于一个菜品信息
    private Meal meal;
}
