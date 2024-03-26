import java.text.DecimalFormat;
import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        String name, contactNo, streetName, district, state;
        double travelDistance;
        char lorrytype;
        boolean driver;

        System.out.println("---Welcome to Lorry Rental System---");
        System.out.print("\nEnter the array: ");
        int size = scan1.nextInt();
        DecimalFormat df = new DecimalFormat("###,###.00");
        Renter[] Renter = new Renter[size];

        for (int i = 0; i < size; i++){
            System.out.print("\nEnter your name: ");
            name = scan.nextLine();

            System.out.print("Enter contact number: ");
            contactNo = scan.nextLine();
            
            System.out.print("Enter street name: ");
            streetName = scan.nextLine();

            System.out.print("Enter district: ");
            district = scan.nextLine();

            System.out.print("Enter state: ");
            state = scan.nextLine();

            System.out.print("Enter travel distance (KM): ");
            travelDistance = scan1.nextDouble();

            System.out.print("\n------------");
            System.out.print("\nA - 1 Ton (10 ft) with 2 movers.");
            System.out.print("\nB - 3 Ton (17 ft) with 3 movers.");
            System.out.print("\nC - 5 Ton (17 ft) with 5 movers.");
            System.out.print("\n------------");

            System.out.print("\nEnter lorry type: ");
            lorrytype = scan1.next().charAt(0);
            lorrytype = Character.toUpperCase(lorrytype);

            System.out.print("Do you need a driver (Y/N): ");
            char driverChoice = scan1.next().charAt(0);

            if (driverChoice == 'Y' || driverChoice == 'y')
                driver = true;
            else
                driver = false;

            Renter[i] = new Renter(name, contactNo, streetName, district, state, travelDistance, lorrytype, driver);
            System.out.println();
        }

        int count = 0;
        for (int i = 0; i < size; i++){
            if (Renter[i].getLorrytype() == 'A' && !Renter[i].getDriver()){
                count++;
            }
        }
        System.out.println("Number of renter who choose 1-ton lorry with no driver option: " + count);

        for (int i = 0; i < size; i++){
            if (Renter[i].getLorrytype() == 'A' && !Renter[i].getDriver()){
                System.out.println("Renter who choose 1-ton lorry with no driver option:\n");
                Renter[i].displayRenter();
            }
        }

        System.out.print("\nDo you want to search for a renter? (Y/N): ");
        char choice = scan1.next().charAt(0);
        while (choice == 'Y' || choice == 'y'){
            boolean found = false;
            System.out.print("Enter the contact number: ");
            String findContactNo = scan.nextLine();
            System.out.println();

            for (int i = 0; i < size; i++){
                if (findContactNo.equals(Renter[i].getContactNo())){
                    found = true;
                    Renter[i].displayRenter();
                }
            }
            if (found == false){
                    System.out.println("The record does not exist.");
            }

            System.out.print("\nDo you want to find for another renter? (Y/N): ");
            choice = scan1.next().charAt(0);   
        }
        System.out.println("\n---Thank you for using Lorry Rental System---");
        System.out.println("---Developed by: InsanSoftHouse Sdn Bhd---");
        System.out.println();
        scan.close();
        scan1.close();
    }
}