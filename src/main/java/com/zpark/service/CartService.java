package com.zpark.service;

import com.zpark.entity.Cart;
import com.zpark.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;

    //添加菜品到购物车
    public boolean addCart(Integer uid, Integer mid){

        //查询此菜品有没有添加过购物车，如果有，则修改购物车的菜品数量，否则就新增一条购物车数据
        Cart cart = cartMapper.select(uid, mid);

        if (cart == null){
            //菜品没有加入过购物车
            Cart _cart = new Cart();
            _cart.setUid(uid);
            _cart.setMid(mid);
            _cart.setCnt(1);
            //新增购物车到数据表里
            return cartMapper.insert(_cart) == 1;
        }else {
            //菜品已经加入了购物车
            cart.setCnt(cart.getCnt() + 1);
            //修改原有购物车数量
            return cartMapper.update(cart) == 1;
        }
    }


    //根据用户查询购物车列表
    public List<Cart> getCartList(Integer uid){
        return cartMapper.selectByUid(uid);
    }
}
