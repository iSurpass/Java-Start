public class AliPayService extends AbstractPayService{
    @Override
    public void pay(Order order){
        System.out.println("支付宝支付");
    }


}
