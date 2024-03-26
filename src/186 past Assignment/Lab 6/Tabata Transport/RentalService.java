public class RentalService {
    protected String custICNo;
    protected String custName;
    protected String custPhoneNo;

    public RentalService(){
        custICNo = "";
        custName = "";
        custPhoneNo = "";
    }

    public RentalService(String cin, String cn, String cpn) {
        custICNo = cin;
        custName = cn;
        custPhoneNo = cpn;
    }

    public void setRentalService(String cin, String cn, String cpn){
        custICNo = cin;
        custName = cn;
        custPhoneNo = cpn;
    }

    public String getCustICNo(){ return custICNo; }
    public String getCustName(){ return custName; }
    public String getCustPhoneNo(){ return custPhoneNo; }

    public String toString(){
        return "\nCustomer IC Number: " + custICNo + "\nCustomer Name: " +
        custName + "\nCustomer Phone No: " + custPhoneNo;
    }
}
