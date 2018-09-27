package tech.bmatch.meituan.impl;

import tech.bmatch.meituan.model.Dish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DishServiceImpl extends DishFileStoreImpl{
    @Override
    public void init() {

    }

    private Map<String,Dish> dishes;

    public List<Dish> add(Dish dish) {
            if(dishes==null){
                dishes = new HashMap<String, Dish>();
            }

            dishes.put(dish.getName(),dish);
        List<Dish> dishList = dishes.values().stream().collect(Collectors.toList());

        store(dishList);

        return dishList;

    }
}
