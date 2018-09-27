package tech.bmatch.meituan.service;

import tech.bmatch.meituan.model.Dish;

import java.util.List;

public interface DishService {

    public void init();

    public List<Dish> add(Dish dish);
}
