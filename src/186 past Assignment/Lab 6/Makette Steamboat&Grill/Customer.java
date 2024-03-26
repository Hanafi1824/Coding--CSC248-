public class Customer {
    protected String customer;
    private char packageMenu;

    public Customer(){
        customer = "";
        packageMenu = '\u0000';
    }

    public Customer(String c, char pm){
        customer = c;
        packageMenu = pm;
    }

    public void setCustomer(String c, char pm){
        customer = c;
        packageMenu = pm;
    }

    public String getCustomer(){ return customer; }
    public char getPackageMenu(){ return packageMenu; }

    public String toString(){
        return "\nCustomer: " + customer + "\nPackage Menu: " + packageMenu;
    }
}