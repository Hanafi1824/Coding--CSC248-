import java.util.*;
import java.io.*;
import java.time.LocalDateTime; // import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class MainApp {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);//int, double
        Scanner scan1 = new Scanner(System.in);//string, char

        LocalDateTime myDateObj = LocalDateTime.now();//print the current date
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        int drink;
        int day = 0;
        int quantity = 0;
        double discountRate = 0;
        double membershipDiscount = 0;
        double originalPrice = 0;
        double totalPrice = 0;

        char temperature = '\u0000'; 
        char size = '\u0000';
        int flavour = 0;
        String customerName = "";
        char addOn = '\u0000';

        String membershipName = "";
        String email = "";
        String membershipCode = "";

        int count = 0;
        int system = 0;
        char conditionMembership;
        double specialDiscount = 0;     

        System.out.println("\t==================================================");
        System.out.println("\t          Welcome to AYAQ CAFE website          ");
        System.out.println("\t==================================================");
        System.out.println("\n<Insert more than one customer if you want to order more than one drinks>");
        System.out.print("\nEnter the number of customer: ");
        count = scan.nextInt();
        Payment[] pay = new Payment[count];

        System.out.print("\033\143");//clear the output

        for(int i = 0; i < count; i++){
            System.out.println("\n\t==================================================");
            System.out.println("\t                    O R D E R                      ");
            System.out.println("\t==================================================");
            System.out.println("\nCustomer " + (i + 1) + ": ");

            System.out.println("\n<Insert different name for different drinks if you enter more than one customer>");
            System.out.print("\nEnter your name: ");
            customerName = scan1.next();

            System.out.print("\nDrinks: [1] Coffee / [2] Ice Blended");
            System.out.print("\nEnter your drink: ");
            drink = scan.nextInt();

            switch(drink){
                case 1://Coffee order:
                System.out.print("\033\143");//clear the output   
                //Coffee menu:
        System.out.println("\n===================================================");
        System.out.println("                 AYAQ CAFE MENU                ");
        System.out.println("===================================================");
        System.out.println("\n(1)COFFEE: ");
        System.out.println("\n====================================================");
        System.out.print("|Drinks:                 |    Hot:    |    Cold:   |");
        System.out.print("\n====================================================");
        System.out.print("\n|(1)Espresso             |  RM 5.00   |      -     |");
        System.out.print("\n|(2)Americano            |  RM 6.00   |  RM 7.00   |");
        System.out.print("\n|(3)Latte                |  RM 8.00   |  RM 9.00   |");
        System.out.print("\n|(4)Cappuccino           |  RM 8.00   |  RM 9.00   |");
        System.out.print("\n|(5)Mocha                |  RM 11.00  |  RM 12.00  |");
        System.out.print("\n|(6)Caramel Macchiato    |  RM 11.00  |  RM 12.00  |");
        System.out.println("\n====================================================");
                    System.out.print("\n\nEnter the flavor(1-6): ");
                    flavour = scan.nextInt();
                    ///// for printing the receipt:

                    System.out.print("\nTemperature: [H] Hot / [C] Cold");
                    System.out.print("\nEnter the type of drink: ");
                    temperature = scan1.next().charAt(0);
                    temperature = Character.toUpperCase(temperature);

                    if (temperature == 'H'){// Hot drinks must regular size.
                        size = 'R';
                        System.out.print("\nAdd-on extrashot will add RM 1.50");
                        System.out.print("\nDo you want to add extrashot for coffee? (Y / N): ");
                        char addOnChoice = scan1.next().charAt(0);
                        addOnChoice = Character.toUpperCase(addOnChoice);

                        if (addOnChoice == 'Y');{
                            addOn = 'E';
                            double addOnPrice = 1.5;
                        } 
                        if (addOnChoice == 'N'){
                            addOn = 'N';
                        }
                    }

                    else if (temperature == 'C'){//Cold drinks:
                        System.out.print("\nSize cup: [R] Regular / [L]  Large ");
                        System.out.print("\nEnter your size of cup: ");
                        size = scan1.next().charAt(0);
                        size = Character.toUpperCase(size);
          
                        System.out.print("\nAdd-on extrashot will add RM 1.50");
                        System.out.print("\nDo you want to add extrashot for coffee? (Y / N): ");
                        char addOnChoice = scan1.next().charAt(0);
                        addOnChoice = Character.toUpperCase(addOnChoice);

                        if (addOnChoice == 'Y');{
                            addOn = 'E';
                            double addOnPrice = 1.5;
                        }
                        if (addOnChoice == 'N'){
                            addOn = 'N';
                            double addOnPrice = 1.5;
                        }
                    }
                break;

                case 2://Ice Blended menu:
                    System.out.print("\033\143");//clear the output  

        System.out.println("\n==================================================");
        System.out.println("                AYAQ CAFE MENU                ");
        System.out.println("==================================================");
        System.out.println("\n(2)Blended: ");
        System.out.println("\n========================================");
        System.out.print("|Drinks:                 |   Price:   |");
        System.out.print("\n========================================");
        System.out.print("\n|(1)Strawberry           |  RM 8.00   |");
        System.out.print("\n|(2)Chocolate            |  RM 8.00   |");
        System.out.print("\n|(3)Vanilla              |  RM 8.00   |");
        System.out.print("\n|(4)Oreo                 |  RM 8.00   |");
        System.out.print("\n|(5)Green Tea            |  RM 8.50   |");
        System.out.print("\n========================================");
                    System.out.print("\n\nEnter the flavor(1-5): ");
                    flavour = scan.nextInt();
                    temperature = 'C';

                    System.out.print("\nSize cup: [R] Regular / [L]  Large ");
                    System.out.print("\nEnter your size of cup: ");
                    size = scan1.next().charAt(0);
                    size = Character.toUpperCase(size);

                    System.out.print("\nAdd-on syrup will add RM 1.50");
                    System.out.print("\nDo you want to add syrup? (Y / N): ");
                    char addOnChoice = scan1.next().charAt(0);
                    addOnChoice = Character.toUpperCase(addOnChoice);

                    if (addOnChoice == 'Y' || addOnChoice == 'y');{
                        addOn = 'S';
                        double addOnPrice = 1.5;
                    }
                    if (addOnChoice == 'N' || addOnChoice == 'n');{
                        addOn = 'N';
                        double addOnPrice = 0;
                    }
                break;

                default:
                    System.out.println("Invalid input.");
                break;
            }

            System.out.print("\nEnter the quantity for your drinks: ");//Quantity
            quantity = scan.nextInt();

            System.out.print("\n[1]Monday    [2]Tuesday [3]Wednesday");
            System.out.println("\n[4]Thursday  [5]Friday  [6]Saturday  [7]Sunday");

            System.out.print("\nEnter your day: ");//Day
            day = scan.nextInt();

            if (day == 3)
                System.out.println("\nYou got 5% discount off for today!!");

            System.out.println("\n<<Membership account gives you 5% off! Create new account if you don't have one. Get 5% discount today!>>");
            System.out.print("\nDo you have a membership? (Y / N): ");//Membership:
            conditionMembership = scan1.next().charAt(0);
            conditionMembership = Character.toUpperCase(conditionMembership);

            if (conditionMembership == 'Y'){//Check membership account:
                System.out.print("\033\143");//clear the output
                boolean found = true;
                try{
                    BufferedReader br = new BufferedReader(new FileReader("account.txt"));
                    String Data = null;
                    int x = 0;
                    scan1.nextLine();

                    Membership[] account = new Membership[1000];

                    System.out.print("\nEnter the membership code: ");
                    String findMembershipCode = scan1.nextLine(); 

                    while((Data = br.readLine()) != null && found){
                        // System.out.println("" + Data);
                        String[] token = Data.split(";");
                        if (token[2].equals(findMembershipCode)){
                            System.out.println("==================================================");
                            System.out.println("\nYour membership code: " + token[2] 
                            + "\nYou have membership account! You will get 5% discount.");
                            System.out.println("==================================================");
                            found = false;
                            membershipDiscount = 0.95; 
                        }
                    }
                    if (found){
                        System.out.println("==================================================");
                        System.out.println("\nSorry, you didn't have membership account.");
                        System.out.println("==================================================");
                    }
                    br.close();
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

            else if (conditionMembership == 'N'){
                System.out.print("\033\143");//clear the output
                System.out.print("\nDo you want to create account for membership? (Y / N): ");
                char choiceMembership = scan1.next().charAt(0);
                if (choiceMembership == 'Y' || choiceMembership == 'y'){//Create new account and save data:
                    try{
                        PrintWriter outAccount = new PrintWriter(new BufferedWriter(new FileWriter("account.txt",true)));
                        Membership[] account = new Membership[1000];
                        scan1.nextLine();
                        int x = 0;

                        System.out.println("==================================================");
                        System.out.println("CREATE MEMBERSHIP ACCOUNT:");
                        System.out.print("\nEnter your name: ");
                        membershipName = scan1.nextLine();
                        System.out.print("Create your email: ");
                        email = scan1.nextLine();
                        System.out.print("Create your membership code: ");
                        membershipCode = scan1.nextLine();
                        outAccount.println(membershipName + ";" + email + ";" + membershipCode);
                        account[x] = new Membership(membershipName, email, membershipCode);
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
            }
            pay[i] = new Payment(customerName, drink, flavour, temperature, size, addOn, 
            day, quantity, membershipName, email, membershipCode);

            discountRate = membershipDiscount;//calculation:
            if (discountRate == 0)
                totalPrice += pay[i].orderCalc();
            else
                totalPrice += pay[i].orderCalc() * discountRate;
                
        }

        while (system != 3){//Last menu: 
            System.out.println("\n===================================");
            System.out.print("1. Check the receipt for customer. ");
            System.out.print("\n2. Check your membership account. ");
            System.out.print("\n3. Exit");
            System.out.println("\n===================================");

            System.out.print("\nEnter your choice: ");
            system = scan.nextInt();

            if (system == 1){// print receipt:
                System.out.print("\033\143");//clear the output
                boolean found = false;
                System.out.print("\nEnter your name : ");
                String findName = scan1.next();
                
                for (int i = 0; i < count; i++){    
                    if (findName.equals(pay[i].getCustomerName())){
                        found = true;
                        System.out.println(pay[i].toString());
                        System.out.println("MEMBERSHIP DISCOUNT: " + discountRate);
                        System.out.printf("TOTAL PAYMENT FOR ALL ORDER: RM %,.2f\n", totalPrice);
                        System.out.println("\n\t" + formattedDate);
                        System.out.println("\n    Thank you for using our service.");
                        System.out.println("\n=========================================="); 
                    }
                }
                if (!found){
                    System.out.println("\nSorry, the record does not exist.");
                }
            }
            else if (system == 2){//check membership account exist / not:
                // System.out.print("\033\143");//clear the output
                boolean found = true;
                                
                try{
                    BufferedReader br = new BufferedReader(new FileReader("account.txt"));
                    String Data = null;
                    int x = 0;

                    Membership[] account = new Membership[1000];
                    
                    System.out.print("\nEnter your email from membership account: ");
                    email = scan1.next();

                    while((Data = br.readLine()) != null && found){
                        String[] token = Data.split(";");
                        if (token[1].equals(email)){
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
                    if (found){
                        System.out.println("\nSorry, you didn't have membership account.");
                    }
                    br.close();
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
            else if (system == 3){// exit:
                System.out.print("\033\143");//clear the output
                System.out.println();
                System.out.println("\n==================================================");
                System.out.println("       Thank you for using our program.");
                System.out.println("        Developed by AYAQ CAFE Sdn Bhd          ");
                System.out.println("==================================================");
            }
            else
                System.out.println("Invalid input");
        }
    }
}