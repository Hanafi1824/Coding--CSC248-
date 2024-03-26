public class DineInCustomer extends Customer{
    private int numOfAdult;
    private int numOfChild;
    private char otherPackage;

    public DineInCustomer(){
        super();
        numOfAdult = 0;
        numOfChild = 0;
        otherPackage = '\u0000';
    }

    public DineInCustomer(String c, char pm, int noa, int noc, char op){
        super(c, pm);
        numOfAdult = noa;
        numOfChild = noc;
        otherPackage = op;
    }

    public void setDineInCustomer(int noa, int noc, char op){
        numOfAdult = noa;
        numOfChild = noc;
        otherPackage = op;
    }

    public int getNumberOfAdult(){ return numOfAdult; }
    public int getNumberOfChild(){ return numOfChild; }
    public char getOtherPackage(){ return otherPackage; }

    public boolean isDineIn(){
        return true;
    }

    public String toString(){
        return super.toString() + "\nNumber of Adult: " + numOfAdult + "\nNumber of Child: " +
        numOfChild + "\nOther package: " + otherPackage;
    }
}
