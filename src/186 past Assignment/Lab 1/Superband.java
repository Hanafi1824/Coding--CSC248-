import java.util.*;

public class Superband {
    static String name;
    static char type;    
    static int internet, totalCusA, totalCusB;
    static double basicCharge, extraCharge, charge;
    static int customer = 0;
    static String nameCustomer;
    int totalCustomer;
    static double total;

    static double calCharge(char type, int internet){
        if (type == 'A'){
            if (internet > 10000){
                extraCharge = (internet - 10000) * 0.05;
            }
            else {
                extraCharge = 0;
            }
            basicCharge = 88;
            charge = basicCharge + extraCharge;
            totalCusA += customer;
            System.out.print("Total to be paid by " + name + ": RM " + charge);
            System.out.println("");
        }
        else if (type == 'B'){
            if (internet > 6000){
                extraCharge = (internet - 6000) * 0.10;
            }
            else{
                extraCharge = 0;
            }
            basicCharge = 48;
            charge = basicCharge + extraCharge;
            totalCusB += customer;
            System.out.print("Total to be paid by " + name + ": RM " + charge);
            System.out.println("");
        }
        return charge;
    }

    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        
        System.out.println("******* Welcome to Malaysia SuperBand ********");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.print("Please enter the number of customer: ");
        customer = user.nextInt();
        System.out.println("");

        for (int i = 0; i <= customer; i++){
            System.out.println("Customer " + (i + 1));
            System.out.print("Enter your name: ");
            name = user.next();

            System.out.print("Enter Package type (A - advance, B - Basic): ");
            type = user.next().charAt(0);

            System.out.print("Enter Total Internet use: ");
            internet = user.nextInt();

            calCharge(type, internet);
            System.out.println("");
        }

        System.out.println("Total Charges: RM " + total);
        System.out.println("Number of customers for package A: " + totalCusA);
        System.out.println("Number of customers for package B: " + totalCusB);
        System.out.println("The customer with the highest charge is " + nameCustomer);
        user.close();
    }
}
        

        