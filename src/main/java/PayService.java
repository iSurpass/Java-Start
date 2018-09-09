public interface PayService {

    public void pay(Order order);

    boolean callback(String payId,double amount);

}
