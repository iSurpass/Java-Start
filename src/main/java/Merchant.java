public class Merchant {

    private String name;
    private String address;
    private Dishes[] dishes;

    public Dishes[] getDishes() {
        return dishes;
    }

    public void setDishes(Dishes[] dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
