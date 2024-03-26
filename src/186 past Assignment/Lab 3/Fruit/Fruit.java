public class Fruit {
    private String name;
    private String type;
    private double weight;
    private double price;

    //Default constructor
    public Fruit(){
        name = "";
        type = "";
        weight = 0;
        price = 0;
    }

    //Normal constructor
    public Fruit(String nme, String ty, double w, double p){
        name = nme;
        type = ty;
        weight = w;
        price = p;
    }

    //Copy constructor
    public Fruit(Fruit fruit){
        name = fruit.name;
        type = fruit.type;
        weight = fruit.weight;
        price = fruit.price;
    }

    //Setter
    public void setName(String nme){
        name = nme;
    }
    public void setType(String ty){
        type = ty;
    }
    public void setWeight(double w){
        weight = w;
    }
    public void setPrice(double p){
        price = p;
    }

    //getter
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getWeight(){
        return weight;
    }
    public double getPrice(){
        return price;
    }

    //Processor
    public boolean isLocal(){
        if (type.charAt(0) == 'L' || type.charAt(0) == 'l'){
            return true;
        }
        else{
            return false;
        }
    }

    public double calcTotalPrice(){
        double total;
        if (type.charAt(0) == 'L' || type.charAt(0) == 'l'){
            total = 0.97 * (price * weight);
        }
        else{
            total = price * weight;
        }
        return total;
    }

    public String toString(){
        return "\n----------" + "\nFruit name: " + name + "\nType: " + type + "\nWeight: " + weight + "\nPrice: RM " + price;
    }
}
