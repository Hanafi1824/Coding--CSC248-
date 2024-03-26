import java.util.*;
import java.text.*;
public class CupcakeApp {
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);
        Scanner scan1 = new Scanner (System.in);

		DecimalFormat df = new DecimalFormat("###,###.00");

        //Declare array of object
        System.out.print("Enter the size of array: ");
        int size = scan1.nextInt();
        System.out.println("");
        Cupcake[] ccake = new Cupcake[size];
        
        for (int i = 0; i < size; i++){ //Create array of object
            ccake[i] = new Cupcake();
        }

        for (int i = 0; i < size; i++){ //Input data
            System.out.print("Enter cupcake name: ");
            String nme = scan.nextLine();
            System.out.print("Enter the code: ");
            String cd = scan.nextLine();
            System.out.print("Enter the price: RM ");
            double pr = scan1.nextDouble();
            System.out.println("");

            //Store into object
            ccake[i] = new Cupcake(nme,cd,pr);
        }

        for (int i = 0; i < size; i++){
            System.out.println(ccake[i].toString() + "\nNet price of cupcakes: RM " + df.format(ccake[i].priceInDozen()));
        }
        
        double totalPrice = 0;
        for (int i = 0; i < size; i++){
            totalPrice += ccake[i].priceInDozen();
        }
        System.out.println("\n\nTotal price: RM " + df.format(totalPrice));
        scan.close();
        scan1.close();
    }
}