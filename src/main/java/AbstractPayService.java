public abstract class AbstractPayService implements PayService{

    @Override
    public boolean callback(String payId,double amount){

        System.out.println("核销订单支付");

        return false;
    }
}
