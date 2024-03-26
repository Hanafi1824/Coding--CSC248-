import java.util.*;

public class MainApp {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        System.out.print("Enter the number of order: ");
        int numOrder = scan.nextInt();
        
        DesignService[] ds = new DesignService[numOrder];
        
        int countUrgentOrder = 0;
        for (int i = 0; i < numOrder; i++){
            scan.nextLine();
            System.out.print("\nEnter the customer name: ");
            String name = scan.nextLine();
            System.out.print("Enter the deposit: RM ");
            double deposit = scan1.nextDouble();
            System.out.print("Is this an urgent order? (true / false): ");
            boolean urgentOrder = scan1.nextBoolean();
            

            System.out.println("\n1 - Physical Design\n2 = Digital Design");
            System.out.print("Enter the design type: ");
            int designType = scan1.nextInt();

            if (designType == 1){
                System.out.println("\n1 - Banner\n2 - Brochure\n3 - Poster\n4 - Business Card");
                System.out.print("Enter the physical design type (1 / 2 / 3 /4): ");
                int physicalType = scan.nextInt();
                System.out.print("Do you want to print? (true / false): ");
                boolean printing = scan1.nextBoolean();
                int numCopy = 0;
                if (printing == true){
                    System.out.print("Enter the number of copy: ");
                    numCopy = scan.nextInt();
                }
                else{
                    printing = false;
                    numCopy = 0;
                }

                ds[i] = new PhysicalDesign(name, deposit, urgentOrder, physicalType, printing, numCopy);
            }

            else if (designType == 2){
                System.out.println("\n1 - Website\n2 - Advertisement");
                System.out.print("Enter the digital design type (1 / 2): ");
                int digitalType = scan.nextInt();
                
                if (urgentOrder == true && designType == 1)
                    countUrgentOrder++;

                ds[i] = new DigitalDesign(name, deposit, urgentOrder, digitalType);
            }
        }

        System.out.println("\nAll the ordered information: ");
        for (int i = 0; i < numOrder; i++){
            if (ds[i] instanceof PhysicalDesign){
                PhysicalDesign pd = (PhysicalDesign) ds[i];
                System.out.println(ds[i].toString());
                System.out.println("Total Payment for Physical Design: RM " + ds[i].calcPayment());
            }
        }
        for (int i = 0; i < numOrder; i++){
            if (ds[i] instanceof DigitalDesign){
                DigitalDesign dd = (DigitalDesign) ds[i];
                if (ds[i].getUrgentOrder() == true && dd.getDigitalType() == 1){
                    System.out.println("\nTotal number of urgent order for web design: " + countUrgentOrder);
                }
            }
        }
        scan.close();
        scan1.close();
    }
}
