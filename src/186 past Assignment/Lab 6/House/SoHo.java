public class SoHo extends House{
    private double unitPrice;
    private char packages;

    public SoHo(){
        super();
        unitPrice = 0;
        packages = '\u0000';
    }

    public SoHo(String b, long ic, String g, boolean bp, double u, char p){
        super(b, ic, g, bp);
        unitPrice = u;
        packages = p;
    }

    public double getUnitPrice(){ return unitPrice; }
    public char getPackages(){ return packages; }

    public double sohoPrice(){
        double addtionalPrice = 0; 
        double totalPrice = unitPrice; 
        if (packages == 'F' || packages == 'f'){
            addtionalPrice = 50000;
            totalPrice += addtionalPrice;
        }

        else if (packages == 'P' || packages == 'p'){
            addtionalPrice = 20000;
            totalPrice += addtionalPrice;
        }

        else if (packages == 'U' || packages == 'u'){
            addtionalPrice = 0;
            totalPrice += addtionalPrice;
        }

        if (getBumiputera()){
            double discount = 0.9;
            totalPrice *= discount;
        }
        
        return totalPrice; 
    }

    public String toString(){
        return super.toString() + "\nUnit price: " + unitPrice
        + "\nPackages: " + packages;
    }
}
