import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Queue qHouse = new Queue();
        Queue qSemi_D = new Queue();
        Queue qTerrace = new Queue();

        Queue temporary = new Queue();

        House h;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter type (Semi-D/Terrace): ");
            String t = scan.nextLine();
            System.out.print("Enter location: ");
            String l = scan.nextLine();
            System.out.print("Enter size: ");
            double s = scan.nextDouble();
            System.out.print("Enter price: ");
            double p = scan.nextDouble();
            scan.nextLine();

            h = new House(t, l, s, p);
            qHouse.enqueue(h);

            // insert into respective queue
            if (h.getType().equalsIgnoreCase("Semi-D")) {
                qSemi_D.enqueue(h);
            }

            else if (h.getType().equalsIgnoreCase("Terrace")) {
                qTerrace.enqueue(h);
            }

            if (h.getPrice() < 150000) {
                // System.out.println("\n" + qTerrace.toString());
                System.out.println("List of houses with price less than RM 150,000: ");
                System.out.println(h.toString());
            }
        }

        int count = 0;
        boolean check = false;
        while (!qHouse.isEmpty()) {
            h = (House) qHouse.dequeue();
            temporary.enqueue(h);
            if (h.getPrice() > 300000) {
                count++;
                check = true;
            }
        }

        while (!temporary.isEmpty()) {
            qHouse.enqueue(temporary.dequeue());
        }

        if (check) {
            System.out.println("Number of houses with price more than RM 300,000: " + count);
            // System.out.print("" + qHouse.toString());
            System.out.println("List of houses with price more than RM 300,000: ");
            for (int i = 0; i < count; i++) {
                System.out.println(qHouse.dequeue());
            }
        } else {
            System.out.println("No houses with price more than RM 300,000");
        }
    }
}