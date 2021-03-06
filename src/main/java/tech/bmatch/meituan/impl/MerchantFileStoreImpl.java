package tech.bmatch.meituan.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.bmatch.meituan.Application;
import tech.bmatch.meituan.model.Merchant;
import tech.bmatch.meituan.service.MerchantService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class MerchantFileStoreImpl implements MerchantService {

    private static final Logger logger = LoggerFactory.getLogger(MerchantFileStoreImpl.class);

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static File file = new File("./data4.json");

    @Override
    public void init() {
        if (!file.exists()){
            return;
        }
        try {
            List<Merchant> merchantList = objectMapper.readValue(file,new TypeReference<List<Merchant>>(){
            });
            for (Merchant merchant:merchantList){
                add(merchant);
            }
        }catch (IOException e){
            logger.error("",e);
        }
    }

    public void store(List<Merchant> merchants){
        if (merchants ==null){
            return;
        }try {
            objectMapper.writeValue(file,merchants);
        }catch (IOException e){
            logger.error("",e);
        }
    }
}
