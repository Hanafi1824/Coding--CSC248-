public class DigitalDesign extends DesignService{
    private int digitalType;

    public DigitalDesign(){
        super();
        digitalType = 0;
    }

    public DigitalDesign(String cn, double d, boolean uo, int dt){
        super(cn, d, uo);
        digitalType = dt;
    }

    public int getDigitalType(){ return digitalType; }

    @Override
    public double calcPayment(){
        double payment = 0;
        return payment;
    }

    public String toString(){
        return super.toString() + "\nDigital type: " + digitalType;
    }
}
