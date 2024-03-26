public class House {
    private String buyerName;
    private long ic;
    private String gender;
    private boolean bumiputera;

    public House(){
        buyerName = "";
        ic = 0;
        gender = "";
        bumiputera = false;
    }

    public House(String b, long ic, String g, boolean bp){
        buyerName = b;
        this.ic = ic;
        gender = g;
        bumiputera = bp;
    }

    public String getBuyerName(){ return buyerName; }
    public long getIC(){ return ic; }
    public String getGender(){ return gender; }
    public boolean getBumiputera(){ return bumiputera; }

    public String toString(){
        return "\nBuyer name: " + buyerName + "\nIC: " + ic
        + "\nGender: " + gender + "\nBumiputera: "+ bumiputera;
    }
}
