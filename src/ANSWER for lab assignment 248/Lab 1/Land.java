public class Land{
	private int id;
	private String ownName;
	private char hseType;
	private double area;
	
	//Default Constructor
	public Land(){
		id = 0;
		ownName = "";
		hseType = ' ';
		area = 0; 
	} 
	
	//Normal Constructor
	public Land(int id, String ownName, char hseType, double area){
		this.id = id;
		this.ownName = ownName;
		this.hseType = hseType;
		this.area = area; 
	} 
	
	//Mutator
	public void setId(int id){
		this.id = id;
	}
	
	public void setOwnName(String ownName){
		this.ownName = ownName;
	}
	
	public void setHseType(char hseType){
		this.hseType = hseType;
	}
	
	public void setArea(double area){
		this.area = area;
	}
	
	//Retriever
	public int getId(){
		return id;
	}
	
	public String getOwnName(){
		return ownName;
	}
	
	public char getHseType(){
		return hseType;
	}
	
	public double getArea(){
		return area;
	}
	
	public double calcTax(){
		double rate = 0;
		
		if(hseType == 'T')
			rate = 10.00;
		else if (hseType == 'S')
			rate = 15.00;
		else if (hseType == 'B')
			rate = 20.00;
		else
			rate = 30.00;
		
		return area*rate;	
	}
	
	public String toString(){
		return "\nId: "+id+ "\nOwner Name: "+ownName+ "\nHouse Tyepe: "+hseType+ "\nArea: "+area;
	}	
}