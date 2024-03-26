public class Food {
    protected String name;
    protected int quantityOrder;
    protected boolean member;

    public Food(){
        name = "";
        quantityOrder = 0;
        member = false;
    }

    public Food(String n, int q, boolean m){
        name = n;
        quantityOrder = q;
        member = m;
    }

    public void setName(String n){
        name = n;
    }
    public void setQuantityOrder(int q){
        quantityOrder = q;
    }
    public void setIsMember(boolean b){
        member = b;
    }

    public String getName(){ return name; }
    public int getQuantityOrder(){ return quantityOrder; }
    public boolean getMember(){ return member; }

    public String toString(){
        return "\n\nName: " + name + "\nQuantity order: " + quantityOrder
        + "\nMember: " + member;
    }
}
