import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOReadTest {


    public static void main(String[] args) {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        try {
            str = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                reader.close();
            }catch (IOException e){

            }

            System.out.println("刚才控制台里输入了" + str);
        }
    }
}
