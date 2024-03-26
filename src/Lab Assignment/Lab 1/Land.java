public class Land {
    private int ID;
    private String ownerName;
    private char houseType;
    private double area;

    public Land(){
        ID = 0;
        ownerName = "";
        houseType = '\u0000';
        area = 0;
    }

    public Land(int ID, String ownerName, char houseType, double area){
        this.ID = ID;
        this.ownerName = ownerName;
        this.houseType = houseType;
        this.area = area;
    }

    public void setLand(int ID, String ownerName, char houseType, double area){
        this.ID = ID;
        this.ownerName = ownerName;
        this.houseType = houseType;
        this.area = area;
    }

    public int getID() {return ID;}
    public String getOwnerName(){ return ownerName; }
    public char getHouseType(){ return houseType; }
    public double getArea(){ return area; }

    public double calculateTax(){
        double taxRate = 0;
        if (houseType == 'T'){
            taxRate = getArea() * 10;
        }
        else if (houseType == 'S'){
            taxRate = getArea() * 15;
        }
        else if (houseType == 'B'){
            taxRate = getArea() * 20;
        }
        else if (houseType == 'C'){
            taxRate = getArea() * 30;
        }
        return taxRate;
    }

    public String toString() {
        return "\nID: " + getID() + "\n" +
                "Owner Name: " + getOwnerName() + "\n" +
                "House Type: " + getHouseType() + "\n" +
                "Area: " + String.format("%.2f", getArea()) + " M\u00B2";
    }
}
