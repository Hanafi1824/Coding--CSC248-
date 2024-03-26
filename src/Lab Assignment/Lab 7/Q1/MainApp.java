import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //string, char
        Scanner sc2 = new Scanner(System.in); //int
        bookRecord record = new bookRecord(); // empty list

        //a
        for (int i = 0; i < 8; i++){
            System.out.print("Serial Number: ");
            int sn = sc2.nextInt();
            System.out.print("Title: ");
            String t = sc.nextLine();
            sc.nextLine();
            System.out.print("Author: ");
            String a = sc.next();
            sc.nextLine();
            System.out.print("Code: ");
            char c = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Publisher: ");
            String p = sc.next();
            System.out.print("Year: ");
            int y = sc2.nextInt();

            Book b = new Book(); // stored in object
            b.setData(sn, t, a, c, p, y); //using setter
            record.insertBook(b); // stored in BST
        }

        //b
        record.countBookCode();

        //c
        System.out.print("Enter Serial Number of Book to find: ");
        int serNum = sc.nextInt();
        record.searchBook(serNum);

        //d
        System.out.println("Display all record in BST list: ");
        record.displayAll();
        sc.close();
        sc2.close();
    }
}
