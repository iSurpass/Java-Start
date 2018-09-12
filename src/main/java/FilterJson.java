import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJson {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        //读取json文件，转化为list格式
        List<Merchant> merchantList = null;
        try {
            merchantList = objectMapper.readValue(new File("./demo2.json"),
                    new TypeReference<List<Merchant>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        //执行stream过滤
        List<Merchant> merchantList1 = merchantList.stream().
                filter(m->
                        m.getName().indexOf("必胜客") >=0).collect(Collectors.toList());
        for (Merchant merchant:merchantList1){
            System.out.println(merchant.getName());
        }
    }
}