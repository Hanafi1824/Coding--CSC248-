import java.util.*;
import java.text.*;

public class FurnitureApp2
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		DecimalFormat df = new DecimalFormat("##,###.00");
		
		//Declare an array of object named arrFurniture and store some data onto array.
		System.out.print("Enter size of array: ");
		int size = scan.nextInt();
		Furniture[] arrFurniture = new Furniture [size];
		
		for(int i = 0; i < size; i++)
			arrFurniture[i] = new Furniture();
			
		for(int i = 0; i < size; i++)
		{
			System.out.print("\nEnter the furniture type: ");
			String ft = scan1.nextLine();
			System.out.print("Enter furniture's material: ");
			String mt = scan1.nextLine();
			System.out.print("Enter price per unit: RM");
			double pu = scan2.nextDouble();
			System.out.print("Enter the quantity: ");
			int qty = scan2.nextInt();
			
			arrFurniture[i] = new Furniture(ft,mt,pu,qty);
		}
		
	    //To calculate and display the total price of furniture for each type of material.
	    double totWood = 0.0, totRattan = 0.0, totMetal = 0.0, totBamboo = 0.0;
	    for (int i = 0; i < size; i++){
	    	if (arrFurniture[i].getMaterial().equalsIgnoreCase("wood")){
	    		totWood+=arrFurniture[i].calcPriceFurniture();
	    	}
	    	if (arrFurniture[i].getMaterial().equalsIgnoreCase("rattan")){
	    		totRattan+=arrFurniture[i].calcPriceFurniture();
	    	}
	    	if (arrFurniture[i].getMaterial().equalsIgnoreCase("metal")){
	    		totMetal+=arrFurniture[i].calcPriceFurniture();
	    	}
	    	if (arrFurniture[i].getMaterial().equalsIgnoreCase("bamboo")){
	    		totBamboo+=arrFurniture[i].calcPriceFurniture();
	    	}	
	    }
		System.out.print("\nTotal price of wood material: RM"+df.format(totWood));
		System.out.print("\nTotal price of rattan material: RM"+df.format(totRattan));
		System.out.print("\nTotal price of metal material: RM"+df.format(totMetal));
		System.out.print("\nTotal price of bamboo material: RM"+df.format(totBamboo));
		
		//To determine the highest price of wood and display the details of information
		double max = 0.0;
		for (int i = 0; i < size; i++){
			if (arrFurniture[i].calcPriceFurniture()>max){
				max = arrFurniture[i].calcPriceFurniture();
			}
			System.out.println(arrFurniture[i].toString());
		}
		System.out.println("\nHighest price of wood is RM"+df.format(max));
		scan.close();
		scan1.close();
		scan2.close();
	}
}