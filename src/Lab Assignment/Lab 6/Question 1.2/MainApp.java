import java.util.*;
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        //Step 1: Create an empty queue
        //i.
        QUEUE qCustomer = new QUEUE();

        //Step 2: Input 
        System.out.print("Enter the number of queue: ");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++){
            System.out.print("Enter customer name: ");
            String n = sc2.nextLine();
            System.out.print("Enter Account Number: ");
            int a = sc.nextInt();
            System.out.print("Enter Saving: RM");
            double s = sc.nextDouble();
            System.out.print("Enter total transaction: ");
            double t = sc.nextDouble();

            //Step 3: Store into object
            Customer c = new Customer(n, a, s, t);
            //Step 4: Add to Queue
            qCustomer.enqueue(c);
        }

        //Step 5: manipulation
        //ii.
        QUEUE qQualify = new QUEUE();

        while (!qCustomer.isEmpty()){
            Customer c = (Customer) qCustomer.dequeue();

            if(c.process()){
                qQualify.enqueue(c);
            }
        }

        while (!qQualify.isEmpty()){
            Customer c = (Customer) qQualify.dequeue();
            System.out.println("\n" + c.toString() + "\nStatus: " + c.process());
        }
        
    }
}
