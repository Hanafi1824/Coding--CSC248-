public class DeliveryCustomer extends Customer{
    private String address;
    private double distance;

    public DeliveryCustomer(){
        super();
        address = "";
        distance = 0;
    }

    public DeliveryCustomer(String c, char pm, String a, double km){
        super(c, pm);
        address = a;
        distance = km;
    }

    public void setDeliveryCustomer(String a){ address = a; }

    public String getAddress(){ return address; }
    public double getDistance(){ return distance; }

    public double calculatePrice(double km){
        double price = 0;
        double deliveryCharge = 0;

        if (getPackageMenu() == 'A' || getPackageMenu() == 'a')
            price = 100;
        else if (getPackageMenu() == 'B' || getPackageMenu() == 'b')
            price = 150;
        else if (getPackageMenu() == 'C' || getPackageMenu() == 'c')
            price = 200;

        if (km > 15)
            deliveryCharge = 10;
        else
            deliveryCharge = 0;
            
        return price + deliveryCharge;
    }

    public boolean isDineIn(){
        return false;
    }

    public String toString(){
        return super.toString() + "\nAddress: " + address;
    }
}
