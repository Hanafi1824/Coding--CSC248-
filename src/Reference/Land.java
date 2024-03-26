public class Land {
    private int ID;
    private String ownerName;
    private char houseType;
    private double area;
    private String description;

    // constructor
    public Land() {
        ID = 0;
        ownerName = "";
        houseType = '\u0000';
        area = 0;
    }

    // normal constructor
    public Land(int ID, String ownerName, char houseType, double area) {
        this.ID = ID;
        this.ownerName = ownerName;
        this.houseType = houseType;
        this.area = area;
    }

    // copy constructor
    public Land(Land anotherLand) {
        this.ID = anotherLand.ID;
        this.ownerName = anotherLand.ownerName;
        this.houseType = anotherLand.houseType;
        this.area = anotherLand.area;
    }

    // getter and setter

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public char getHouseType() {
        return this.houseType;
    }

    public void setHouseType(char houseType) {
        this.houseType = houseType;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // processor
    public double calculateTax() {

        double taxRate = 0;
        switch (getHouseType()) {
            case 'T':
                taxRate = getArea() * 10;
            case 'S':
                taxRate = getArea() * 15;
            case 'B':
                taxRate = getArea() * 20;
            case 'C':
                taxRate = getArea() * 25;
        }
        return taxRate;
    }
    
    public String toString() {
        return "\nID: " + getID() + "\n" +
                "Owner Name: " + getOwnerName() + "\n" +
                "House Type: " + getHouseType() + "\n" +
                "Area: " + String.format("%.2f", getArea()) + " M\u00B2\n" +
                "Description: " + getDescription() + "\n" +
                "Tax Rate: RM" + String.format("%.2f", calculateTax());
    }
}