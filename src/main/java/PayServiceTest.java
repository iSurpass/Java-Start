public class PayServiceTest {
    public static void main(String[] args) {

        PayService payService = new AliPayService();

        Order order = new Order();

        order.setOrderId("234");

        order.setTotalAmount(456d);

        payService.pay(order);

        payService.callback("234",456d);

    }
}
