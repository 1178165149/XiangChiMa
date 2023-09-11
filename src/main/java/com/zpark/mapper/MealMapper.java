package com.zpark.mapper;

import com.zpark.entity.Meal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MealMapper {

    //根据关键字查询菜品列表
    List<Meal> selectMealByTitleLike(String keyword);

    //根据菜品id查询单个菜品
    Meal selectByMid(int mid);
	
	//根据类型查询一类菜品
	List<Meal> selectMealByType(String type);
	
	//新增一个菜品
	void addMeal(Meal meal);
}
