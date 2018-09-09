package tech.bmatch.meituan;

import tech.bmatch.meituan.impl.MerchantServiceimpl;
import tech.bmatch.meituan.model.Merchant;
import tech.bmatch.meituan.service.MerchantService;

import java.util.List;

public class Application {

    private static MerchantService merchantService = new MerchantServiceimpl();

    public static void main(String[] args) {
        init();

        List<Merchant> merchantList = merchantService.search(120.026208,30.279212);
        for (Merchant merchant:merchantList){
            System.out.println("商家名称"+merchant.getName());
            Double distance = merchant.getDistance();
            //处理成整数
            System.out.println("距离"+distance.intValue()+"m");
            System.out.println("----------");
        }
    }

    private static void init(){
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
