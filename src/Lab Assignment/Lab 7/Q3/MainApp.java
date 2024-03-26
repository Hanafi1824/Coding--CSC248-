import java.util.*;
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //string, char
        Scanner sc1 = new Scanner(System.in); //int
        BSTCandidate c = new BSTCandidate();

        char option = 'y';
        while(option == 'y' || option == 'Y'){
            System.out.print("Enter Registration Number: ");
            int r = sc1.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String n = sc.nextLine();
            System.out.print("Enter Qualification: ");
            char q = sc.next().charAt(0);
            System.out.print("Enter Age: ");
            int a = sc1.nextInt();
            System.out.print("Enter Gender: ");
            char g = sc.next().charAt(0);

            JobCandidate j = new JobCandidate(r, n, q, a, g);
            c.insertCandidate(j);
            System.out.println("\nDo you want to add more candidates? (y/n)");
            option = sc.next().charAt(0);
        }

        //ii)
        //a-
        System.out.println("\nINORDER traversal (ASCENDING): ");
        c.inorderTraversal();
        //b-
        System.out.println("\nPOSTORDER traversal: ");
        c.postorderTraversal();
        //c-
        System.out.println("\nNumber of leaf nodes: " + c.countLeafNodes());

        //iii)
        System.out.println("\nDetails of candidate's name in descending order:");
        c.displayDetails();

        //iv)
        System.out.println("Total Number of Candidate D: " + c.countCandidate('D'));
        System.out.println("Total Number of Candidate M: " + c.countCandidate('M'));
        System.out.println("Total Number of Candidate P: " + c.countCandidate('P'));
        System.out.println("Total Number of Candidate S: " + c.countCandidate('S'));
    }
}
