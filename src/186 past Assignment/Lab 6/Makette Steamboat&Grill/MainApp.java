import java.util.*;

public class MainApp {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        DineInCustomer[] dine = new DineInCustomer[50];
        DeliveryCustomer[] delivery = new DeliveryCustomer[50];

        for (int i = 0; i < 50; i++){
            dine[i] = new DineInCustomer();
            delivery[i] = new DeliveryCustomer();
        }

        int condition = 0;
        double totalPriceDelivery = 0;
        int totalDineIn = 0;
        for (int i = 0; i < 50; i++){
            System.out.print("Enter the customer name: ");
            String customerName = scan.nextLine();
            System.out.println("\nA - combo1\nB - combo2\nC - combo3\nD - none");
            System.out.print("Enter the packages: ");
            char packageMenu = scan.next().charAt(0);
            System.out.println("\n1 - Dine in\n2 - Delivery");
            System.out.print("Dine in / Delivery ?: ");
            condition = scan1.nextInt();
            scan.nextLine();

            if (condition == 1){
                System.out.print("Enter the number of adult (above 12 years): ");
                int numOfAdult = scan1.nextInt();
                System.out.print("Enter the number of child (Between 6 - 12 years): ");
                int numOfChild = scan1.nextInt();
                System.out.print("Enter the other package: ");
                char otherPackage = scan.next().charAt(0);
                System.out.print("\n");

                scan.nextLine();
                dine[i] = new DineInCustomer(customerName, packageMenu, numOfAdult, numOfChild, otherPackage);
                totalDineIn++;
            }
            else if (condition == 2){
                System.out.print("Enter the address: ");
                String address = scan.nextLine();
                System.out.print("Enter the distance (km): ");
                double km = scan1.nextDouble();
                System.out.print("\n");
                delivery[i] = new DeliveryCustomer(customerName, packageMenu, address, km);
                totalPriceDelivery += delivery[i].calculatePrice(km);
            }
        }

        System.out.println("All information: ");
        
        for (int i = 0; i < 50; i++){
            if (dine[i].getCustomer().equals(""))
                continue;
            System.out.println(dine[i].toString());
        }
        
        System.out.println("\nTotal number of dine-in customer: " + totalDineIn);
        System.out.println("Total price for all delivery customer: RM " + totalPriceDelivery);
        scan.close();
        scan1.close();
    }
}