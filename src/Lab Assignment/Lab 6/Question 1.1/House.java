public class House {
    public String type;
    public String location;
    public double size;
    public double price;

    public House (String t, String l, double s, double p){
        type = t;
        location = l;
        size = s;
        price = p;
    }

    public String getType(){ return type; }
    public String getLocation(){ return location; }
    public double getSize(){ return size; }
    public double getPrice(){ return price; }

    public String toString(){
        return "\nHouse type: " + type + "\nHouse location: " + 
        location + "\nHouse size: " + size + "\nHouse price: " + price;
    }
}
