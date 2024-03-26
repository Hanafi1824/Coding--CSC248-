import java.util.*;

public class MainApp {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);//string
        Scanner scan1 = new Scanner(System.in);

        RoomActivity[] activity = new RoomActivity[50];

        //Step 2: Create / Instantiate array of object:
        for (int i = 0; i < 2; i++){
            activity[i] = new RoomActivity();
        }
        //Step 3: Input:
        for (int i = 0; i < 2; i++){
            System.out.print("\nEnter Activity Name: ");
            String activityName = scan.nextLine();
            System.out.println("\nG - Government\nP - Private\nU - University");
            System.out.print("Enter type Organiser: ");
            char organiser = scan1.next().charAt(0);
            System.out.print("Enter budget: RM ");
            double budget = scan.nextDouble();
            scan.nextLine();
            System.out.print("Enter date: ");
            String date = scan.nextLine();
            System.out.println("\nA - Auditorium\nM - Meeting Room\nL - Computer Lab\nS - Seminar Room");
            System.out.print("Enter Room Type(A / M / L / S): ");
            String roomType = scan.nextLine();
            System.out.print("Enter number of participant: ");
            int numOfParticipant = scan.nextInt();
            scan.nextLine();

            //Step 4: store into array:
            activity[i] = new RoomActivity(activityName, organiser, budget, date, roomType, numOfParticipant);
        }    
        
        //Step 5: Manipulation:
        System.out.println("\nAll booked activities: ");
        for (int i = 0; i < 2; i++){
            System.out.println(activity[i].toString());
            System.out.println("Total: RM " + activity[i].roomCharges());
        }
        
        for (int i = 0; i < 2; i++){
            if (activity[i].getOrganiser() == 'P'){
                System.out.println("\nAll Information of each booking made by Private Organiser: ");
                System.out.println(activity[i].toString());
                System.out.println("\nTotal: RM " + activity[i].roomCharges());
            }
        }

        for(int i = 0; i < 2; i++){
            if (activity[i].getRoomType().charAt(0) == 'L' && activity[i].getNumOfParticipant() > 30){
                System.out.println("\nAll Information of each booking for lab with more than 30 participant: ");
                System.out.println(activity[i].toString());
                System.out.println("\nTotal: RM " + activity[i].roomCharges());
            }
        }
        scan.close();
        scan1.close();
    }
}
