public class Payment extends Operation{
    private Membership membership;

    public Payment(){
        super();
        membership = new Membership();
    }

    public Payment(String nm, int drink, int f, char temp, char size, char aO,  int day, 
    int q, String membershipName, String email, String membershipCode){// normal
        super(nm, drink, f, temp, size, aO, day, q);// superclass
        membership = new Membership(membershipName, email, membershipCode);// composite
    }

    public void setPayment(Membership membership){
        this.membership = membership;
    }
    
    public Membership getMembership() { return membership; }

    public double specialDayDiscount(){
        double specialDiscount = 0;
        if (day == 3)
            specialDiscount = 0.95;
        else
            specialDiscount = 1;
        return specialDiscount;
    }
    public double addOn(){
        double addOnPrice = 0;
        if (addOn == 'E')
            addOnPrice = 1.5;
        else if (addOn == 'S')
            addOnPrice = 1.5;
        else
            addOnPrice = 0;
        return addOnPrice;
    }
    public double orderCalc(){
        double price = 0;
        switch(drink)
        {   case 1:
                if (flavour == 1){
                    if (temperature == 'H'){
                        if (size == 'R')
                            price = 5.0;
                    }
                }
                else if (flavour == 2){
                    if (temperature == 'H'){
                        if(size == 'R')
                            price = 6.0;
                    }
                    else if (temperature == 'C'){
                        if(size == 'R')
                            price = 7.0;
                        else if (size == 'L')
                            price = 7.5;
                    }
                }
                else if (flavour == 3){
                    if (temperature == 'H'){
                        if(size == 'R')
                            price = 8.0;
                    }
                    else if (temperature == 'C'){
                        if(size == 'R')
                            price = 9.0;
                        else if (size == 'L')
                            price = 9.5;
                    }
                }
                else if (flavour == 4){
                    if (temperature == 'H'){
                        if(size == 'R')
                            price = 8.0;
                    }
                    else if (temperature == 'C'){
                        if(size == 'R')
                            price = 9.0;
                        else if (size == 'L')
                            price = 9.5;
                    }
                }
                else if (flavour == 5){
                    if (temperature == 'H'){
                        if(size == 'R')
                            price = 11.0;
                    }
                    else if (temperature == 'C'){
                        if(size == 'R')
                            price = 12.0;
                        else if (size == 'L')
                            price = 12.5;
                    }
                }
                else if (flavour == 6){
                    if (temperature == 'H'){
                        if(size == 'R')
                            price = 11.0;
                    }
                    else if (temperature == 'C'){
                        if(size == 'R')
                            price = 12.0;
                        else if (size == 'L')
                            price = 12.5;
                    }
                }
            break;
            
            case 2:
                if (flavour == 1){
                    if (size == 'R')
                        price = 8;
                    else if (size == 'L')
                        price = 8.5;
                }
                else if (flavour == 2){
                    if (size == 'R')
                        price = 8;
                    else if (size == 'L')
                        price = 8.5;
                }
                else if (flavour == 3){
                    if(size == 'R')
                        price = 8;
                    else if (size == 'L')
                        price = 8.5;
                }
                else if (flavour == 4){
                    if(size == 'R')
                        price = 8;
                    else if (size == 'L')
                        price = 8.5;
                }
                else if (flavour == 5){
                    if(size == 'R')
                        price = 8.5;
                    else if (size == 'L')
                        price = 9;
                }
            break;
        
            default:
                price = 0;
                
        }
        double originalPrice = ((price * specialDayDiscount()) * quantity) + addOn();
        return originalPrice;
    }

    //selection to print:
    public String menuReceipt(){//print type of drinks:
        String order = "";
        if (drink == 1){
            if (flavour == 1){order = "Esspresso";}
            else if (flavour == 2){order = "Americano";}
            else if (flavour == 3){order = "Latte";}
            else if (flavour == 4){order = "Cappuccino";}
            else if (flavour == 5){order = "Mocha";}
            else if (flavour == 6){order = "Caramel Macchiato";}
        }
        else if (drink == 2){
            if (flavour == 1){order = "Strawberry";}
            else if (flavour == 2){order = "Chocolate";}
            else if (flavour == 3){order = "Vanilla";}
            else if (flavour == 4){order = "Oreo";}
            else if (flavour == 5){order = "Green Tea";}
        }
        return order;
    }
    public String temperatureReceipt(){//print type of temperature:
        String temperatureType = "";
        if (temperature == 'H'){temperatureType = "Hot";}
        else if (temperature == 'C'){temperatureType = "Cold";}
        return temperatureType;
    }
    public String sizeReceipt(){//print type of size:
        String sizeType = "";
        if (size == 'R'){sizeType = "Regular";}
        else if (size == 'L'){sizeType = "Large";}
        return sizeType;
    }
    public String addOnReceipt(){//print type of add-on:
        String addOnType = "";
        if (addOn == 'E'){addOnType = "Extra-shot";}
        else if (addOn == 'S'){addOnType = "Syrup";}
        else{addOnType = "None";}
        return addOnType;
    }
    public String dayReceipt(){//print type of day:
        String dayType = "";
        if (day == 1){dayType = "Monday";}
        else if (day == 2){dayType = "Tuesday";}
        else if (day == 3){dayType = "Wednesday";}
        else if (day == 4){dayType = "Thursday";}
        else if (day == 5){dayType = "Friday";}
        else if (day == 6){dayType = "Saturday";}
        else if (day == 7){dayType = "Sunday";}
        return dayType;
    }
    public String drinkReceipt(){
        String drinkType = "";
        if (drink == 1){drinkType = "Coffee";}
        else if (drink == 2){drinkType = "Blended";}
        return drinkType;
    }
    
    @Override
    public String toString(){
        return "\n==========================================" 
        + "\n\t        AYAQ CAFE          " 
        + "\n==========================================" 
        + "\n\n\nNAME: " + customerName 
        + "\nDAY: " + dayReceipt() 
        + "\nORDERr: " + quantity + " " + menuReceipt() + " (" + drinkReceipt() + ")" 
        + "\nTEMPERATURE: " + temperatureReceipt() 
        + "\nSIZE: " + sizeReceipt() 
        + "\nADD-ON: " + addOnReceipt()
        + String.format("\nADD-ON PRICE: RM %,.2f\n", addOn())
        + String.format("SUBTOTAL: RM %,.2f\n", orderCalc());
    }
}