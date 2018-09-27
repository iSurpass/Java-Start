package tech.bmatch.meituan;

import tech.bmatch.meituan.impl.DishServiceImpl;
import tech.bmatch.meituan.impl.MerchantServiceimpl;
import tech.bmatch.meituan.model.Dish;
import tech.bmatch.meituan.model.Merchant;
import tech.bmatch.meituan.model.MerchantSearchParam;
import tech.bmatch.meituan.service.DishService;
import tech.bmatch.meituan.service.MerchantService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static MerchantService merchantService = new MerchantServiceimpl();

    private static DishService dishService = new DishServiceImpl();

    public static void main(String[] args) {

        logger.info("应用启动");

        boolean Flag = true;

        List<Dish> dishList = null;

        merchantService.init();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入菜品名称及价格");
        while (Flag) {
            String message = null;
            try {
                message = bufferedReader.readLine();
                dishList = initDish(message.split(" "));
            } catch (IOException e) {
                logger.error("", e);
            }

            System.out.println("您是否继续录入菜品(YorN):");
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String commend = null;

            try {
                commend = bufferedReader.readLine();
            } catch (IOException e) {
                logger.error("", e);
            }
            if (commend.equals("N")) {
                Flag = false;
            }


        }

        show(dishList);

        /*
        while (true)
        {
            String commend = null;
            try {
                commend = bufferedReader.readLine();
            } catch (IOException e) {
                logger.error("",e);
            }

            System.out.println("执行命令:"+commend);

            if (commend.startsWith("add")){
                String content = commend.replaceAll("add ","");
                initMerchant(content.split(" "));
            }if (commend.startsWith("search ")){
                String content = commend.replaceAll("search ","");
                search(content);
        }
        }*/
    }

    public static void show(List<Dish> dishes) {
        if (dishes == null) {
            return;
        }
        System.out.println("------本店菜单-------");
        for (Dish dish : dishes) {
            System.out.println("菜名:" + dish.getName() + "******" + dish.getPrice() + "￥");
        }

    }

    public static void search(String name) {
        MerchantSearchParam merchantSearchParam = new MerchantSearchParam();
        merchantSearchParam.setName(name);
        merchantSearchParam.setLon(120.026208);
        merchantSearchParam.setLat(30.279212);
        List<Merchant> merchantList = merchantService.search(merchantSearchParam);

        for (Merchant merchant : merchantList) {
            System.out.println("商家名称:" + merchant.getName());
            System.out.println("商家距离:" + merchant.getDistance());
            System.out.println("-----------------------");
        }
    }

    public static List<Dish> initDish(String[] items) {
        Dish dish = new Dish();
        dish.setName(items[0]);
        dish.setPrice(Double.valueOf(items[1]));

        List<Dish> dishList;

        dishList = dishService.add(dish);

        return dishList;

    }

    public static void initMerchant(String[] items) {


        Merchant merchant = new Merchant();
        merchant.setId(items[0]);
        merchant.setName(items[1]);
        merchant.setLon(Double.valueOf(items[2]));
        merchant.setLat(Double.valueOf(items[3]));

        merchantService.add(merchant);

    }

    private static void init() {
        //第一条数据
        Merchant merchant = new Merchant();
        merchant.setId("1");
        merchant.setName("麦当劳");
        merchant.setLat(30.275512);
        merchant.setLon(120.021523);
        merchantService.add(merchant);

        //第二条数据
        merchant = new Merchant();
        merchant.setId("2");
        merchant.setName("肯德基");
        merchant.setLon(120.022002);
        merchant.setLat(30.274293);
        merchantService.add(merchant);
    }


}
