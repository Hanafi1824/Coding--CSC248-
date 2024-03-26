import java.util.*;
public class MainApp {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        //Step 1: Declare array of object
        System.out.print("Enter size of array: ");
        int size = scan.nextInt();
        WesternFood[] wf = new WesternFood[size];

        //Step 2: Create / Instantiate array of object:
        for (int i = 0; i < size; i++){
            wf[i] = new WesternFood();
        }
        //Step 3: Input:
        for (int i = 0; i < size; i++){
            System.out.print("\nEnter Name: ");
            String n = scan1.nextLine();
            System.out.print("Enter Quantity Order: ");
            int q = scan.nextInt();
            System.out.print("Enter Member (true / false): ");
            boolean m = scan.nextBoolean();
            System.out.print("Enter food set: ");
            int f = scan.nextInt();
            System.out.print("Enter Desert (true / false): ");
            boolean d = scan.nextBoolean();
            
            //Step 4: store into array:
            wf[i] = new WesternFood(n, q, m, f, d);
        }    
        
        //Step 5: Manipulation:
        for (int i = 0; i < size; i++){
            System.out.println(wf[i].toString() + "\nPayment: RM " + wf[i].Payment());
            
        }
        int cntDesert = 0;
        for (int i = 0; i < size; i++){
            if (wf[i].getDesert() == true){
                cntDesert++;
            }
        }
        System.out.println("The number of customers order desert: " + cntDesert);

        double totAll = 0;
        for(int i = 0; i < size; i++){
            totAll += wf[i].Payment();
        }
        System.out.println("Total Payment for all customers: " + totAll);

        for (int i = 0; i < size; i++){
            if (wf[i].getFoodSet() == 1){
                System.out.println(wf[i].toString());
                System.out.println(wf[i].Payment());
            }
        }
        scan.close();
        scan1.close();
    }
}