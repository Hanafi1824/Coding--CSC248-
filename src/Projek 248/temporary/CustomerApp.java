import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomerApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// int, double
        Scanner scan1 = new Scanner(System.in);// string, char
        LocalDateTime myDateObj = LocalDateTime.now();// print the current date
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Customer c = new Customer();
        Queue cList = new Queue();

        System.out.println("\n\t==================================================");
            System.out.println("\t                  WARCOFF CAFE                      ");
            System.out.println("\t==================================================");
            System.out.print("Enter Y to start order: ");
            char orderMore = scan1.next().charAt(0);
            orderMore = Character.toUpperCase(orderMore);
            //attributes:
            char aoChoice = '\u0000', temperature = '\u0000', size = '\u0000', addOn = '\u0000';
            int choice = 0, orderNum = 0, foodAddOnChoice = 0, quantity = 0;
            double payment = 0, membershipDiscount = 0;
            String membershipName = "", email = "", membershipCode = "";
            while (orderMore == 'Y') {
                System.out.print("\033\143");// clear the output
                System.out.println("WELCOME TO WARCOFF CAFE!!");
                System.out.println("[1] Western Food, [2] Dessert, [3] Coffee, [4] Ice Blended");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
                c.printMenu(choice);
    
                if (choice == 1) { // western food
                    System.out.print("Enter your order(1-7): ");
                    orderNum = scan.nextInt();
                    System.out.print("Do you want to add-on?: ");
                    aoChoice = scan1.next().charAt(0);
                    aoChoice = Character.toUpperCase(aoChoice);
    
                    if (aoChoice == 'Y') {
                        System.out.println("\n======================================");
                        System.out.print("|(1)Add ons:          |    Price:    |");
                        System.out.print("\n======================================");
                        System.out.print("\n|(1)Extra Cheese      |   RM  2.50   |");
                        System.out.print("\n|(2)Extra Sauce       |   RM  1.50   |");
                        System.out.print("\n|(3)Extra Mayonis     |   RM  1.50   |");
                        System.out.print("\n|(4)Mashed Potatoes   |   RM  5.50   |");
                        System.out.print("\n|(5)Coleslaw          |   RM  3.50   |");
                        System.out.println("\n======================================");
                        System.out.print("Choose your add-on(1-5): ");
                        foodAddOnChoice = scan.nextInt();
                    }
                } else if (choice == 2) { // dessert
                    System.out.print("Enter your order(1-5): ");
                    orderNum = scan.nextInt();
                } else if (choice == 3) { // coffee
                    System.out.print("Enter your order(1-6): ");
                    orderNum = scan.nextInt();
    
                    System.out.print("\nTemperature: [H] Hot / [C] Cold");
                    System.out.print("\nEnter the type of drink: ");
                    temperature = scan1.next().charAt(0);
                    temperature = Character.toUpperCase(temperature);
    
                    if (temperature == 'H') {// Hot drinks must regular size.
                        size = 'R';
                    }
    
                    else if (temperature == 'C') {// Cold drinks:
                        System.out.print("\nSize cup: [R] Regular / [L]  Large ");
                        System.out.print("\nEnter your size of cup: ");
                        size = scan1.next().charAt(0);
                        size = Character.toUpperCase(size);
                    }
                    System.out.print("\nAdd-on extrashot will add RM 1.50");
                    System.out.print("\nDo you want to add extrashot for coffee? (Y / N): ");
                    aoChoice = scan1.next().charAt(0);
                    aoChoice = Character.toUpperCase(aoChoice);
    
                    if (aoChoice == 'Y'){
                        addOn = 'E';
                    }
                    if (aoChoice == 'N') {
                        addOn = 'N';
                    }
                } else if (choice == 4) { // ice blended
                    System.out.print("Enter your order(1-5): ");
                    orderNum = scan.nextInt();
    
                    System.out.print("\nSize cup: [R] Regular / [L]  Large ");
                    System.out.print("\nEnter your size of cup: ");
                    size = scan1.next().charAt(0);
                    size = Character.toUpperCase(size);
    
                    System.out.print("\nAdd-on syrup will add RM 1.50");
                    System.out.print("\nDo you want to add syrup? (Y / N): ");
                    char addOnChoice = scan1.next().charAt(0);
                    addOnChoice = Character.toUpperCase(addOnChoice);
    
                    if (addOnChoice == 'Y' || addOnChoice == 'y')
                        ;
                    {
                        addOn = 'S';
                    }
                    if (addOnChoice == 'N' || addOnChoice == 'n')
                        ;
                    {
                        addOn = 'N';
                    }
                }
                System.out.print("\nEnter the quantity: ");// Quantity
                quantity = scan.nextInt();
    
                System.out.println(
                        "\n<<Membership account gives you 5% off! Create new account if you don't have one. Get 5% discount today!>>");
                System.out.print("\nDo you have a membership? (Y / N): ");// Membership:
                char conditionMembership = scan1.next().charAt(0);
                conditionMembership = Character.toUpperCase(conditionMembership);
    
                if (conditionMembership == 'Y') {// Check membership account:
                    System.out.print("\033\143");// clear the output
                    boolean found = true;
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("account.txt"));
                        String Data = null;
                        scan1.nextLine();
    
                        System.out.print("\nEnter the membership code: ");
                        String findMembershipCode = scan1.nextLine();
    
                        while ((Data = br.readLine()) != null && found) {
                            // System.out.println("" + Data);
                            String[] token = Data.split(";");
                            if (token[2].equals(findMembershipCode)) {
                                System.out.println("======================================================");
                                System.out.println("\nYour membership code: " + token[2]
                                        + "\nYou have membership account! You will get 5% discount.");
                                System.out.println("======================================================");
                                found = false;
                                membershipDiscount = 0.95;
                            }
                        }
                        if (found) {
                            System.out.println("==================================================");
                            System.out.println("\nSorry, you didn't have membership account.");
                            System.out.println("==================================================");
                        }
                        br.close();
                    } catch (FileNotFoundException fe) {
                        System.out.println(fe.getMessage());
                        fe.printStackTrace();
                    } catch (IOException iox) {
                        System.out.println(iox.getMessage());
                    } catch (Exception e) {
                        System.out.println("Problem: " + e.getMessage());
                    }
                }
    
                else if (conditionMembership == 'N') {
                    System.out.print("\033\143");// clear the output
                    System.out.print("\nDo you want to create account for membership? (Y / N): ");
                    char choiceMembership = scan1.next().charAt(0);
                    choiceMembership = Character.toUpperCase(choiceMembership);
                    if (choiceMembership == 'Y') {// Create new account and save data:
                        try {
                            PrintWriter outAccount = new PrintWriter(
                                    new BufferedWriter(new FileWriter("account.txt", true)));
                            scan1.nextLine();
    
                            System.out.println("==================================================");
                            System.out.println("CREATE MEMBERSHIP ACCOUNT:");
                            System.out.print("\nEnter your name: ");
                            membershipName = scan1.nextLine();
                            System.out.print("Create your email: ");
                            email = scan1.nextLine();
                            System.out.print("Create your membership code: ");
                            membershipCode = scan1.nextLine();
                            StringBuilder content = new StringBuilder();
                            outAccount.println();
                            content.append(membershipName).append(";").append(email).append(";").append(membershipCode).append("\n");

                            outAccount.print(content.toString().trim());
                            outAccount.close();
                        } catch (FileNotFoundException fe) {
                            System.out.println(fe.getMessage());
                            fe.printStackTrace();
                        } catch (IOException iox) {
                            System.out.println(iox.getMessage());
                        } catch (Exception e) {
                            System.out.println("Problem: " + e.getMessage());
                        }
                    }
                }
    
                boolean pay = false;
                while (!pay) {
                    System.out.print("Enter your money to purchase: RM ");
                    payment = scan.nextDouble();
                    c = new Customer(choice, orderNum, quantity, payment, foodAddOnChoice, temperature, size, addOn,
                            membershipName, email, membershipCode, membershipDiscount);
                    if (c.orderCalc() > payment) {
                        pay = false;
                        System.out.println("Insufficient payment. Please enter a valid amount.");
                    } else if (c.orderCalc() <= payment) { // enough payment
                        pay = true;
                        c.setTotalPrice(c.orderCalc());
                        cList.enqueue(c);
                    }
                }
                if(choice == 1 || choice == 2){ //food: store in text file
                    try{
                        PrintWriter outAccount = new PrintWriter(new BufferedWriter(new FileWriter("foodOrderedHistory.txt",true)));
                        scan1.nextLine();
                        StringBuilder content = new StringBuilder();
                        outAccount.println();
                        content.append(quantity).append(";").append(c.menuReceipt()).append(";").append(c.orderReceipt())
                        .append(";").append(c.foodAddOnReceipt()).append(";").append(c.foodAddOn()).append(";")
                        .append(c.orderCalc()).append(";").append(payment).append(";").append(c.balance()).append("\n");
                        outAccount.print(content.toString().trim());
                        outAccount.close();
                    }
                    catch(FileNotFoundException fe){
                        System.out.println(fe.getMessage());
                        fe.printStackTrace();
                    }
                    catch(IOException iox){
                        System.out.println(iox.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Problem: " + e.getMessage());
                    }
                }
                else if(choice == 3 || choice == 4){ //drink: store in text file
                    try{
                        PrintWriter outAccount = new PrintWriter(new BufferedWriter(new FileWriter("drinkOrderedHistory.txt",true)));
                        scan1.nextLine();
                        StringBuilder content = new StringBuilder();
                        outAccount.println();
                        content.append(quantity).append(";").append(c.menuReceipt2()).append(";").append(c.orderReceipt2())
                        .append(";").append(c.temperatureReceipt()).append(";").append(c.sizeReceipt()).append(";")
                        .append(c.drinkAddOnReceipt()).append(";").append(c.drinkAddOn()).append(";")
                        .append(c.orderCalc()).append(";").append(payment).append(";").append(c.balance()).append("\n");
                        outAccount.print(content.toString().trim());
                        outAccount.close();
                    }
                    catch(FileNotFoundException fe){
                        System.out.println(fe.getMessage());
                        fe.printStackTrace();
                    }
                    catch(IOException iox){
                        System.out.println(iox.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Problem: " + e.getMessage());
                    }
                }
                System.out.print("\nDo you want to add more order?(Y/N): "); // order more food; if yes loop, no calculate
                                                                                // price
                orderMore = scan1.next().charAt(0);
                orderMore = Character.toUpperCase(orderMore);
            }
    
            int system = 0;
            while (system != 3) {// Last menu:
                System.out.println("\n=============================================");
                System.out.print("1. Check the receipt for customer(View once). ");
                System.out.print("\n2. Check your membership account. ");
                System.out.print("\n3. Exit");
                System.out.println("\n=============================================");
    
                System.out.print("\nEnter your choice: ");
                system = scan.nextInt();
    
                if (system == 1) {// print receipt:
                    System.out.print("\033\143");// clear the output
                    while (!cList.isEmpty()) {
                        Customer c2 = (Customer) cList.dequeue();
                        System.out.println(c2);
                        System.out.println("MEMBERSHIP DISCOUNT: " + c2.getMembershipDiscount());
                        System.out.printf("TOTAL PRICE(with disc/without disc): RM %,.2f\n", c2.getTotalPrice());
                        System.out.println("\n\t  " + formattedDate);
                        System.out.println("\n      Thank you for using our service.");
                        System.out.println("\n==============================================");
                    }
                } else if (system == 2) {// check membership account exist / not:
                    boolean found = true;
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("account.txt"));
                        String Data = null;
                        System.out.print("\nEnter your email from membership account: ");
                        email = scan1.next();
    
                        while ((Data = br.readLine()) != null && found) {
                            String[] token = Data.split(";");
                            if (token[1].equals(email)) {
                                System.out.println("==================================================");
                                System.out.println("\nYou have membership account!");
                                System.out.println("\nYour membership account:");
                                System.out.println("Membership Name: " + token[0]);
                                System.out.println("Email: " + token[1]);
                                System.out.println("Membership code: " + token[2]);
                                System.out.println("\nHave a nice day!");
                                System.out.println("==================================================");
                                found = false;
                            }
                        }
                        if (found) {
                            System.out.println("\nSorry, you didn't have membership account.");
                        }
                        br.close();
                    } catch (FileNotFoundException fe) {
                        System.out.println(fe.getMessage());
                        fe.printStackTrace();
                    } catch (IOException iox) {
                        System.out.println(iox.getMessage());
                    } catch (Exception e) {
                        System.out.println("Problem: " + e.getMessage());
                    }
                } else if (system == 3) {// exit:
                    System.out.print("\033\143");// clear the output
                    System.out.print("\nDo you want to return to main menu?(Y/N): "); // yes to return to main menu, no to exit
                    char start = scan1.next().charAt(0);
                    start = Character.toUpperCase(start);
                    if (start == 'Y')
                        start = 'Y';
                    if (start == 'N'){
                        System.out.println("\n==================================================");
                        System.out.println("       Thank you for using our program.");
                        System.out.println("          Developed by WARCOF Sdn Bhd          ");
                        System.out.println("==================================================");
                        break;
                    }
                    
                } else
                    System.out.println("Invalid input");
            }
        scan.close();
        scan1.close();
    }
}