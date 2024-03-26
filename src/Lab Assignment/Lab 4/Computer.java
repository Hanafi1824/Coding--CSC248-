public class Computer{
    private int serialNo; //computer identification
    private String brand; //brand name
    private int year; //year of buying
    private double price; //buying price

    public Computer(int sn, String b, int y, double p){//Normal constructor
        serialNo = sn;
        brand = b;
        year = y;
        price = p;
    }
    
    public int getSerialNo(){ return serialNo; }//Getter
    public String getBrand(){ return brand; }
    public int getYear(){ return year; }
    public double getPrice(){ return price; }

    public String toString(){
        return "\nSerial NO: "+ serialNo + "\nBrand: " + brand + "\nYear: " + year + "\nPrice: RM " + price;
    }
}