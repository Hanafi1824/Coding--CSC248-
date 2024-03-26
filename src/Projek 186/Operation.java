public abstract class Operation{
    protected String customerName;
    protected int drink;
    protected int flavour;
    protected char temperature;
    protected char size;
    protected char addOn;
    protected int day;
    protected int quantity;

    public Operation(){
        customerName = "";
        drink = 0;
        flavour = 0;
        temperature = '\u0000';
        size = '\u0000';
        addOn = '\u0000';
        day = 0;
        quantity = 0;
    }
    public Operation(String nm, int drink, int f, char temp, char size, char aO,  int day, int q){// normal
        customerName = nm;
        this.drink = drink;
        flavour = f;
        temperature = temp;
        this.size = size;
        addOn = aO;
        this.day = day;
        quantity = q;
    }
    public void setSistem(String nm, int drink, int f, char temp, char size, char aO,  int day, int quantity){
        customerName = nm;
        this.drink = drink;
        flavour = f;
        temperature = temp;
        this.size = size;
        addOn = aO;
        this.day = day;
        this.quantity = quantity;
    }
    public String getCustomerName(){ return customerName; };
    public int getDrink(){ return drink; }
    public int getFlavour(){ return flavour; }
    public char getTemperature(){ return temperature; }
    public char getSize(){ return size; }
    public char getAddOn(){ return addOn; }
    public int getDay(){ return day; }
    public int getQuantity(){ return quantity; }

    public abstract String toString();
}