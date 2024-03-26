public class Renter {
    private String name;
    private String contactNo;
    private Address address;
    private double travelDistance;
    private char lorrytype;
    private boolean driver;

    public Renter(String n, String cN, String streetName, String district, String state, double tD, char lt, boolean d) {
        name = n;
        contactNo = cN;
        address = new Address(streetName, district, state);
        travelDistance = tD;
        lorrytype = lt;
        driver = d;
    }

    public void setRenter(String n, String cN, double tD, char lt, boolean d){
        name = n;
        contactNo = cN;
        travelDistance = tD;
        lorrytype = lt;
        driver = d;
    }

    public String getName(){ return name; }
    public String getContactNo(){ return contactNo; }
    public Address getAddress(){ return address; }
    public double getTravelDistance(){ return travelDistance; }
    public char getLorrytype(){ return lorrytype; }
    public boolean getDriver(){ return driver; }

    public double calculateSpecialService(){
        double specialService = 0;
        if (driver){
            if (travelDistance >= 200)
                specialService = 150 * 2;
            else
                specialService = 150;
        }
        return specialService;
    }

    public double calculateTotalPrice(){
        double totalPrice = 0;
        if (lorrytype == 'A')
            totalPrice = 560 + calculateSpecialService();
        else if (lorrytype == 'B')
            totalPrice = 720 + calculateSpecialService();
        else if (lorrytype == 'C')
            totalPrice = 1300 + calculateSpecialService();
        return totalPrice;
    }

    public void displayRenter(){
        System.out.println("\nName: " + name);
        System.out.println("Contact No: " + contactNo);
        System.out.println("Address: " + address);
        System.out.println("Travel Distance: " + travelDistance);
        System.out.println("Lorry Type: " + lorrytype);
        System.out.println("Driver: " + driver);
        System.out.printf("Special Service: RM %,.2f\n", calculateSpecialService());
        System.out.printf("Total Price: RM %,.2f\n", calculateTotalPrice());
    }
}
