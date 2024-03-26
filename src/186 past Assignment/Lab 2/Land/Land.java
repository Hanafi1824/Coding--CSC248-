public class Land {

    //Attributes
    private String ID;
    private String ownerName;
    private char houseType;
    private double area;
    private String description;

    //Constructor
    public Land() {
        ID = "";
        ownerName = "";
        houseType = '\u0000';
        area = 0;
    }

    //Normal Constructor
    public Land(String ID, String ownerName, char houseType, int area) {
        this.ID = ID;
        this.ownerName = ownerName;
        this.houseType = houseType;
        this.area = area;
    }

    //Copy Constructor
    public Land(Land l) {
        ID = l.ID;
        ownerName = l.ownerName;
        houseType = l.houseType;
        area = l.area;
    }

    //Mutator
    public void setId(String id) { ID = id;}
    public void setOwnerName(String on) { ownerName = on;}
    public void setHouseType(char ht) { houseType = ht;}
    public void setArea(int a) { area = a;}
    public void setDescription(String d) { description = d;}

    //Accessor
    public String getId() {return ID;}
    public String getOwnerName() {return ownerName;}
    public char getHouseType() {return houseType;}
    public double getArea() {return area;}
    public String getDescription() {return description;}

    //Processor - Calculate tax
    public double calculateTax() {
        double taxRate = 0;
        if (houseType == 'T') {
            taxRate = getArea() * 10;
        }
        else if (houseType == 'S') {
            taxRate = getArea() * 15;
        }
        else if (houseType == 'B') {
            taxRate = getArea() * 20;
        }
        else if (houseType == 'C') {
            taxRate = getArea() * 25;
        }
        return taxRate;
    }

    public String toString() {
        return "\nID: " + getId() + "\n" +
                "Owner Name: " + getOwnerName() + "\n" +
                "House Type: " + getHouseType() + "\n" +
                "Area: " + String.format("%.2f", getArea()) + " M\u00B2\n" +
                "Description: " + getDescription() + "\n" +
                "Tax Rate: RM" + String.format("%.2f", calculateTax());
    }
}