import java.util.Scanner;

public class LandApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in); //pisahkan data type ikut scan masing-masing
        //Step 1: Create / Instantiate an object
        Land l = new Land();

        //Step 2: Input
        System.out.print("Enter Land ID: ");
        String id = scan.nextLine();
        System.out.print("Enter Land Owner Name: ");
        String ownerName = scan.nextLine();
        System.out.print("Enter Land House Type: ");
        char houseType = scan.next().charAt(0);
        houseType = Character.toUpperCase(houseType);
        System.out.print("Enter Land Area: ");
        int area = scan1.nextInt();

        //Step 3: Store onto object
        //1-Normal Constructor
        l = new Land(id, ownerName, houseType, area);

        if (houseType == 'T'){
            l.setDescription("Terrace");
        }
        else if (houseType =='S'){
            l.setDescription("Semi-detached");
        }
        else if (houseType == 'B'){
            l.setDescription("Bungalow");
        }
        else if (houseType == 'C'){
            l.setDescription("Condominium");
        }
        else{
            l.setDescription("Unknown");
        }

        //Step 4: Manipulate
        System.out.println(l);
        scan.close();
        scan1.close();
    }
}