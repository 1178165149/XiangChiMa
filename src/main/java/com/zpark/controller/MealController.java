package com.zpark.controller;


import com.github.pagehelper.Page;
import com.zpark.entity.Meal;
import com.zpark.service.MealService;
import com.zpark.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;


@RestController
@RequestMapping("meal")
public class MealController {

    @Autowired
    MealService mealService;

    @GetMapping
    public Result getMealList(int page, int size, String keyword){

        if (page <= 0){
            page = 1;
        }

        Page<Meal> mealPage = mealService.searchMealList(keyword, page, size);

        return Result.SUCCESS("查询成功")
                .put("mealList", mealPage.getResult())
                .put("pages", mealPage.getPages())
                .put("page", page);

    }
    
    //根据类型查询一类菜品
    @GetMapping("type")
    public Result getTypeList(String type,int page, int size){
        
        if (page <= 0){
            page = 1;
        }
        
        Page<Meal> mealPage = mealService.searchTypeList(type, page, size);
        
        return Result.SUCCESS("查询成功")
                .put("mealList", mealPage.getResult())
                .put("pages", mealPage.getPages())
                .put("page", page);
        
    }

    //localhost:8080/xcm/meal/2
    @GetMapping("/{mid}")
    public Result getMeal(@PathVariable int mid){
        Meal meal = mealService.searchMeal(mid);
        return meal != null ? Result.SUCCESS("查询成功").put("meal", meal) : Result.ERROR("没有相关菜品");
    }
    
    //上传菜品
    //localhost:8080/xcm/meal/upload
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMeal(@RequestParam("mealName") String mealName,
                             @RequestParam("meal-type") String mealType,
                             @RequestParam("meal-image") MultipartFile mealImage,
                             @RequestParam("meal-price") BigDecimal mealPrice) {
        // 保存图片到服务器
        String imgUrl = saveImage(mealImage);
        
        // 创建 Meal 对象并保存到数据库
        Meal meal = new Meal();
        meal.setTitle(mealName);
        meal.setType(mealType);
        meal.setUrl(imgUrl);
        meal.setPrice(mealPrice);
        mealService.addMeal(meal);
        
        return "success";
    }
    
    private String saveImage(MultipartFile file) {
        // 获取上传文件的原始文件名
        String originalFilename = file.getOriginalFilename();
        
        // 生成新的文件名
        String newFilename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        
        // 获取上传文件的保存路径，可以从配置文件中读取
        String savePath = "src/main/webapp/img/";
        
        // 将文件保存到服务器
        try {
            file.transferTo(new File(savePath + newFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 返回图片的相对路径
        return "../img/" + newFilename;
    }
}
    

