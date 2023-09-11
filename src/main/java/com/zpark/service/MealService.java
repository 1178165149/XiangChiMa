package com.zpark.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zpark.entity.Meal;
import com.zpark.mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    MealMapper mealMapper;

    //查询菜品列表
    public Page<Meal> searchMealList(String keyword, int page, int size){

        Page<Meal> pageBean = PageHelper.startPage(page, size);
        mealMapper.selectMealByTitleLike(keyword);

        return pageBean;
    }

    //根据id查询菜品详情
    public Meal searchMeal(int mid){
        return mealMapper.selectByMid(mid);
    }
    
    //根据类型查询一类菜品
    public Page<Meal> searchTypeList(String type, int page, int size){
        
        Page<Meal> pageBean = PageHelper.startPage(page, size);
        mealMapper.selectMealByType(type);
        
        return pageBean;
    }
    
	
    //增加一个菜品
    public void addMeal(Meal meal) {
        mealMapper.addMeal(meal);
    }
}
