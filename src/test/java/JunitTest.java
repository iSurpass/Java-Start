import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class JunitTest {


    @Before
    public void init(){
        System.out.println("初始化");
    }

    @Test
    public void testStr(){

        String a ="1";

        Assertions.assertNotNull(a);
        Assertions.assertEquals(a,"1");
    }

    @Test
    public void testInt(){

        int a =1;

        Assertions.assertTrue(a==1);
    }
}
