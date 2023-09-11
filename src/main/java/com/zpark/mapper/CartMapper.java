package com.zpark.mapper;

import com.zpark.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {


    //根据用户id和菜品id查询购物车信息
    Cart select(@Param("uid") Integer uid, @Param("mid") Integer mid);

    //新增一条购物车数据
    int insert(Cart cart);

    //修改购物车菜品数量
    int update(Cart cart);

    //根据用户id查询菜品列表
    List<Cart> selectByUid(Integer uid);
}
