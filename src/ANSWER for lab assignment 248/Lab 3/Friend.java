import java.util.*;

public class Friend
{	
	private int idno;	
	private String name, hpno, email;
	
	public Friend (int id, String n, String hp, String em) {
		idno = id;
		name = n;
		hpno = hp;
		email = em;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setHP(String hp) {
		hpno = hp;
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
	public int getId() {
		return idno;
	}
	
	public String getName() {
		return name;
	}
	
	public String getHP() {
		return hpno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public static void main(String[] args){
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		//STEP 1: Create empty lisy
		LinkedList sList = new LinkedList();
		
		int choice = 0;
		
		do{
			System.out.println("\n------------------MENU SELECTION---------------------");
			System.out.println("	1. 		Add Record." );
			System.out.println("	2. 		View Record." );
			System.out.println("	3. 		Remove Record." );
			System.out.println("	4. 		Exit." );
			System.out.println("-----------------------------------------------------");
			System.out.print("Your choice: ");
			choice = scan1.nextInt();
			
			if(choice == 1){
				System.out.println("-------------ADD RECORD------------------");
				System.out.print("How many record to add: ");
				int size = scan1.nextInt();
				for(int i=0; i<size; i++){
					System.out.print("Enter id no: ");
					int id = scan1.nextInt();
					System.out.print("Enter name: ");
					String n = scan2.nextLine();
					System.out.print("Enter hp no: ");
					String hp = scan2.nextLine();
					System.out.print("Enter email: ");
					String em = scan2.nextLine();
					
					//STEP 2: Store onto object
					Friend fr = new Friend(id,n,hp,em);
					
					//STEP 3: Store onto list (sList)
					//before add check to ensure there in no duplicate record
					boolean flag = true;
					for(int x = 0; x <sList.size(); x++){
						Friend tF = (Friend)sList.get(x);
						if(tF.getId()== id){
							flag = false;
							i = i - 1;
						}
					}
					if(flag)	
						sList.add(i,fr);
					else
						System.out.println("The record id already exists");
				}
			}
			
			else if (choice == 2){
				if(sList.size()== 0)
					System.out.println("The sList is empty");
				else{
					System.out.println("---------VIEW RECORD---------------");
					System.out.print("Enter id no to view the record: ");
					int id = scan1.nextInt();
				
					boolean flag = false;
					Friend find = null;
					
					for(int x = 0; x <sList.size(); x++){
						Friend tF = (Friend)sList.get(x);
						if(tF.getId()== id){
							find = tF;
							flag = true;
						}
					}
					if(flag)	
						System.out.print("\nId no: "+find.getId()+"\nName: "+find.getName()+ "\nHp no: "+find.getHP()+ "\nEmail: "+find.getEmail());
					else
						System.out.println("The record does not exist");	
				}				
			}
			
			else if (choice == 3){
				if(sList.size()== 0)
					System.out.println("The sList is empty");
				else{
					if(sList.size()== 1){
						System.out.println("The sList contain only one record");
						Friend remObject = (Friend)sList.remove(0);
						
						System.out.println("The following object has been removed.....");
						System.out.print("\nID No: "+remObject.getId()+"\nName: "+remObject.getName()+ "\nzHp No: "+remObject.getHP()+ "\nEmail: "+remObject.getEmail());
					}
					else{
						System.out.print("Please enter index to remove the record and the index between 0 to "+(sList.size()-1)+ " :");
						int index = scan1.nextInt();
						
						Friend remObject = (Friend)sList.remove(index);
						
						System.out.println("The following object has been removed.....");
						System.out.print("\nID No: "+remObject.getId()+"\nName: "+remObject.getName()+ "\nzHp No: "+remObject.getHP()+ "\nEmail: "+remObject.getEmail());
					}
				}
			}
			
			else if (choice == 4){
				System.out.println("System end.....");
			}
		}while(choice <4 );		
	}
}

