public class Vehicle{
    private String carType;
    private String carPlate;
    private double carPrice;

    public Vehicle(String cT, String cP, double p){
        carType = cT;
        carPlate = cP;
        carPrice = p;
    }

    public void setVehicle(String cT, String cP, double p){
        carType = cT;
        carPlate = cP;
        carPrice = p;
    }

    public String getCarType(){ return carType; }
    public String getCarPlate(){ return carPlate; }
    public double getCarPrice(){ return carPrice; }

    public String toString(){
        return "Car Type: " + carType + "\nPlate Number: " + carPlate + "\nPrice: " + carPrice;
    }
}