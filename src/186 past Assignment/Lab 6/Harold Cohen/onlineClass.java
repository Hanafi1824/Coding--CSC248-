public class onlineClass extends courseRegistration{
    private String programCode;

    public onlineClass(){
        super();
        programCode = "";
    }

    public onlineClass(String ID, String n, int a, char g, int t, String pc){
        super(ID, n, a, g, t);
        programCode = pc;
    }

    public void setProgramCode(String pc){ programCode = pc; }

    public String getProgramCode(){ return programCode; }

    public double calculateFee(){
        double basicFee = 0;
        double priceAfterDiscount = 0;
        double rate = 0;// 

        if (getProgramCode().equalsIgnoreCase("COMP")){
            if (getStudentType() == 1){
                rate = 0.6;
                basicFee = 1600;
            }
            else if (getStudentType() == 2){
                rate = 0.7;
                basicFee = 2100;
            }
        }
        else if (getProgramCode().equalsIgnoreCase("ENG")){
            if (getStudentType() == 1){
                rate = 0.65;
                basicFee = 1600;
            }
            else if (getStudentType() == 2){
                rate = 0.75;
                basicFee = 2100;
            }
        }
        
        priceAfterDiscount = basicFee * rate;
        return priceAfterDiscount;
    }

    public String toString(){
        return super.toString() + "\nProgram code: " + programCode;
    }
}
