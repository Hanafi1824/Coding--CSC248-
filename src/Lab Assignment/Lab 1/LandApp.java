import java.util.*;
import java.io.*;

public class LandApp {
    public static void bubbleSort(Land data[], int size) {
        Land temp = null;   //for swap
        for (int outer = size - 1; outer > 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                //traverse the nested loops
                if(data[inner].calculateTax() > data[inner+1].calculateTax()) {
                    //swap current element with next
                    //if the current element is great
                    temp = data[inner];
                    data[inner] = data[inner+1];
                    data[inner+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static int binarySearch(Land[] l, int size, int searchID) {
        // set first to first index
        int first = 0;
        // set last to last elements in array
        int last = size - 1;

        //while first and last do not overlap
        while (first <= last){
            // calculate mid of the array
            int mid = (first + last) / 2;
            
            //if the mid < key, then key to be searched is in the first half of array
            if (l[mid].getID() < searchID){
                first = mid + 1;
            }
            else if (l[mid].getID() == searchID){
                return mid; // return the index where the ID is found
            }
            else{
                //the key is to be searched in the second half of the array
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return -1;// if the ID is not found
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in); 
        System.out.print("Enter space to start."); //start program
        Land[] l = new Land[100];

        try{
            BufferedReader br = new BufferedReader(new FileReader("customerData.txt"));
            String Data = null;
            int size = 0;
            scan1.nextLine();

            while((Data = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(Data,";");
                int id = Integer.parseInt(st.nextToken());
                String ownerName = st.nextToken();
                char houseType = st.nextToken().charAt(0);
                double area = Double.parseDouble(st.nextToken());
                
                System.out.println("The data has already readed.");
                
                l[size] = new Land(id, ownerName, houseType, area);
                size++;
            }

            int option = 0;
            while (option != 4){
                System.out.println("---------------------------------------");
                System.out.println("Menu Selection");
                System.out.println("\n1. Sorting using Bubble Sort");
                System.out.println("2. Sorting using Insertion Sort");
                System.out.println("3. Searching using Binary Search");
                System.out.println("4. Exit");
                System.out.print("\nYour Option: ");
                option = scan.nextInt();

                if (option == 1){
                    LandApp.bubbleSort(l, size);
                    for (int i = 0; i < size; i++){
                        System.out.println(l[i].toString() + "\nTax: RM " + l[i].calculateTax());
                    }

                }
                else if (option == 2){
                    for (int i = 1; i < size; i++){
                        Land key = l[i];
                        int j = i - 1;

                        while (j >= 0 && l[j].getID() > key.getID()){
                            l[j + 1] = l[j];
                            j--;
                        }

                        l[j + 1] = key;
                    }

                    for (int i = 0; i < size; i++){
                        System.out.println("ID: " + l[i].getID());
                        System.out.println("Owner Name: " + l[i].getOwnerName());
                        // System.out.printf("Tax: RM %,.2f\n", lands[i].calculateTax());
                        System.out.println();                    
                    }

                    System.out.println("This is sorted based on the ID");
                }
                else if (option == 3){
                    char choice = '\u0000';
                    LandApp.bubbleSort(l, size);
                    while (choice != 'N'){
                        System.out.print("Enter key ID to search: ");
                        int searchID = scan.nextInt();
                        int middle = binarySearch(l, size, searchID);
                        if (middle != -1)
                            System.out.println(l[middle].toString() + "\nTax: RM " + l[middle].calculateTax());
                        else
                            System.out.println("ID not found!");

                        System.out.println("---------------------------------------");
                        System.out.print("\nDo you want to search another ID?(Y/N): ");
                        choice = scan.next().charAt(0);
                        choice = Character.toUpperCase(choice);

                        scan.nextLine();
                    }
                }
                else if (option == 4){
                    System.out.println("Exit program.");// exit 
                }
                else
                    System.out.println("Wrong option.");
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