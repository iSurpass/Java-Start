
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderSerivce {

    private String address;

    public Order createOrder(OrderDishes[] orderDishes) throws NoAddressException {

        if(address == null){
            throw new NoAddressException();
        }

        Order order = new Order();
        double totalAmount = 0d;

        for (OrderDishes orderDish : orderDishes){

            double amount = orderDish.getDishes().getPrice()*orderDish.getCount();
            totalAmount = totalAmount + amount;

        }

        order.setTotalAmount(totalAmount);
        order.setDishes(orderDishes);
        return order;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void confirmOrder(Order order){
        System.out.println("本次下单地址:"+address);
        System.out.println("-----------------");
        System.out.println("本次订单信息:");
        for(OrderDishes dish: order.getDishes()){
            System.out.println("商品名称:"+dish.getDishes().getName());
            System.out.println("商品数量:"+dish.getCount());
            System.out.println("商品价格:"+dish.getDishes().getPrice());
            System.out.println("-----------------");
        }
        System.out.println("本次订单金额:"+order.getTotalAmount());
    }
    public void payOrder(Order order){

        boolean isTrue = false;
        while (!isTrue){

            String str = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                str = bufferedReader.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            double amount = Double.valueOf(str);
            if(amount == order.getTotalAmount()){
                isTrue = true;
            }
        }
    }

}
