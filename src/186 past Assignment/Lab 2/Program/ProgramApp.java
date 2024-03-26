import java.util.Scanner;

public class ProgramApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in); //pisahkan data type ikut scan masing-masing
        //Step 1: Create / Instantiate an object
        Program p = new Program();

        //Step 2: Input
        System.out.print("Enter Program Code: ");
        String cd = scan.nextLine();
        System.out.print("Enter Program Description: ");
        String pd = scan.nextLine();
        System.out.print("Enter Program Duration: ");
        int dr = scan1.nextInt();
        System.out.print("Enter Faculty: ");
        String fct = scan.nextLine();
        System.out.print("Enter Program Head: ");
        String ph = scan.nextLine();

        //Step 3: Store onto object
        //1-Normal Constructor
        p = new Program(cd,pd,dr,fct,ph);

        //OR
        //2-Mutator
        p.setCode(cd);
        p.setProgDes(pd);
        p.setDuration(dr);
        p.setFaculty(fct);
        p.setProgramHead(ph);

        //Step 4: Manipulate
        System.out.println(p.toString() + "\nProgram Level: " + p.detLevel());
    }
}