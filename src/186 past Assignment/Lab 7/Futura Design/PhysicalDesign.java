public class PhysicalDesign extends DesignService{
    private int physicalType;
    private boolean printing;
    private int numCopy;

    public PhysicalDesign(){
        super();
        physicalType = 0;
        printing = false;
        numCopy = 0;
    }

    public PhysicalDesign(String cn, double d, boolean uo, int pt, boolean p, int nc){
        super(cn, d, uo);
        physicalType = pt;
        printing = p;
        numCopy = nc;
    }

    public int getPhysicalType(){ return physicalType; }
    public boolean getPrinting(){ return printing; }
    public int getNumCopy(){ return numCopy; }

    public double calcPayment(){
        double charge = 250;
        double additionalCharge = 0;
        double payment = 0;
        if (physicalType == 1){
            additionalCharge = 40;
        }
        else if (physicalType == 2){
            additionalCharge = 10;
        }
        else if (physicalType == 3){
            additionalCharge = 35;
        }
        else if (physicalType == 4){
            additionalCharge = 3;
        }
        
        if (urgentOrder == true){
            additionalCharge += 50;
        }
        
        payment = (charge + (additionalCharge * getNumCopy())) - getDeposit();
        return payment;
    }

    public String toString(){
        return super.toString() + "\nPhysical Type: " + physicalType +
        "\nPrinting: " + printing + "\nNumber of copy: " + numCopy;
    }
}
