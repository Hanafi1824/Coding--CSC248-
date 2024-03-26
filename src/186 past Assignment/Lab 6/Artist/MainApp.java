import java.util.*;

public class MainApp {
    public static void main (String[] args){
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        String ap = "";
        String an = ""; 
        String g;
        double p = 0;
        int w, n;

        //Step 1: Declare array of object
        Artist[] a = new Artist[50];

        //Step 2: Create / Instantiate array of object:
        for (int i = 0; i < 50; i++){
            a[i] = new Artist();
        }
        //Step 3: Input:
        for (int i = 0; i < 3; i++){
            System.out.print("\nEnter the Artist Profession: ");
            ap = strScan.nextLine();
            System.out.print("\nEnter the Artist name: ");
            an = strScan.nextLine();
            System.out.print("Enter the payment: RM ");
            p = intScan.nextDouble();

            if (ap.equalsIgnoreCase("Performer")){
                System.out.print("Enter the working hours: ");
                w = intScan.nextInt();
                System.out.print("Enter the genre: ");
                g = strScan.nextLine();

                a[i] = new Performer(ap, an, p, w, g);
            }
            
            else if(ap.equalsIgnoreCase("Painter")){
                System.out.print("Enter the number of painting: ");
                n = intScan.nextInt();
                a[i] = new Painter(ap, an, p, n);
            }
        }    
        
        //Step 5: Manipulation:
        System.out.println("\nAll the information: ");
        for (int i = 0; i < 3; i++){
            if (a[i] instanceof Performer){
                Performer pe = (Performer) a[i];
                if (pe.getGenre().equalsIgnoreCase("Rock") && pe.payArtist() >= 10000){
                    System.out.println(a[i].toString());
                }
            }
        }

        for (int i = 0; i < 3; i++){
            if (a[i] instanceof Painter){
                Painter pa = (Painter) a[i];
                if (pa.getNumOfPainting() >= 10){
                    System.out.println(a[i].toString()); 
                }
            }
        }
        intScan.close();
        strScan.close();
    }
}