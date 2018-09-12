package tech.DoFile;

import java.io.*;

public class WirFileTest {
    public static void main(String[] args) {
        File file = new File("./demo.json");
        if (!file.exists()){
            if (file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("文件名称:"+file.getName());
        System.out.println("文件路径:"+file.getAbsolutePath());

        BufferedWriter bufferedWriter = null;
        try {
            FileOutputStream out = new FileOutputStream(file);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write("Test....");
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
