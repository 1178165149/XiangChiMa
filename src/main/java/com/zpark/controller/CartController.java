package com.zpark.controller;

import com.zpark.entity.Cart;
import com.zpark.entity.User;
import com.zpark.service.CartService;
import com.zpark.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController  //返回JSON字符串
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;

    //加入购物车
    @PostMapping
    public Result addCart(Integer mid, HttpServletRequest request){
        //获取登录用户信息
        User user = (User) request.getSession().getAttribute("user");
        boolean flag = cartService.addCart(user.getUid(), mid);

        return flag ? Result.SUCCESS("菜品成功加入购物车") : Result.ERROR("添加失败");
    }

    //根据用户id查询购物车列表
    @GetMapping
    public Result getCartList(HttpServletRequest request){
        //获取登录用户信息
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user = " + user);

        List<Cart> cartList = cartService.getCartList(user.getUid());

        return Result.SUCCESS("购物车查询成功").put("cartList", cartList);
    }
}
