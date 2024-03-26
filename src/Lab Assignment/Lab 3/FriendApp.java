import java.util.*;

public class FriendApp {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        LinkedList<Friend> sList = new LinkedList<>();

        while(true){
            System.out.println("\nThe Linked list is exist.");//checking the list

            System.out.println("---------------------------------------");
            System.out.println("1. Insert data in records");
            System.out.println("2. Checking the records");
            System.out.println("3. Remove records");
            System.out.println("4. Update records");
            System.out.println("5. Display all the records");
            System.out.println("6. Exit");
            System.out.println("---------------------------------------");
            System.out.print(">>Enter your choice: ");
            int choice = s.nextInt();
            System.out.print("\033\143");//clear the output

            if (choice == 1){ // Add new record 
                boolean found = false;
                while (!found){
                    System.out.println("\nINSERTION IN RECORDS: ");
                    System.out.print(">>Enter ID number: ");
                    int id = s.nextInt();
                    System.out.print(">>Enter name: ");
                    String name = s.next();
                    System.out.print(">>Enter HP number: ");
                    String hp = s.next();
                    System.out.print(">>Enter email: ");
                    String email = s.next();

                    Friend frList = new Friend(id, name, hp, email);

                    for (int i = 0; i < sList.size(); i++){
                        if (sList.get(i).getId() == id){
                            found = true;
                            System.out.println("The ID number is duplicated.");
                        }
                        if (sList.get(i).getName().equals(name)){
                            found = true;
                            System.out.println("The Name is duplicated.");
                        }
                        if (sList.get(i).getHP().equals(hp)){
                            found = true;
                            System.out.println("The HP number is duplicated.");
                        }
                        if (sList.get(i).getEmail().equals(email)){
                            found = true;
                            System.out.println("The Email address is duplicated.");
                        }
                    }
                    if (found){ // duplicate
                        System.out.println("Duplicate data detected!");
                        found = false;
                    }
                    else{ // no duplicate
                        sList.add(frList);
                        System.out.println("New record added! No duplicate data.");
                        found = true;
                    }
                }
            }

            else if (choice == 2){ // Checking the records using ID
                System.out.println("CHECKING THE RECORDS: ");
                System.out.print("Enter the ID number: ");
                int findID = s.nextInt();

                boolean found = false;
                for (Friend friend : sList){ //found
                    if (friend.getId() == findID){
                        found = true;
                        System.out.println("\nID number: " + friend.getId());
                        System.out.println("Name: " + friend.getName());
                        System.out.println("HP number: " + friend.getHP());
                        System.out.println("Email: " + friend.getEmail());
                        break;
                    }
                }
                if(!found)
                    System.out.println("No record found!");
            }

            else if (choice == 3){ // Remove record
                System.out.println("REMOVING THE RECORDS: ");

                if (sList.size() == 0){
                    System.out.println("The list is empty.");
                }
                else if (sList.size() == 1){
                    System.out.println("Only one record in the list: ");
                    for (int i = 0; i < sList.size(); i++){
                        System.out.println("\nRecord " + (i + 1) + " in the list: ");
                        System.out.println("ID number: " + sList.get(i).getId());
                        System.out.println("Name: " + sList.get(i).getName());
                        System.out.println("HP number: " + sList.get(i).getHP());
                        System.out.println("Email: " + sList.get(i).getEmail());
                    }
                }
                else{   // remove the record
                    System.out.print("Enter the ID number: ");
                    int deleteID = s.nextInt();
                    
                    boolean found = false;
                    for (Friend friend : sList){
                        if (friend.getId() == deleteID){
                            sList.remove(friend);
                            found = true;
                            System.out.println(deleteID + " have removed from the list.");
                            break;
                        }
                    }
                    // Iterator<Friend> iterator = sList.iterator();
                    // while (!found && iterator.hasNext()) {
                    //     Friend friend = iterator.next();
                    //     if (friend.getId() == deleteID) {
                    //         iterator.remove();
                    //         found = true;
                    //         System.out.println(deleteID + " have removed from the list.");
                    //         break;
                    //     }
                    // }
                    for (int i = 0; i < sList.size(); i++){
                        if (sList.get(i).getId() == deleteID){
                            sList.remove(deleteID); 
                            found = true;                       
                        }
                    }
                    if (!found)
                        System.out.println("No record found!");
                } 
            }

            else if (choice == 4){ // Update record
                System.out.println("UPDATING THE RECORDS: ");
                System.out.print("Enter ID number: ");
                int updateID = s.nextInt();
                for (Friend friend : sList){
                    if (friend.getId() == updateID){
                        System.out.println("The record is exist!");
                        System.out.print("Enter HP number for update: ");
                        String updateHP = s.next();
                        friend.setHP(updateHP);
                        System.out.print("Enter email for update: ");
                        String updateEmail = s.next();
                        friend.setEmail(updateEmail);
                    }
                    else
                        System.out.println("Record not found!");
                }
            }

            else if (choice == 5){ // Print all record
                System.out.println("DISPLAYING ALL RECORDS: ");
                for (int i = 0; i < sList.size(); i++){
                    System.out.println("\nRecord " + (i + 1) + " in the list: ");
                    System.out.println("ID number: " + sList.get(i).getId());
                    System.out.println("Name: " + sList.get(i).getName());
                    System.out.println("HP number: " + sList.get(i).getHP());
                    System.out.println("Email: " + sList.get(i).getEmail());
                }
            }

            else if (choice == 6){ // Stop program
                System.out.println("EXIT PROGRAM.");
                s.close();
                break; 
            }

            else
                System.out.println("WRONG OPTION CODE!");
        }
    }
}