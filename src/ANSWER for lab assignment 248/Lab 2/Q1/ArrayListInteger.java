import java.util.*;

public class ArrayListInteger{
	public static void main(String[] args){
		Scanner scan = new Scanner (System.in);
		
		//STEP 1: Create an empty list
		ArrayList intList = new ArrayList();
		
		int option = 0;
		do{
			System.out.println("\n\n...........OPERATION..................");
			System.out.println("\n1---> Add new item into list");
			System.out.println("2---> Delete an item from a list");
			System.out.println("3---> The numbers of items in the list");
			System.out.println("4---> Calculate the total of items (numbers) in the list");
			System.out.println("5---> Print all items(numbers) in the list");	
			System.out.println("6---> Exit");
			System.out.print("Enter your option: ");
			option = scan.nextInt();
			System.out.println("\n......................................");
			
			if(option == 1){
				System.out.print("Enter the number of values (size of item): ");
				int size = scan.nextInt();
				
				for(int i=0; i<size; i++){
					System.out.print("Enter the integer number: ");
					int number = scan.nextInt();
					//STEP 2: Store new item in the list
					if (intList. add(""+number))
						System.out.println ("Success to add......");
				}
			}
			else if (option == 2){
				//STEP 3: Manipulation - Remove item
				System.out.println("1. Remove item based on index");
				System.out.println("2. Remove item based on value of items");
				System.out.print("Your choice: ");
				int choice = scan.nextInt();
				
				if(choice == 1){
					System.out.print("Enter index of item to be removed: ");
					int index = scan.nextInt();
					
					Object obj = intList.remove(index);
					
					System.out.println("Item remove is:" + Integer.parseInt(obj.toString()));
				}
				else{
					System.out.print("Enter value of items to be removed: ");
					int val = scan.nextInt();
					
					if(intList.remove(""+val))
						System.out.println("Item is successfully removed......");
				}
			}
			else if (option == 3){
				//STEP 3: Manipulation - size of list
				System.out.println("The number of items (size) in the list: "+intList.size());
			}
			else if (option == 4){
				//STEP 3: Manipulation - calculate total in the list
				int tot = 0;
				for(int i=0; i<intList.size(); i++){
					tot += Integer.parseInt(intList.get(i).toString());
				}
				System.out.println("The total of number in the list: "+tot);
			}
			else if (option == 5){
				//STEP 3: Manipulation - print items from the list
				System.out.print("The items are: ");
				for(int i=0; i<intList.size(); i++){
					System.out.print(" "+intList.get(i));
				}
			}
			else if (option == 6){
				System.out.println("Exit......");
			}
			else{
				System.out.println("Wrong option input and please enter valid option.....");
			}
						
		}while(option != 6);
	}
}