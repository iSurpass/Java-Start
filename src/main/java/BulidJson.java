import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.bmatch.meituan.model.Merchant;

import java.io.File;
import java.io.IOException;

public class BulidJson {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Merchant merchant = new Merchant();
        merchant.setName("麦当劳");

        String jsonContent = null;
        Merchant merchant1 = null;
        File file = new File("./demo1.json");
        try {
            jsonContent = objectMapper.writeValueAsString(merchant);
            System.out.println(merchant1);

            merchant1 = objectMapper.readValue(jsonContent,Merchant.class);
            System.out.println(merchant1.getName());

            objectMapper.writeValue(file,merchant);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
