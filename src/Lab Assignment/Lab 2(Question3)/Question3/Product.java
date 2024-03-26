public class Product{
    private String productName;
    private double price;
    private int quantity;
    
    public Product(String pn, double p, int q){
        productName = pn;
        price = p;
        quantity = q;
    }
    
    public void setProductName(String pn){ productName = pn; }
    public void setPrice (double p) { price = p; }
    public void setQuantity (int q) { quantity = q; }

    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String toString(){
        return "\nProduct name: " + productName + "\nPrice: RM " + price + "\nQuantity: " + quantity;
    }
}