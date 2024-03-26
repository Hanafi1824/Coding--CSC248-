public class Supermarket {
    private String itemName;
    private int quantity;
    private double unitPrice;

    public Supermarket(String iN, int q, double uP){
        itemName = iN;
        quantity = q;
        unitPrice = uP;
    }

    public void setSupermarket(String iN, int q, double uP){
        itemName = iN;
        quantity = q;
        unitPrice = uP;
    }

    public String getItemName(){ return itemName; }
    public int getQuantity(){ return quantity; }
    public double getUnitPrice(){ return unitPrice; }

    public String toString(){
        return "Item Name: " + itemName + "\nQuantity: " 
        + quantity + "\nUnit Price: RM " + unitPrice;
    }
}
