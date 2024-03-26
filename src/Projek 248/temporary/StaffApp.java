import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StaffApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //string
        Scanner sc2 = new Scanner(System.in); //char
        List sList = new List (); //Staff List (Linked List implementation)

        boolean found = true; 
        while(found){ //loop until enter correct staff ID
            System.out.println("\nClick ENTER to start!");
            try{
                BufferedReader br = new BufferedReader(new FileReader("StaffData.txt"));
                String Data = null;
                sc.nextLine();
                System.out.print("Enter the staff ID: ");
                String findStaffID = sc.nextLine(); 
                while((Data = br.readLine()) != null && found){
                    String[] token = Data.split(";");
                    if (token[0].equals(findStaffID)){
                        System.out.println("==================================================");
                        System.out.println("Staff Details: ");
                        System.out.println("Staff ID: " + token[0]); //staff Id
                        System.out.println("Staff name: " + token[1]); //staff name
                        System.out.println("Contact No: " + token[2]); //contact no
                        System.out.println("Status: " + token[3]); //staff status
                        System.out.println("Position: " + token[4]); //position
                        System.out.println("Address: " + token[5]); //address
                        System.out.println("Salary: RM" + token[6]); //salary
                        System.out.println("==================================================");
                        found = false;
                    }
                }
                if (found){
                    System.out.println("==================================================");
                    System.out.println("Sorry, you didn' have staff record.");
                    System.out.println("==================================================");
                }
                br.close();
            }
            catch(FileNotFoundException fe){
                System.out.println(fe.getMessage());
                fe.printStackTrace();
            }
            catch(IOException iox){
                System.out.println(iox.getMessage());
            }
            catch(Exception e){
                System.out.println("Problem: " + e.getMessage());
            }      
        }

        while (!found) {
            Object record = null;
            System.out.println("---------------------------------------");
            System.out.println("1. Add new staff.");
            System.out.println("2. Delete current staff.");
            System.out.println("3. Search staff's info.");
            System.out.println("4. Update staff's info.");
            System.out.println("5. Count the number of data.");
            System.out.println("6. Manipulate customer data.");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------");
            System.out.print(">>Enter your choice: ");
            int choice = sc.nextInt();
            System.out.print("\033\143");//clear the output
            if (choice == 1){ // Enter record & add into nodes
                if(!sList.isEmpty()){ //clear the linked list first to avoid duplicate
                    while (!sList.isEmpty()){
                        sList.removeFromFront();
                    }
                }
                System.out.print("How many staff to recruit?: ");// insert more than one
                int size = sc.nextInt();
                String id = "", n = "", cn = "", a = "";
                char s = '\u0000' ,p = '\u0000';
                int sa = 0;
                for (int i = 0; i < size; i++){ 
                    System.out.println("\nRecord [" + (i+1) + "]");
                    System.out.print("Enter staff ID: ");
                    id = sc.next();
                    System.out.print("Enter staff name: ");
                    n = sc2.next();
                    System.out.print("Enter contact number: ");
                    cn = sc2.next();
                    System.out.println("\n[S] - Single || [M] - Married || [D] - Divorce");
                    System.out.print("Enter staff status: ");
                    s = sc2.next().charAt(0);
                    s = Character.toUpperCase(s);
                    System.out.println("\n[A] - Assistant || [B] - Barista || [C] - Cashier || [H] - Chef || " +
                    "\n[L] - Cleaner   || [M] - Manager || [W] - Waiter");
                    System.out.print("Enter staff position: ");
                    p = sc2.next().charAt(0);
                    p = Character.toUpperCase(p);
                    System.out.print("Enter staff state: ");
                    a = sc2.next();
                    System.out.print("Enter staff salary: RM ");
                    sa = sc.nextInt();

                    Staff s1 = new Staff(id, n, cn, s, p, a, sa); // object
                    record = s1;
                    
                    System.out.println("\nINSERTING DATA INTO THE RECORD: ");
                    System.out.println("1. Insert record at front");
                    System.out.println("2. Insert record at back");
                    System.out.println("3. Insert record at middle");
                    System.out.print(">>Enter the option: ");
                    int option = sc.nextInt();
                    if (option == 1){ //Insert data at front
                        sList.insertAtFront(record);
                        System.out.println();
                        sList.print();
                    }
                    else if (option == 2){ // Insert data at back
                        sList.insertAtBack(record);
                        System.out.println();
                        sList.print();
                    }
                    else if (option == 3){ //Insert at middle
                        sList.insertAtMiddle(record);
                        System.out.println();
                        sList.print();
                    }
                    else
                        System.out.println("Wrong input.");
                }
                String fileName = "StaffData.txt";
                sList.saveToFile(fileName); // store data from linked list to text file
            }
            else if (choice == 2 || choice == 3 || choice == 4 || choice == 5){
                if (sList.isEmpty()){ // store data from text file to linked list only when linked list is empty
                    String id = "", n = "", cn = "", a = "";
                    char s = '\u0000' ,p = '\u0000';
                    int sa = 0;
                    try{ //store data from text file to linked list
                        BufferedReader br = new BufferedReader(new FileReader("StaffData.txt"));
                        String Data = null;
                        sc.nextLine();

                        while((Data = br.readLine()) != null){
                            String[] token = Data.split(";");
                            id = token[0];
                            n = token[1];
                            cn = token[2];
                            s = token[3].charAt(0);
                            if (token[4].equals("Chef")) // avoiding unexpected error
                                p = 'H';
                            else if(token[4].equals("Cleaner"))
                                p = 'L';
                            else{
                                String ps = token[4];
                                p = ps.charAt(0);
                            }
                            a = token[5];
                            sa = Integer.parseInt(token[6]);
                            Staff s1 = new Staff(id, n, cn, s, p, a, sa);
                            record = s1;
                            sList.insertAtBack(record);
                        }
                        br.close();
                    }
                    catch(FileNotFoundException fe){
                        System.out.println(fe.getMessage());
                        fe.printStackTrace();
                    }
                    catch(IOException iox){
                        System.out.println(iox.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Problem: " + e.getMessage());
                    }
                }
                else if (!sList.isEmpty()){
                    while (!sList.isEmpty()){ //clear the list first to avoid losing any data
                        sList.removeFromFront();
                    }
                    String id = "", n = "", cn = "", a = "";
                    char s = '\u0000' ,p = '\u0000';
                    int sa = 0;
                    try{ //store data from text file to linked list
                        BufferedReader br = new BufferedReader(new FileReader("StaffData.txt"));
                        String Data = null;
                        sc.nextLine();

                        while((Data = br.readLine()) != null){
                            String[] token = Data.split(";");
                            id = token[0];
                            n = token[1];
                            cn = token[2];
                            s = token[3].charAt(0);
                            if (token[4].equals("Chef"))
                                p = 'H';
                            else if(token[4].equals("Cleaner"))
                                p = 'L';
                            else{
                                String ps = token[4];
                                p = ps.charAt(0);
                            }
                            a = token[5];
                            sa = Integer.parseInt(token[6]);
                            Staff s1 = new Staff(id, n, cn, s, p, a, sa);
                            record = s1;
                            sList.insertAtBack(record);
                        }
                        br.close();
                    }
                    catch(FileNotFoundException fe){
                        System.out.println(fe.getMessage());
                        fe.printStackTrace();
                    }
                    catch(IOException iox){
                        System.out.println(iox.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Problem: " + e.getMessage());
                    }
                }
                if (choice == 2 || choice == 4){ // read and manipulate text file 
                    if (choice == 2){ //Delete any data from record
                        char loop = 'Y';
                        while (loop == 'Y'){
                            sList.print2();
                            System.out.println("DELETING DATA FROM THE RECORD: ");
                                
                            System.out.print("Enter the staff ID to delete: ");
                            String staffIDToDelete = sc.next();
                            
                            Object deletedStaff = sList.remove(staffIDToDelete);
                            
                            if (deletedStaff != null){
                                System.out.println("\nRecord with staff ID " + staffIDToDelete + " deleted successfully.");
                                System.out.println("Deleted Staff Details:");
                                System.out.println(deletedStaff);
                                System.out.println();
                                sList.print2(); // Print the updated list
                            }
                            else{
                                System.out.println("Record not found with staff ID " + staffIDToDelete);
                            }

                            String fileName = "StaffData.txt";
                            sList.saveToFile2(fileName); // store data from linked list to text file
                            System.out.print("\nDo you want to continue deleting? Y/N : ");
                            loop = sc.next().charAt(0);
                            loop = Character.toUpperCase(loop);
                            System.out.print("\033\143");//clear the output
                        }
                    }
                    else if (choice == 4){ //Update the record
                        char loop = 'Y';
                        while (loop == 'Y'){
                            System.out.println("UPDATING DATA: ");
                            System.out.print("Enter the staff ID to update: ");
                            String staffIDToUpdate = sc.next();
                            Object searchedRecord = sList.searchStaff(staffIDToUpdate);
                            if (searchedRecord != null) {
                                System.out.println("\nBefore update the record:"); //before
                                System.out.println(searchedRecord);
                            }
                            System.out.println("\nUPDATING DATA FROM THE RECORD: ");
                            System.out.println("1. Update staff name");
                            System.out.println("2. Update staff contact number");
                            System.out.println("3. Update staff status");
                            System.out.println("4. Update staff position");
                            System.out.println("5. Update staff state");
                            System.out.println("6. Update staff salary");
                            System.out.print(">>Enter the option: ");
                            int option = sc.nextInt();
                            switch (option) {
                                case 1:
                                    System.out.print("Enter new staff name: ");
                                    String n = sc2.next();
                                    searchedRecord = sList.updateStaff(staffIDToUpdate, option, n);
                                    break;
                                case 2:
                                    System.out.print("Enter new contact number: ");
                                    String cn = sc2.next();
                                    searchedRecord = sList.updateStaff(staffIDToUpdate, option, cn);
                                    break;
                                case 3:
                                    System.out.println("\n[S] - Single || [M] - Married || [D] - Divorce");
                                    System.out.print(">>Enter new staff status: ");
                                    char s = sc2.next().charAt(0);
                                    s = Character.toUpperCase(s);
                                    searchedRecord = sList.updateStaff(staffIDToUpdate, option, s);
                                    break;
                                case 4:
                                    System.out.println("\n[A] - Assistant || [B] - Barista || [C] - Cashier || [H] - Chef || " +
                                    "\n[L] - Cleaner   || [M] - Manager || [W] - Waiter");
                                    System.out.print(">>Enter new staff position: ");
                                    char p = sc2.next().charAt(0);
                                    p = Character.toUpperCase(p);
                                    searchedRecord = sList.updateStaff(staffIDToUpdate, option, p);
                                    break;
                                case 5:
                                    System.out.print("Enter new staff address: ");
                                    String a = sc2.next();
                                    searchedRecord = sList.updateStaff(staffIDToUpdate, option, a);
                                    break;
                                case 6:
                                    System.out.print("Enter new staff salary: ");
                                    int ss = sc.nextInt();
                                    searchedRecord = sList.updateStaff(staffIDToUpdate, option, ss);
                                    break;
                                default:
                                    System.out.println("Wrong input.");
                            }
                            String fileName = "StaffData.txt";
                            sList.saveToFile2(fileName); // store data from linked list to text file
                            System.out.print("\nDo you want to continue updating? Y/N : ");
                            loop = sc.next().charAt(0);
                            loop = Character.toUpperCase(loop);
                            System.out.print("\033\143");//clear the output
                        }
                    }
                }
                else if (choice == 3 || choice == 5){ // read text file only
                    if (choice == 3){ //Search the record based on index
                        char loop = 'Y';
                        while (loop == 'Y'){
                            System.out.println("SEARCHING RECORD: ");
                            System.out.print("Enter the staff ID to search: ");
                            String staffIDToSearch = sc.next();
                            Object searchedRecord = sList.searchStaff(staffIDToSearch);
                            
                            System.out.println(searchedRecord); 
                            System.out.print("\nDo you want to continue searching? Y/N : ");
                            loop = sc.next().charAt(0);
                            loop = Character.toUpperCase(loop);
                            System.out.print("\033\143");//clear the output 
                        }
                    }
                    else if (choice == 5){ // Counting data according to condition of 
                        char loop = 'Y';
                        while (loop == 'Y'){
                            System.out.println("COUNTING DATA: ");
                            System.out.println("1. Count current staff");
                            System.out.println("2. Count staff position");
                            System.out.println("3. Count staff status");
                            System.out.print(">>Enter the option: ");
                            int option = sc.nextInt();
                            if (option == 1){ //current staff
                                System.out.println("Total current staff in the company: " + sList.countCurrentStaff());
                            }
                            else if (option == 2){ //staff position
                                System.out.println("\n[A] - Assistant || [B] - Barista || [C] - Cashier || [H] - Chef ||" +
                                "\n[L] - Cleaner   || [M] - Manager || [W] - Waiter");
                                System.out.print(">>Enter staff position: ");
                                char p = sc2.next().charAt(0);
                                p = Character.toUpperCase(p);
                                String word = "";
                                switch (p){
                                    case 'A':
                                        word = "Assistant";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    case 'H':
                                        word = "Chef";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    case 'C':
                                        word = "Cashier";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    case 'L':
                                        word = "Cleaner";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    case 'B':
                                        word = "Barista";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    case 'M':
                                        word = "Manager";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    case 'W':
                                        word = "Waiter";
                                        System.out.println("Total staff position related: " + sList.countStaffPosition(word));
                                        break;
                                    default:
                                        System.out.println("Wrong input.");
                                }
                            }
                            else if (option == 3){ //staff status
                                System.out.println("\n[S] - Single || [M] - Married || [D] - Divorce");
                                System.out.print(">>Enter staff status: ");
                                char s = sc2.next().charAt(0);
                                s = Character.toUpperCase(s);
                                switch (s){
                                    case 'S':
                                        System.out.println("Total staff status related: " + sList.countStaffStatus('S'));
                                        break;
                                    case 'M':
                                        System.out.println("Total staff status related: " + sList.countStaffStatus('M'));
                                        break;
                                    case 'D':
                                        System.out.println("Total staff status related: " + sList.countStaffStatus('D'));
                                        break;
                                    default:
                                        System.out.println("Wrong input.");
                                }
                            }
                            else
                                System.out.println("Wrong option!!"); 
                            System.out.print("\nDo you want to continue counting? Y/N : ");
                            loop = sc.next().charAt(0);
                            loop = Character.toUpperCase(loop);
                            System.out.print("\033\143");//clear the output 
                        }
                    }
                }
            }
            else if (choice == 6){ //manipulate customer data
                char loop = 'Y';
                while (loop == 'Y'){
                    System.out.println("MANIPULATE CUSTOMER DATA: ");
                    System.out.println("1. Check customer's ordered history");
                    System.out.println("2. Check customer's membership account");
                    System.out.print(">>Enter the option: ");
                    int option = sc.nextInt();
                    if (option == 1){ //customer's ordered history
                        System.out.print("\033\143");//clear the output
                        System.out.println("CUSTOMER'S ORDERED HISTORY:");
                        System.out.println("1. Check food ordered history");
                        System.out.println("2. Check drink ordered history");
                        System.out.print(">>Enter the option: ");
                        int history = sc.nextInt();
                        if (history == 1){
                            try{
                                BufferedReader br = new BufferedReader(new FileReader("foodOrderedHistory.txt"));
                                String Data = null;
                                System.out.println("Food ordered history:");
                                System.out.println("CLUE: (Quantity);(Type of food);(Type of order);(Add-on);(Add-on Price);(SubTotal);(Payment);(Balance)\n");
                                while((Data = br.readLine()) != null){
                                    String[] token = Data.split(";");
                                    System.out.println(token[0] + ";" + token[1] + ";" + token[2] + ";" + token[3] + ";" + token[4] 
                                    + ";" + token[5] + ";" + token[6] + ";" + token[7]);
                                }
                                br.close();
                            }
                            catch(FileNotFoundException fe){
                                System.out.println(fe.getMessage());
                                fe.printStackTrace();
                            }
                            catch(IOException iox){
                                System.out.println(iox.getMessage());
                            }
                            catch(Exception e){
                                System.out.println("Problem: " + e.getMessage());
                            }
                        }
                        else if (history == 2){
                            try{
                                BufferedReader br = new BufferedReader(new FileReader("drinkOrderedHistory.txt"));
                                String Data = null;
                                System.out.println("Drink ordered history:");
                                System.out.println("CLUE: (Quantity);(Type of drink);(Type of order);(Temperature);(Size;Add-on)" +
                                ";(Add-on Price);(SubTotal);(Payment);(Balance)\n");
                                while((Data = br.readLine()) != null){
                                    String[] token = Data.split(";");
                                    System.out.println(token[0] + ";" + token[1] + ";" + token[2] + ";" + token[3] + ";" + token[4] 
                                    + ";" + token[5] + ";" + token[6] + ";" + token[7] + ";" + token[8] + ";" + token[9]);
                                }
                                br.close();
                            }
                            catch(FileNotFoundException fe){
                                System.out.println(fe.getMessage());
                                fe.printStackTrace();
                            }
                            catch(IOException iox){
                                System.out.println(iox.getMessage());
                            }
                            catch(Exception e){
                                System.out.println("Problem: " + e.getMessage());
                            }
                        }
                    }
                    else if (option == 2){ //customer's membership account
                        System.out.println("CUSTOMER'S MEMBERSHIP ACCOUNT:");
                        System.out.println("CLUE: (Name);(Email);(Membership Code)\n");
                        try{
                            BufferedReader br = new BufferedReader(new FileReader("account.txt"));
                            String Data = null;

                            while((Data = br.readLine()) != null){
                                String[] token = Data.split(";");
                                System.out.println("==================================================");
                                System.out.println(token[0] + ";" + token[1] + ";" + token[2]);
                                System.out.println("==================================================");
                            }
                            br.close();
                        }
                        catch(FileNotFoundException fe){
                            System.out.println(fe.getMessage());
                            fe.printStackTrace();
                        }
                        catch(IOException iox){
                            System.out.println(iox.getMessage());
                        }
                        catch(Exception e){
                            System.out.println("Problem: " + e.getMessage());
                        }
                    }
                    System.out.print("\nDo you want to continue manipulating? Y/N : ");
                    loop = sc.next().charAt(0);
                    loop = Character.toUpperCase(loop);
                    System.out.print("\033\143");//clear the output
                }
            }
            else if (choice == 7){ //Exit
                System.out.print("\nDo you want to return to main menu?(Y/N): "); // yes to return to main menu, no to exit
                char start = sc2.next().charAt(0);
                start = Character.toUpperCase(start);
                if (start == 'Y')
                    found = true;
                if (start == 'N'){
                    System.out.println("Exit program.");
                    break;
                }
            }
            else 
                System.out.println("Invalid input. Please try again.");
        }
        sc.close();
        sc2.close();
    }
}