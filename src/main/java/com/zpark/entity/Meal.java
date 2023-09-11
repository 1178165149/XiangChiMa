package com.zpark.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 菜品类
 */
@Data
public class Meal {

    private Integer mid;        //菜品id
    private String url;         //菜品图片地址
    private BigDecimal price;   //金额必须使用精确表达
    private String title;       //菜品标题
    private String shop;        //菜品所属店铺
    private String type;        //菜品类型
    
    
    
    
}
