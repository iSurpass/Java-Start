package tech.DoFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadJsonTest {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map map = objectMapper.readValue(new File("./demo.json"),Map.class);
            System.out.println(map.get("Name"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
