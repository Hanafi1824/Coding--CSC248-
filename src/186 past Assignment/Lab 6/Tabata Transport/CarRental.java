public class CarRental extends RentalService{
    private double period;
    private boolean driver;

    public CarRental(){
        super();
        period = 0.0;
        driver = false;
    }

    public CarRental(String cin, String cn, String cpn, double p, boolean d){
        super(cin, cn, cpn);
        period = p;
        driver = d;
    }

    public void setCarRental(double p, boolean d){
        period = p;
        driver = d;
    }

    public double getPeriod(){ return period; }
    public boolean getDriver(){ return driver; }

    public double calcCharge(){
        double periodAfter24 = 0;
        double charges = 0;
        double totalCharges = 0;
        if (period <= 6){//up to 6
            charges = 185;
        }
        else if (period <= 12){//up to 12
            charges = 230;
        }
        else if (period <= 24){//up to 24
            charges = 285;
        }
        else if (period >= 24){//after first 24
            periodAfter24 = period - 24;
            charges = periodAfter24 * 25;//per hours
        }

        if (driver == true){
            charges += 150;
        }
        totalCharges = charges;
        return totalCharges;
    }

    public String toString(){
        return super.toString() + "\nPeriod: " + period + "\nDriver: " + driver;
    }
}