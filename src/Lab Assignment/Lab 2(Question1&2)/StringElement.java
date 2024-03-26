import java.util.*;

public class StringElement{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList <String> nameList = new ArrayList<>();

        while (true){
            System.out.println("\nThe Array list is exist.");//checking the list
            
            System.out.println("---------------------------------------");
            System.out.println("Menu Selection: ");
            System.out.println("\n1. Add new elements into the list.");
            System.out.println("2. Delete element from a list.");
            System.out.println("3. The number of elements in a list.");
            System.out.println("4. Check the name in the list.");
            System.out.println("5. Sort the list names in ascending order.");
            System.out.println("6. Print all elements in a list.");
            System.out.println("7. Exit.");
            System.out.println("---------------------------------------");
            System.out.print("Enter the option(1, 2, 3, 4, 5, 6, 7): ");
            int option = scan.nextInt();

            char choice =  '\u0000';
            String name = "";
            if (option == 1){ // add name
                while (choice != 'N'){
                    scan.nextLine();
                    System.out.print("\n>>Enter name for the list: ");
                    name = scan.nextLine();
                    name = name.toUpperCase();
                    nameList.add(name);
                    System.out.print("\n>>Do you want to add more name?: ");
                    choice = scan.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                }
            }

            else if (option == 2){ // delete name
                while (choice != 'N'){
                    scan.nextLine();
                    System.out.print("\n>>Enter name to delete from the list: ");
                    name = scan.nextLine();
                    nameList.remove(name);
                    System.out.print("\n>>Do you want to delete more name?: ");
                    choice = scan.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                }
            }

            else if (option == 3){ // count name
                System.out.println("\n<<The number of elements in a list: " + nameList.size() + " >>");
            }

            else if (option == 4){ //check the name
                while (choice != 'N'){
                    scan.nextLine();
                    System.out.print("\n>>Enter name to check(must uppercase): ");
                    name = scan.nextLine();
                    if (nameList.contains(name))
                        System.out.println("<<The name is in the list.>>");
                    else
                        System.out.println("<<Sorry, the name is not in the list.>>");

                    System.out.print("\n>>Do you want to check more name?: ");
                    choice = scan.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                }
            }

            else if (option == 5){ // sort list ascending orders(bubblesort)
                // Collections.sort(nameList);
                for (int i = 0; i < nameList.size(); i++) {
                    for (int j = 0; j < nameList.size() - i - 1; j++) {
                        if(nameList.get(j).compareTo(nameList.get(j + 1)) > 0) {
                            String temp = nameList.get(j);
                            nameList.set(j, nameList.get(j + 1));
                            nameList.set(j + 1, temp);
                        }
                    }
                }
                System.out.println("\n<<The list was sorted.>>");
                System.out.println("\n<<The list after sorted: " + nameList + " >>");
            }

            else if (option == 6){ // print all
                System.out.println("\n<<All elements: " + nameList + " >>");
            }

            else if (option == 7){
                System.out.println("\n<<Exit program.>>");
                scan.close();
                return;
            }

            else
                System.out.println("<<Invalid option.>>");
        }
    }
}