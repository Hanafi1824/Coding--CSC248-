import java.util.*;

public class MainApp {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        CarRental[] car = new CarRental[10];

        for (int i = 0; i < 10; i++){
            car[i] = new CarRental();
        }

        for (int i = 0; i < 10; i++){
            System.out.print("Enter customer IC: ");
            String IC = scan.nextLine();
            System.out.print("Enter customer name: ");
            String name = scan.nextLine();
            System.out.print("Enter customer phone number: ");
            String phone = scan.nextLine();
            System.out.print("Enter the period hours: ");
            double period = scan.nextDouble();
            System.out.print("Do you need a driver? (true / false): ");
            boolean driver = scan1.nextBoolean();
            scan.nextLine();
            System.out.println();

            car[i] = new CarRental(IC, name, phone, period, driver);
        }

        int i;
        System.out.println("\nAll the information: ");
        for (i = 0; i < 10; i++){
           System.out.println(car[i].toString());
        }
        System.out.println("\nTotal amount of car rental: " + i);
        for (i = 0; i < 10; i++){
            if (car[i].getDriver() == true){
               System.out.println(car[i].toString());
           }
        }
        scan.close();
        scan1.close();
    }
}
