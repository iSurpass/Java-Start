package tech.bmatch.meituan.impl;

import tech.bmatch.meituan.Utill.DistanceUtill;
import tech.bmatch.meituan.model.Merchant;
import tech.bmatch.meituan.model.MerchantSearchParam;
import tech.bmatch.meituan.service.MerchantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MerchantServiceimpl extends MerchantFileStoreImpl{

    private Map<String,Merchant> merchants;

    @Override
    public void init() {

    }

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

            List<Merchant> merchantList = merchants.values().stream().collect(Collectors.toList());

            store(merchantList);
    }


    public List<Merchant> search(MerchantSearchParam param) {

        List<Merchant> merchantList = new ArrayList<Merchant>();

        for (Map.Entry<String,Merchant>merchantEntry:merchants.entrySet()){

            Merchant merchant = merchantEntry.getValue();
            Double distance = DistanceUtill.getDistance(param.getLon(),param.getLat(),merchant.getLon(),merchant.getLat());
            merchant.setDistance(distance);
            merchantList.add(merchant);

        }

        Stream<Merchant> stream = merchantList.stream();

        if(param.getName()!=null&& !param.getName().equals("")){
            stream = stream.filter(m ->
                    m.getName().indexOf(param.getName()) >=0);
        }

        stream = stream.sorted((m1,m2) ->
                ((Double) m1.getDistance()).intValue() -
                        ((Double) m2.getDistance()).intValue());

        return stream.collect(Collectors.toList());

    }
}
