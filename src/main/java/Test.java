public class Test {
    public static void main(String[] args) {
        FastCar fastCar = new FastCar();
        fastCar.setBrand("宝马");
        fastCar.setPlateNumber("浙A888888");
        System.out.println("我在滴滴上打了一辆牌照为"+fastCar.getPlateNumber()+"的"+fastCar.getBrand()+"车");
    }
}
