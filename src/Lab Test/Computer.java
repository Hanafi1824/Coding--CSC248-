import java.util.ArrayList;
import java.util.Scanner;

public class Computer {
    private String brand;
    private String serialNo;
    private int year;
    private double price;

    public Computer(String b, String s, int y, double p){
        brand = b;
        serialNo = s;
        year = y;
        price = p;
    }

    public String getBrand(){ return brand; }
    public String getSerialNumber(){ return serialNo; }
    public int getYear(){ return year; }
    public double getPrice(){ return price; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setSerialNumber(String serialNo) { this.serialNo = serialNo; }
    public void setYear(int year) { this.year = year; }
    public void setPrice(double price) { this.price = price; }

    public static void main(String[] args) { // main class
        Scanner sc = new Scanner(System.in);
        ArrayList<Computer> listComputer1 = new ArrayList<Computer>(); //Question i)
        ArrayList<Computer> listComputer2 = new ArrayList<Computer>(); 

        Computer[] c = new Computer[3];

        for (int i = 0; i < c.length; i++){ // Question ii)
            System.out.print("Enter computer brand: ");
            String b = sc.nextLine();
            System.out.print("Enter the serial number: ");
            String serialNo = sc.nextLine();
            System.out.print("Enter the year: ");
            int year = sc.nextInt();
            System.out.print("Enter the price: RM ");
            double price = sc.nextDouble();
            sc.nextLine();

            c[i] = new Computer(b, serialNo, year, price);
            listComputer1.add(c[i]);
        }

        for (int i = 0; i < listComputer1.size(); i++){ // Question iii)
            System.out.println("Brand                   Serial Number       Year        Price (RM)");
            System.out.println(listComputer1.get(i).getBrand() + listComputer1.get(i).getSerialNumber() + listComputer1.get(i).getYear() + listComputer1.get(i).getPrice());
        }

        for (int i = 0; i < c.length; i++){  // Question iv)
            if (listComputer1.get(i).getYear() > 2015){
                listComputer2.add(c[i]);
                listComputer1.remove(c[i]);
            }
            System.out.println("The first list: " + listComputer1.toString());
            System.out.println("The second list: " + listComputer2.toString());
        }

        for (int i = 0; i < listComputer1.size(); i++){
            if(listComputer1.get(i).getSerialNumber().equalsIgnoreCase("10001010")){ // Question v)
                listComputer1.get(i).setBrand("Acer");
                listComputer1.get(i).setSerialNumber("10001011");
                listComputer1.get(i).setYear(2004);
                listComputer1.get(i).setPrice(5000.00);

                System.out.println(listComputer1.toString());
            }
        }
        sc.close();
    }
}