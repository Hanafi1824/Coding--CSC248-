public class Address {
    private String streetName;
    private String district;
    private String state;
    
    public Address(String sN, String d, String s) {
        streetName = sN;
        district = d;
        state = s;
    }

    public void setAddress(String sN, String d, String s){
        streetName = sN;
        district = d;
        state = s;
    }

    public String getStreetName(){ return streetName; }
    public String getDistrict(){ return district; }
    public String getState(){ return state; }
    
    public String toString(){
        return "\nStreet Name: " + streetName + "\nDistrict: " 
        + district + "\nState: " + state;
    }
}
