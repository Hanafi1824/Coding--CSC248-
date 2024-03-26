import java.util.*;

public class MainApp {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        String ID;
        String name;
        int age;
        char gender;
        int type;
        String code;

        onlineClass[] online = new onlineClass[100];

        for (int i = 0; i < online.length; i++){
            online[i] = new onlineClass();
        }

        for (int i = 0; i < online.length; i++){
            System.out.print("Enter Student ID: ");
            ID = scan.nextLine();
            System.out.print("Enter Student Name: ");
            name = scan.nextLine();
            System.out.print("Enter Student Age: ");
            age = scan1.nextInt();
            System.out.print("Enter Student Gender (M / F): ");
            gender = scan.next().charAt(0);
            System.out.println("\n1 - Undergraduate, 2 - Postgraduate");
            System.out.print("Student Type: ");
            type = scan1.nextInt();
            scan.nextLine();
            System.out.print("Enter the program code(COMP / ENG): ");
            code = scan.nextLine();
            System.out.println();

            online[i] = new onlineClass(ID, name, age, gender, type, code);
        }

        System.out.println("\nAll the information: ");
        for (int i = 0; i < online.length; i++){
            if (online[i].getStudentID().equalsIgnoreCase("2017111222")){ // update ENG to COMP
                online[i].setProgramCode("COMP");
            }
        }

        for (int i = 0; i < online.length; i++){
            System.out.println(online[i].toString());
        }

        for (int i = 0; i < online.length; i++){
            if (online[i].getStudentType() == 1){
                System.out.println("\nTotal fee collected from undergraduated students: RM " + online[i].calculateFee()); 
            }
        }

        for (int i = 0; i < online.length; i++){
            if (online[i].getStudentName().equalsIgnoreCase("Alexander")){
                System.out.println("\nProgram code enrolled by Alexander: " + online[i].getProgramCode());
            }
        }
        scan.close();
        scan1.close();
    }
}