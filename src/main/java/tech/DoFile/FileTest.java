package tech.DoFile;

import java.io.*;

//读取文件 IO输出流

public class FileTest {
    public static void main(String[] args) {
        File file = new File("./pom.xml");
        BufferedReader bufferedReader = null;
        try {
            FileInputStream in = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(in));

            String line = null;

            while ((line = bufferedReader.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
