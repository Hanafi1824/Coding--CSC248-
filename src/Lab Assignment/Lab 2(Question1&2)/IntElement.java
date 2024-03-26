import java.util.*;

public class IntElement {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList <Integer> numberList = new ArrayList<>();

        while (true){
            System.out.println("\nThe Array list is exist.");//checking the list

            System.out.println("---------------------------------------");
            System.out.println("Menu Selection: ");
            System.out.println("\n1. Add new elements into the list.");
            System.out.println("2. Delete element from a list.");
            System.out.println("3. The number of elements in a list.");
            System.out.println("4. Calculate the total of the number in a list.");
            System.out.println("5. Print all elements in a list.");
            System.out.println("6. Exit.");
            System.out.println("---------------------------------------");
            System.out.print("Enter the option(1, 2, 3, 4, 5, 6): ");
            int option = scan.nextInt();

            char choice = '\u0000';
            if (option == 1){ //add number
                while (choice != 'N'){
                    System.out.print("\n>>Enter the number(to add): ");
                    numberList.add(scan.nextInt());
                    System.out.print("\n>>Do you want to add more? (Y/N): ");
                    choice = scan.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                }
            }

            else if (option == 2){ // delete number
                while (choice != 'N'){
                    System.out.print("\n>>Enter the number(to delete): ");
                    int numbers = scan.nextInt();
                    numberList.remove((Integer) numbers);
                    System.out.print("\n>>Do you want to delete more? (Y/N): ");
                    choice = scan.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                }
            }

            else if (option == 3){ //count element
                System.out.println("\n<<The number of elements in a list: " + numberList.size() + " >>");
            }

            else if (option == 4){ // total element
                int sum = 0;
                // for (int num : numberList){
                //     // sum += num;
                // }
                for (int i = 0; i < numberList.size(); i++){
                    sum += Integer.parseInt(numberList.get(i).toString());
                }
                System.out.println("\n<<The total of the number in a list: " + sum + " >>");
            }

            else if (option == 5){ // print all
                // System.out.println("\n<<All elements: " + numberList + " >>");
                for (int i = 0; i < numberList.size(); i++){
                    int numberlist = numberList.get(i);
                }
                System.out.println("\n<<All elements: " + numberList + " >>");
            }

            else if (option == 6){ // exit
                System.out.println("\n<<Exit program.>>");
                scan.close();
                return;
            }

            else
                System.out.println("<<Invalid option.>>");
        }
    }
}
