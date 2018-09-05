import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OrderApplication {

    public static void main(String[] args) {

            OrderDishes[] orderDishes = new OrderDishes[2];

            OrderDishes orderDishes1 = new OrderDishes();
            orderDishes[0] = orderDishes1;

            Dishes dishes = new Dishes();
            dishes.setName("红烧排骨");
            dishes.setPrice(10d);
            orderDishes1.setDishes(dishes);
            orderDishes1.setCount(3);

            orderDishes1 = new OrderDishes();
            orderDishes[1] = orderDishes1;

            dishes = new Dishes();
            dishes.setPrice(20d);
            dishes.setName("糖醋里脊");
            orderDishes1.setDishes(dishes);
            orderDishes1.setCount(2);



            OrderSerivce orderSerivce = new OrderSerivce();

        Order order = null;
        try {
            order = orderSerivce.createOrder(orderDishes);
        } catch (NoAddressException e) {
            System.out.println("请输入收货地址");
            initAdress(orderSerivce);
            try {
                order = orderSerivce.createOrder(orderDishes);
            } catch (NoAddressException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println(order.getTotalAmount());

        orderSerivce.confirmOrder(order);

        orderSerivce.payOrder(order);

    }

    public static void initAdress(OrderSerivce orderSerivce){
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                str = bufferedReader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }

        orderSerivce.setAddress(str);

    }
}
