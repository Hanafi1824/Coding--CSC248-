import java.util.*;
public class ZZZCompany {
    public static void main(String[] args) {
        Scanner company = new Scanner(System.in);
        String name, workerID;
        char choice;
        double shift, distance, workShift, allowance = 0, mileage = 0, income = 0, total = 0;
        int totalEmployees = 0;

        System.out.print("Start program(Y/N): ");
        choice = company.next().charAt(0);
        choice = Character.toUpperCase(choice);

        while (choice == 'Y') {
            totalEmployees++;
            System.out.print("Enter your name: ");
            name = company.nextLine();

            System.out.print("Enter your worker number: ");
            workerID = company.next();
            System.out.println("");

            System.out.println("Category A / Category B / Category C");
            System.out.print("Enter your job category: ");
            char category = company.next().charAt(0);
            category = Character.toUpperCase(category);

            if (category == 'A') {
                System.out.print("Enter your days of outstation: ");
                shift = company.nextDouble();
                workShift = shift * 200;
                allowance = workShift + 60;
            } else if (category == 'B') {
                System.out.print("Enter your days of outstation: ");
                shift = company.nextDouble();
                workShift = shift * 120;
                allowance = workShift + 45;
            } else if (category == 'C') {
                System.out.print("Enter your days of outstation: ");
                shift = company.nextDouble();
                workShift = shift * 85;
                allowance = workShift + 25;
            } else {
                System.out.println("Invalid input");
            }

            System.out.print("Enter your distance to work: ");
            distance = company.nextDouble();

            if (distance <= 500) {
                mileage = distance * 0.55;
            } else if (distance >= 501 && distance <= 1000) {
                mileage = distance * 0.45;
            } else if (distance >= 1000) {
                mileage = distance * 0.35;
            }

            income = allowance + mileage;
            System.out.println("Your income is RM " + income);
            System.out.print("Do you want to continue? (Y/N): ");
            choice = company.next().charAt(0);
            choice = Character.toUpperCase(choice);
            total += income;
        }
        System.out.println();
        System.out.println("The number of employees: " + totalEmployees);
        System.out.println("Total of the employees claims: RM " + total);
        company.close();
    }
}