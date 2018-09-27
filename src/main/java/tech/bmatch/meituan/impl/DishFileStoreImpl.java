package tech.bmatch.meituan.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.bmatch.meituan.model.Dish;
import tech.bmatch.meituan.service.DishService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class DishFileStoreImpl implements DishService {
    private static final Logger logger = LoggerFactory.getLogger(MerchantFileStoreImpl.class);

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static File file = new File("./data5.json");

    @Override
    public void init() {
        if (!file.exists()){
            return;
        }
        try {
            List<Dish> dishList = objectMapper.readValue(file,new TypeReference<List<Dish>>(){
            });
            for (Dish dish:dishList){
                add(dish);
            }
        }catch (IOException e){
            logger.error("",e);
        }
    }

    public List<Dish> store(List<Dish> dishes){
        if (dishes ==null){
            return dishes;
        }try {
            objectMapper.writeValue(file,dishes);
        }catch (IOException e){
            logger.error("",e);
        }

        return dishes;
    }


}
