import java.util.*;

public class ComputerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List cList = new List ();
            
        while (true) {
            System.out.println("\nThe Linked list is exist.");//checking the list
            Computer[] c = new Computer[1]; //array of object
            Object record = null;

            System.out.println("---------------------------------------");
            System.out.println("1. Insert new node into list.");
            System.out.println("2. Delete any node from list.");
            System.out.println("3. Search computer's info.");
            System.out.println("4. Count the number of computers.");
            System.out.println("5. Exit");
            System.out.println("---------------------------------------");
            System.out.print(">>Enter your choice: ");
            int choice = sc.nextInt();
            // System.out.print("\033\143");//clear the output
                                
            if (choice == 1){ // Enter record & add into nodes
                for (int i = 0; i < 1; i++){
                    System.out.print("Enter serial number: ");
                    int sn = sc.nextInt();
                    System.out.print("Enter brand: ");
                    sc.nextLine();
                    String b = sc.nextLine();
                    System.out.print("Enter year: ");
                    int y = sc.nextInt();
                    System.out.print("Enter price: ");
                    double p = sc.nextDouble();

                    c[i] = new Computer(sn, b, y, p);
                    record = c[i];

                    //add condition if data already inside the list
                    
                    System.out.println("INSERTING NODE INTO THE LIST: ");
                    System.out.println("1. Insert node at front");
                    System.out.println("2. Insert node at back");
                    System.out.println("3. Insert node at middle");
                    System.out.print("Enter the option: ");
                    int option = sc.nextInt();

                    if (option == 1){ //Insert node at front
                        cList.insertAtFront(record);
                        cList.print();
                    }

                    else if (option == 2){ // Insert node at back
                        cList.insertAtBack(record);
                        cList.print();
                    }

                    else if (option == 3){ //Insert at middle
                        cList.insertAtMiddle(record);
                        cList.print();
                    }

                    else
                        System.out.println("Wrong input.");
                }
            }

            else if (choice == 2){ //Delete any node from list
                System.out.println("DELETING NODE FROM THE LIST: ");
                    
                System.out.print("Enter the serial number to delete: ");
                int serialNumberToDelete = sc.nextInt();
                
                Object deletedComputer = cList.remove(serialNumberToDelete);
                
                if (deletedComputer != null){
                    System.out.println("Node with serial number " + serialNumberToDelete + " deleted successfully.");
                    System.out.println("Deleted Computer Details:");
                    System.out.println(deletedComputer);
                    cList.print(); // Print the updated list
                }
                else{
                    System.out.println("No computer found with serial number " + serialNumberToDelete);
                }
            }

            else if (choice == 3){ //Search the record based on index
                System.out.println("SEARCHING RECORD: ");
                System.out.print("Enter the serial number to search for: ");
                int serialNumberToSearch = sc.nextInt();
                Object searchedRecord = cList.searchComputer(serialNumberToSearch);
                if (searchedRecord != null) {
                    System.out.println("Record found:");
                    System.out.println(searchedRecord);
                }
                else
                    System.out.println("No record found with serial number " + serialNumberToSearch);
            }

            else if (choice == 4){ //Count & display amount price
                System.out.print("Enter the price threshold: ");
                double threshold = sc.nextDouble();
                int count = cList.countComputer(threshold);
                System.out.println("Computers exceeding the price threshold:  " + count);
            }

            else if (choice == 5){ //Exit
                System.out.println("Exit program.");
                break;
            }

            else 
                System.out.println("Invalid input. Please try again.");
        }

        sc.close();
    }
}
