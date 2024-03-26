import java.io.*;
import java.util.*;

public class LandApp{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		BufferedReader in = null;
		
		//STEP 1: Declare array of object
		Land[] lnd = new Land[100];
		
		try{
			in = new BufferedReader (new FileReader("CustomerData.txt"));
			
			String inData = null;
			int size = 0;
			//STEP 2: read from  text file - CustomerData.txt
			while ((inData = in.readLine()) != null){
				StringTokenizer st = new StringTokenizer(inData,";");
				int id = Integer.parseInt(st.nextToken());
				String ownName = st.nextToken();
				char hseType = st.nextToken().charAt(0);
				double area = Double.parseDouble(st.nextToken());
				
				//STEP 3: Store onto object
				lnd[size] = new Land(id,ownName,hseType,area);
				size++;
			}
			
			//STEP 4: Manipulation
			int option = 0;
			
			while(option != 4){
				System.out.println("-------------------------------");
				System.out.println("\n\n1.Sorting using Bubble Sort.");
				System.out.println("2.Sorting using Insertion Sort.");
				System.out.println("3.Sorting using Binary Search.");
				System.out.println("4.Exit.");
				System.out.print("\n\nYour Option: ");
				option = scan.nextInt();
				System.out.println("\n\n-------------------------------");
			
				if (option == 1){
					bubbleSort(lnd, size);
					for(int i=0; i<size; i++){
						System.out.println(lnd[i].toString() + "\nTax: RM "+lnd[i].calcTax());
					}
				}
			
				else if (option == 2){
					insertionSort(lnd,size);
					for(int i=0; i<size; i++){
						System.out.println(lnd[i].toString() + "\nTax: RM "+lnd[i].calcTax());
					}
				}
				else if (option == 3){
					//Sorting using binary Search before calling insertionSort()
					insertionSort(lnd,size);
					System.out.print("Enter key id to search: "); //Enter search id key
					int schId = scan.nextInt();	
					int mid = binarySearch(lnd, size, schId);
					System.out.println(lnd[mid].toString()+ "\nTax: RM "+lnd[mid].calcTax());
				}
				else if (option == 4)
					System.out.println("Exit the option.....");
				else
					System.out.println("Wrong option input.....Please input again.");
			}//end while
			
		}//end try
		catch(FileNotFoundException fe){
			System.out.println(fe.getMessage());
		}
		
		catch(Exception e){
			System.out.println("Problem: "+e.getMessage());
		}
	}
	
	public static void bubbleSort(Land[] data, int size) {//an array and size of array
		Land temp = null;       // for swap
		for(int outer=size-1;  outer > 0; outer--){
			for (int inner=0; inner < outer; inner++) {
				// traverse the nested loops
				if ( data[inner].calcTax() > data[inner+1].calcTax() ) {
					// swap current element with next
          			// if the current element is greater
					temp = data[inner];
          			data[inner] = data[inner+1];
          			data[inner+1] = temp;
        		}
			}// inner for loop
		}// outer for loop
	}
	
	public static void insertionSort(Land arr[], int size) 
 	{ 
    	//int n = arr.length; 
    	for (int i = 1; i < size; ++i) { 
        	int key = arr[i].getId();
        	Land temp = arr[i]; 
        	int j = i - 1; 
  
        	/*  Move elements of arr[0..i-1], that are 
           		greater than key, to one position ahead 
           		of their current position */
         	while (j >= 0 && arr[j].getId() > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
         	} 
         	arr[j + 1] = temp; 
     	} 
 	}
 	
 	public static int binarySearch (Land[] data , int size, int schId)
 	{
 		//set first to first index
 		int first = 0;
 		//set last to last elements in array
 		int last = size - 1; 
 		//calculate mid of the array
 		int mid = (first + last)/2;
 		
 		//while first and last do not overlap
 		while( first <= last ){
 			//if the mid < key, then key to be searched is in the first half of arra
 			if ( data[mid].getId() < schId ){
 				first = mid + 1;
 			}
 			else if ( data[mid].getId() == schId ){
 				//if key = element at mid, then print the location
 				System.out.println("Element is found at index: " + mid);
 				break;
 			}
 			else{
 				//the key is to be searched in the second half of the array
 				last = mid - 1;
 			}
 			mid = (first + last)/2;
 		}
 		
 		//if first and last overlap, then key is not present in the array
 		if ( first > last ){
 			System.out.println("Element is not found!");
 		}
 		return mid;
 	}
}