public class Cupcake{
    private String name;
    private String code;
    private double price;

    public Cupcake(){ //Default constructor
        name = "";
        code = "";
        price = 0;
    }

    //Normal constructor
    public Cupcake(String nme, String cd, double pr){
        name = nme;
        code = cd;
        price = pr;
    }

    public Cupcake(Cupcake ccake){ //Copy constructor
        name = ccake.name;
        code = ccake.code;
        price = ccake.price;
    }

    //Accessor
    public void setName(String nme){ //Setter
        name = nme;
    }
    public void setCode(String cd){
        code = cd;
    }
    public void setPrice(double pr){
        price = pr;
    }

    public String getName(){ //Getter
        return name;
    }
    public String getCode(){
        return code;
    }
    public double getPrice(){
        return price;
    }

    //Processor
    public double priceInDozen(){
        double rate = 0.0;
        double netPrice = 0;

        if (code.charAt(4) == '1'){
            rate = 0.95;
        }
        else if (code.charAt(4) == '2'){
            rate = 0.92;
        }
        else if (code.charAt(4) == '3'){
            rate = 0.90;
        }
        else{
            rate = 1;
        }
        netPrice = (price * 12) * rate;
        return netPrice;
    }

    public String toString(){
        return "\n\nCupcake name: " + name + "\nCode: " + code + "\nPrice: RM " + price;
    }
}