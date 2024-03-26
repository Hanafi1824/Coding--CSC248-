import java.util.*;

public class MainApp {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        //Step 1: Declare array of object
        SoHo[] buyer = new SoHo[320];

        //Step 2: Create / Instantiate array of object:
        for (int i = 0; i < 320; i++){
            buyer[i] = new SoHo();
        }

        //Step 3: Input:
        for (int i = 0; i < 2; i++){
            System.out.print("\nEnter your name: ");
            String name = scan.nextLine();
            System.out.print("Enter your IC: ");
            long ic = scan1.nextLong();
            System.out.print("Enter your gender(Female / Male): ");
            String gender = scan.nextLine();
            System.out.print("Bumiputera? (true / false): ");
            boolean bumiputera = scan1.nextBoolean();
            scan1.nextLine();

            System.out.print("Enter the unit price: RM ");
            double unitPrice = scan1.nextDouble();
            System.out.println("\nF : Fully Furnished\nP : Partially Furnished\nU : Unfurnished");
            System.out.print("\nEnter type of packages(F / P / U): ");
            char packages = scan1.next().charAt(0);
            
            // System.out.println("\nA: 1 room, B: 2 room, C: 3 room");
            // System.out.print("Enter Residential Suites type: ");
            // char residentialSuiteType = scan.next().charAt(0);

            buyer[i] = new SoHo(name, ic, gender, bumiputera, unitPrice, packages);
        }    
        int counting = 0;
        System.out.println("\nAll information: ");
        for (int i = 0; i < 2; i++){
            System.out.println(buyer[i].toString());
            if (buyer[i].getGender().equalsIgnoreCase("Female") && buyer[i].getPackages() == 'F') {
                counting++;
            }
        }
        System.out.println("\nTotal number of female buyers who bought fully furnished package: " + counting);
        scan.close();
        scan1.close();
    }
}