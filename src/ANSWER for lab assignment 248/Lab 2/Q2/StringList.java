import java.util.*;

public class StringList{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		//STEP 1: Create an empty list
		ArrayList strList = new ArrayList();
		
		//STEP 2: Input
		System.out.print("Enter size: ");
		int size = scan1.nextInt();
		
		//i.
		for(int i= 0; i<size; i++){
			System.out.print("Enter name: ");
			String name = scan.nextLine();
			//STEP 3: Store onto list
			if(strList.add(name))
				System.out.println("Success to add new item");
		}
		//ii.
		System.out.print("Enter name to remove from the list: ");
		String nameRemove = scan.nextLine();
		
		if(strList.remove(nameRemove))
			System.out.println("Success to remove from the list");
		
		//iii.
		System.out.println("The numbers in the list: "+strList.size());
		
		//iv
		System.out.print("Enter name to search: ");
		String nameSearch = scan.nextLine();
		if(strList.contains(nameSearch))
			System.out.println("Name exist in the list");
		else
			System.out.println("Name don't exist in the list");
		
		//vi
		/* Collections.sort method is sorting the  elements of ArrayList in ascending order. */
        Collections.sort(strList); 
  
        // Let us print the sorted list 
        System.out.println("List after the use of Collection.sort() :\n" + strList); 
        
        //v
        System.out.println("Name in the list: ");
        for(int i=0; i<strList.size(); i++){
        	System.out.print(" "+strList.get(i));
        }
		
			
	}
}