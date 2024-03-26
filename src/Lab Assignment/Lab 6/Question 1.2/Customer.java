public class Customer {
    private String name;
    private int accountNo;
    private double saving;
    private double totalTransaction;

    public Customer(String n, int an, double s, double t){
        name = n;
        accountNo = an;
        saving = s;
        totalTransaction = t;
    }

    public String getName(){ return name; }
    public int getAccountNo(){ return accountNo; }
    public double getSaving(){ return saving; }
    public double getTotalTransaction(){ return totalTransaction; }

    public String toString(){
        return "Name: " + name + "\nAccount No: " + accountNo + "\nSaving: RM " + saving + "\nTotal Transaction: RM " + totalTransaction;
    }

    public boolean process(){ // Qualify condition
        if (saving > 1000)
            return true;

        else
            return false;
    }
}
