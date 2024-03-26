import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTCrimeComplaint complaint = new BSTCrimeComplaint();

        char option = 'y';
        while (option == 'y'){
            // CCrimeComplaint c = new CCrimeComplaint();
            System.out.print("Enter Complaint Element: ");
            String ce = sc.nextLine();
            System.out.print("Enter Year: ");
            int y = sc.nextInt();
            System.out.print("Enter Total Number of Complaint: ");
            int tn = sc.nextInt();
            sc.nextLine();

            CCrimeComplaint c = new CCrimeComplaint(ce, y, tn);
            complaint.insertNode(c);

            System.out.print("Do you want to enter another complaint? (y/n): ");
            option = sc.nextLine().charAt(0);
        }

        //ii)
        complaint.cElementDisplayAll();

        //iii)
        System.out.print("Enter Complaint Element to search: ");
        String search = sc.nextLine();
        complaint.displayBySpesific(search);

        //iv
        System.out.println("Total Number of Complaints in 2019: " + complaint.calTotComplaint(2019));
        System.out.println("Total Number of Complaints in 2020: " + complaint.calTotComplaint(2020));

        sc.close();
    }
}
