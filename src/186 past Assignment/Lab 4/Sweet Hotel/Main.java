import java.text.DecimalFormat;
import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        String bookingCode;
        String customerName;
        String phoneNo;
        char promotionType;
        int day;
        double deposit;
        String block;
        String level;
        String no;

        System.out.println("---Welcome to Hotel Reservation System---");
        System.out.print("\nEnter the amount of array: ");
        int size = scan1.nextInt();
        scan1.nextLine();
        System.out.println();
        
        DecimalFormat df = new DecimalFormat("###,###.00");
        HotelPromotion[] promo = new HotelPromotion[size];
        
        for (int i = 0; i < size; i++){
            System.out.print("Enter booking code: ");
            bookingCode = scan.nextLine();

            System.out.print("Enter customer name: ");
            customerName = scan.nextLine();

            System.out.print("Enter phone number: ");
            phoneNo = scan.nextLine();
            
            System.out.print("\n------------");
            System.out.print("\nL - Luxury (RM 4000 / Day)");
            System.out.print("\nB - Budget (RM 1500 / Day)");
            System.out.print("\nS - SweetEscape (RM 3300 / Day)");
            System.out.print("\n------------");

            System.out.print("\nEnter promotion type: ");
            promotionType = scan1.next().charAt(0);
            promotionType = Character.toUpperCase(promotionType);
                
            System.out.print("Enter day: ");
            day = scan1.nextInt();
            scan1.nextLine();

            System.out.print("Enter block: ");
            block = scan.nextLine();

            System.out.print("Enter level: ");
            level = scan.nextLine();

            System.out.print("Enter room code (e.g " + level + "01): ");
            no = scan.nextLine();
            
            System.out.print("Enter deposit: RM ");
            deposit = scan1.nextDouble();
            scan1.nextLine();

            promo[i] = new HotelPromotion(bookingCode, customerName, phoneNo, promotionType, day,  block, level, no, deposit);
            System.out.println();
        }
        int count = 0;
        int choice = 0;
        while (choice != 3){
            System.out.print("\n------------");
            System.out.println("\n1. Count and display the booking code of customer who alerady paid for booking.");
            System.out.println("\n2. Find the customer check-in based on booking code entered by the user.");
            System.out.println("\n3. Exit");
            System.out.print("\n------------");
            System.out.print("\nEnter your choice: ");
            choice = scan1.nextInt();

            if (choice == 1){
                for (int i = 0; i < promo.length; i++){
                    if (promo[i].getDeposit() > 0){
                        count++;
                    }
                }
                System.out.println("The number of customers who already booking: " + count);
            }
            else if (choice == 2){
                boolean found = false;
                    double firstPrice = 0;
                    System.out.print("Enter the booking code (e.g " + promo[0].getBookingCode() + "): ");
                    bookingCode = scan.nextLine();
                    System.out.println();

                    for (int i = 0; i < promo.length; i++){
                        if (promo[i].getBookingCode().equals(bookingCode)){
                            System.out.println("Customer name: " + promo[i].getCustomerName());
                            System.out.println("Phone number: " + promo[i].getPhoneNo());
                            System.out.println("Promotion type: " + promo[i].getPromotionType());
                            System.out.println("Day: " + promo[i].getDay());
                            System.out.println("Block: " + promo[i].getRoomReserve().getBlock());
                            System.out.println("Level: " + promo[i].getRoomReserve().getLevel());
                            System.out.println("Room code: " + promo[i].getRoomReserve().getNo());
                            
                            switch (promo[i].getPromotionType()){
                                case 'L':
                                    firstPrice = 4000 * promo[i].getDay();
                                    break;
                                case 'B':
                                    firstPrice = 1500 * promo[i].getDay();
                                    break;
                                case 'S':
                                    firstPrice = 3300 * promo[i].getDay();
                                    break;
                            }
                            System.out.printf("Original price: RM %,.2f\n", firstPrice);
                            System.out.printf("\nBalance left to be paid: RM%,.2f\n", firstPrice - promo[i].getDeposit() - promo[i].calculatePromotion());
                            found = true;
                        }
                        if (!found){
                            System.out.println("Booking code not found.");
                        }
                    }
            }
            else if (choice == 3){
                System.out.println("\n---Thank you for using Hotel Reservation System.---");
            }
            else
                System.out.println("Invalid choice.");
            
            System.out.println();
        }
        scan.close();
        scan1.close();
    }
}