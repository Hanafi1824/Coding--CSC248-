import java.util.*;

public class ProductListApp{
	public static void main(String[] args){
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
			
		//a
		ArrayList listProduct1 = new ArrayList();
		ArrayList listProduct2 = new ArrayList();
		
		System.out.print("Enter size of object: ");
		int size = scan2.nextInt();
		
		//b
		for(int i=0; i<size; i++){
			System.out.println("PRODUCT "+(i+1)+"......");
			System.out.print("Enter Product Name: ");
			String pn = scan1.nextLine();
			System.out.print("Enter Price: RM ");
			double p = scan2.nextDouble();
			System.out.print("Enter Quantity: ");
			int q = scan2.nextInt();
			
			Product prod = new Product(pn,p,q);
			
			if(listProduct1.add(prod))
				System.out.println("Success to add new item");
			else
				System.out.println("Fail to add new item");
		}
		
		//c
		System.out.print("\n\nEnter Product Name (Search): ");
		String findProdName = scan1.nextLine();
		
		boolean flag = false;
		Product tempProd = null;
		Product findProd = null;
		for(int i=0; i<listProduct1.size(); i++){
			//casting
			tempProd = (Product)listProduct1.get(i);
			if(tempProd.getProductName().equalsIgnoreCase(findProdName)){
				flag = true;
				findProd = tempProd;
			}
							
		}
		if(flag)
			System.out.println("The item is found with the following information\n"+findProd.toString());
		else
			System.out.println("The item is not found");
		
		//d
		flag = false;
		for(int i=0; i<listProduct1.size(); i++){
			//casting
			tempProd = (Product)listProduct1.get(i);
			if(tempProd.getProductName().equalsIgnoreCase("Pen")){
				flag = true;
				tempProd.setQuantity(30);
				tempProd.setPrice(1.00);
				listProduct1.set(i,tempProd);
			}
		}
		if(flag)
			System.out.println("The item is success to replace with the new value.....");
		else
			System.out.println("The item is not in the list, therefore unable to replace the item.....");
		
		//e
		for(int i = 0; i<listProduct1.size(); i++ ){
			//casting
			tempProd = (Product)listProduct1.get(i);
			double totPrice = tempProd.getQuantity() * tempProd.getPrice();
			if(totPrice > 1000.00){
				if(listProduct1.remove(tempProd))
					System.out.println("Success to remove.....");
					
				if (listProduct2.add(tempProd))
					System.out.println("The item with total price > RM1000.00 is success to add from the listProduct1 and store in the listproduct2.....");
			}
		}
		
		//f
		System.out.println("\n\nProduct list in listProduct1");
		for(int i = 0; i<listProduct1.size(); i++){
			tempProd = (Product)listProduct1.get(i);
			System.out.println("Product "+(i+1)+"... "+tempProd.toString());
		}
		
		System.out.println("\n\nProduct list in listProduct2");
		for(int i = 0; i<listProduct2.size(); i++){
			tempProd = (Product)listProduct2.get(i);
			System.out.println("Product "+(i+1)+"... "+tempProd.toString());
		}
		
		
		
	}
}