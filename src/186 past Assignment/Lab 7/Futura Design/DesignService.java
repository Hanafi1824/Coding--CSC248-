public abstract class DesignService {
    protected String custName;
    protected double deposit;
    protected boolean urgentOrder;

    public DesignService(){
        custName = "";
        deposit = 0;
        urgentOrder = false;
    }

    public DesignService(String cn, double d, boolean uo){
        custName = cn;
        deposit = d;
        urgentOrder = uo;
    }

    public String getName(){ return custName; }
    public double getDeposit(){ return deposit; }
    public boolean getUrgentOrder(){ return urgentOrder; }

    public abstract double calcPayment();

    public String toString(){
        return "\nCustomer name: " + custName + "\nDeposit: RM " + 
        deposit + "\nUrgent order: " + urgentOrder;  
    }
}
