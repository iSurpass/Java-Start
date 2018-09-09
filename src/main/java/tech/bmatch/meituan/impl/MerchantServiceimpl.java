package tech.bmatch.meituan.impl;

import tech.bmatch.meituan.Utill.DistanceUtill;
import tech.bmatch.meituan.model.Merchant;
import tech.bmatch.meituan.service.MerchantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MerchantServiceimpl implements MerchantService {

    private Map<String,Merchant> merchants;

    public void add(Merchant merchant) {
            //初始化 merchants
            if(merchants==null){
                merchants = new HashMap<String, Merchant>();
            }
            //数据校验
            if (merchant==null){
                return;
            }
            //往map里添加数据
            merchants.put(merchant.getId(),merchant);
    }


    public List<Merchant> search(double lon, double lat) {

        List<Merchant> merchantList = new ArrayList<Merchant>();

        for (Map.Entry<String,Merchant>merchantEntry:merchants.entrySet()){

            Merchant merchant = merchantEntry.getValue();
            Double distance = DistanceUtill.getDistance(lon,lat,merchant.getLon(),merchant.getLat());
            merchant.setDistance(distance);
            merchantList.add(merchant);

        }

        return merchantList;
    }
}
