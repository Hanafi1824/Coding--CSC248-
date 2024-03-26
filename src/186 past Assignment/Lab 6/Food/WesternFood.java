public class WesternFood extends Food{
    private int foodSet;
    private boolean desert;

    public WesternFood(){
        super();//not necessary
        foodSet = 0;
        desert = false;
    }

    public WesternFood(String n, int q, boolean m, int f, boolean d){
        super(n, q, m);
        foodSet = f;
        desert = d;
    }

    public void setFoodSet(int f){
        foodSet = f;
    }
    public void setDesert(boolean d){
        desert = d;
    }

    public int getFoodSet(){ return foodSet; }
    public boolean getDesert(){ return desert; }

    public double Payment(){
        double price = 0;
        if (foodSet == 1){
            price = 30.00;
        }
        else if (foodSet == 2){
            price = 20.00;
        }
        else if (foodSet == 3){
            price = 15.00;
        }
        double totPrice = price * quantityOrder;

        if (desert){
            totPrice = totPrice + 10.90 * quantityOrder;
        }
        if (member){
            totPrice = totPrice * 0.90;
        }
        return totPrice;
    }

    public String toString(){
        return super.toString() + "\nFood Set: " + foodSet + "\nDesert: " + desert;
    }
}