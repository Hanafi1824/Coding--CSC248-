public class Customer {
    private String membershipName;
    private String email;
    private String membershipCode;
    private double membershipDiscount;
    private double totalPrice;

    // shared attributes for order
    private int choice;
    private int orderNum;
    private int quantity;
    private double payment;
    // food attribtes:
    private int foodAddOnChoice;
    // drink attributes:
    private char temperature;
    private char size;
    private char addOn;

    public Customer() {
        membershipName = "";
        email = "";
        membershipCode = "";
        membershipDiscount = 0.0;

        choice = 0;
        orderNum = 0;
        quantity = 0;
        payment = 0;
        foodAddOnChoice = 0;
        temperature = '\u0000';
        size = '\u0000';
        addOn = '\u0000';
    }

    public Customer(int c, int on, int q, double p, int f, char temp, char size, char aO, String n, String e, String mC,
            double md) {
        membershipName = n;
        email = e;
        membershipCode = mC;
        membershipDiscount = md;

        choice = c;
        orderNum = on;
        quantity = q;
        payment = p;
        foodAddOnChoice = f;
        temperature = temp;
        this.size = size;
        addOn = aO;
    }

    public void setCustomer(int c, int on, int q, double p, int f, char temp, char size, char aO, String n, String e,
            String mC, double md) {
        membershipName = n;
        email = e;
        membershipCode = mC;
        membershipDiscount = md;

        choice = c;
        orderNum = on;
        quantity = q;
        payment = p;
        foodAddOnChoice = f;
        temperature = temp;
        this.size = size;
        addOn = aO;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMembershipName() { return membershipName; }
    public String getEmail() { return email; }
    public String getMembershipCode() { return membershipCode; }
    public double getMembershipDiscount() { return this.membershipDiscount; }
    public int getChoice() { return choice; }

    public int getOrderNum() { return orderNum; }
    public int getQuantity() { return quantity; }
    public double getPayment() { return payment; }
    public int getFoodAddOnChoice() { return foodAddOnChoice; }
    public char getTemperature() { return temperature; }
    public char getSize() { return size; }
    public char getAddOn() { return addOn; }

    public double getTotalPrice() {
        // if there is membership discount
        if (membershipDiscount > 0) {
            totalPrice = orderCalc() * membershipDiscount;
        } else {
            totalPrice = orderCalc();
        }

        return totalPrice;
    }

    public double orderCalc() {
        double price = 0;
        double originalPrice = 0;

        switch(choice){   
            case 1: //western food
                if (orderNum == 1) price = 19.0; //chicken chop
                else if (orderNum == 2) price = 21.0; //lamb chop
                else if (orderNum == 3) price = 16.50; //spaghetti
                else if (orderNum == 4) price = 8.50; //french fries/wedges
                else if (orderNum == 5) price = 27.0; //beef steak
                else if (orderNum == 6) price = 18.0; //sizzling
                else if (orderNum == 7) price = 15.50; //burger
                originalPrice = (price * quantity) + foodAddOn();
            break;
            case 2: //dessert
                if (orderNum == 1) price = 7; //ice cream
                else if (orderNum == 2) price = 8.50; //cake
                else if (orderNum == 3) price = 11; //waffle
                else if (orderNum == 4) price = 4.50; //donut
                else if (orderNum == 5) price = 9; //croissant
                originalPrice = (price * quantity) + foodAddOn();
            break;
            case 3: //coffee
                if (orderNum == 1){//espresso
                    if (temperature == 'H'){
                        if (size == 'R') price = 5.0;
                    }
                }
                else if (orderNum == 2){//americano
                    if (temperature == 'H'){
                        if(size == 'R') price = 6.0;
                    } else if (temperature == 'C'){
                        if(size == 'R') price = 7.0;
                        else if (size == 'L') price = 7.5;
                    }
                }
                else if (orderNum == 3){//latte
                    if (temperature == 'H'){
                        if(size == 'R') price = 8.0;
                    } else if (temperature == 'C'){
                        if(size == 'R') price = 9.0;
                        else if (size == 'L') price = 9.5;
                    }
                }
                else if (orderNum == 4){//cappuccino
                    if (temperature == 'H'){
                        if(size == 'R') price = 8.0;
                    } else if (temperature == 'C'){
                        if(size == 'R') price = 9.0;
                        else if (size == 'L') price = 9.5;
                    }
                }
                else if (orderNum == 5){//mocha
                    if (temperature == 'H'){
                        if(size == 'R') price = 11.0;
                    } else if (temperature == 'C'){
                        if(size == 'R') price = 12.0;
                        else if (size == 'L') price = 12.5;
                    }
                }
                else if (orderNum == 6){//caramel macchiato
                    if (temperature == 'H'){
                        if(size == 'R') price = 11.0;
                    } else if (temperature == 'C'){
                        if(size == 'R') price = 12.0;
                        else if (size == 'L') price = 12.5;
                    }
                }
                originalPrice = (price * quantity) + drinkAddOn();
            break;
            case 4: //ice blended
                if (orderNum == 1){//strawberry
                    if (size == 'R') price = 8;
                    else if (size == 'L') price = 8.5;
                }
                else if (orderNum == 2){//chocolate
                    if (size == 'R') price = 8;
                    else if (size == 'L') price = 8.5;
                }
                else if (orderNum == 3){//vanilla
                    if(size == 'R') price = 8;
                    else if (size == 'L') price = 8.5;
                }
                else if (orderNum == 4){//oreo
                    if(size == 'R') price = 8;
                    else if (size == 'L') price = 8.5;
                }
                else if (orderNum == 5){//green tea
                    if(size == 'R') price = 8.5;
                    else if (size == 'L') price = 9;
                }
                originalPrice = (price * quantity) + drinkAddOn();
            break;
        
            default:
                price = 0;
        }

        return originalPrice;
    }

    public double drinkAddOn() {
        double addOnPrice = 0;
        if (addOn == 'E')// extrashot
            addOnPrice = 1.5;
        else if (addOn == 'S')// syrup
            addOnPrice = 1.5;
        else
            addOnPrice = 0;
        return addOnPrice;
    }

    public double foodAddOn() {
        double addOnPrice = 0;
        if (foodAddOnChoice == 1) // Extra cheese
            addOnPrice = 2.5;
        else if (foodAddOnChoice == 2) // Extra Sauce
            addOnPrice = 1.5;
        else if (foodAddOnChoice == 3) // Extra Mayonis
            addOnPrice = 1.5;
        else if (foodAddOnChoice == 4) // Mashed potatoes
            addOnPrice = 5.5;
        else if (foodAddOnChoice == 5) // Coleslaw
            addOnPrice = 3.5;
        else
            addOnPrice = 0;
        return addOnPrice;
    }

    public double balance() {
        double balance = 0;
        if (membershipDiscount > 0) {
            if (payment > orderCalc())
                balance = payment - (orderCalc() * membershipDiscount); // will have balance
            else if (orderCalc() > payment)
                balance = payment - (orderCalc() * membershipDiscount); // will be negative
            else
                balance = payment - (orderCalc() * membershipDiscount); // no balance
        } else {
            if (payment > orderCalc())
                balance = payment - orderCalc(); // will have balance
            else if (orderCalc() > payment)
                balance = payment - orderCalc(); // will be negative
            else
                balance = payment - orderCalc(); // no balance
        }
        return balance;
    }

    // selection to print receipt:
    public String orderReceipt() { // print type of order:
        String orderType = "";
        if (choice == 1) {
            orderType = "Western Food";
        } else if (choice == 2) {
            orderType = "Dessert";
        }
        return orderType;
    }

    public String orderReceipt2() { // print type of order:
        String orderType = "";
        if (choice == 3) {
            orderType = "Coffee";
        } else if (choice == 4) {
            orderType = "Blended";
        }
        return orderType;
    }

    public String menuReceipt() {// print type of food:
        String order = "";
        if (choice == 1) {
            if (orderNum == 1) {
                order = "Chicken Chop";
            } else if (orderNum == 2) {
                order = "Lamb Chop";
            } else if (orderNum == 3) {
                order = "Spaghetti";
            } else if (orderNum == 4) {
                order = "French Fries / Wedges";
            } else if (orderNum == 5) {
                order = "Beef Steak";
            } else if (orderNum == 6) {
                order = "Sizzling";
            } else if (orderNum == 7) {
                order = "Burger";
            }
        } else if (choice == 2) {
            if (orderNum == 1) {
                order = "Ice Cream";
            } else if (orderNum == 2) {
                order = "Cake";
            } else if (orderNum == 3) {
                order = "Waffle";
            } else if (orderNum == 4) {
                order = "Donut";
            } else if (orderNum == 5) {
                order = "Croissant";
            }
        }
        return order;
    }

    public String menuReceipt2() { // print type of drink
        String order = "";
        if (choice == 3) {
            if (orderNum == 1) {
                order = "Esspresso";
            } else if (orderNum == 2) {
                order = "Americano";
            } else if (orderNum == 3) {
                order = "Latte";
            } else if (orderNum == 4) {
                order = "Cappuccino";
            } else if (orderNum == 5) {
                order = "Mocha";
            } else if (orderNum == 6) {
                order = "Caramel Macchiato";
            }
        } else if (choice == 4) {
            if (orderNum == 1) {
                order = "Strawberry";
            } else if (orderNum == 2) {
                order = "Chocolate";
            } else if (orderNum == 3) {
                order = "Vanilla";
            } else if (orderNum == 4) {
                order = "Oreo";
            } else if (orderNum == 5) {
                order = "Green Tea";
            }
        }
        return order;
    }

    public String foodAddOnReceipt() {// print type of food add-on:
        String addOnType = "";
        if (foodAddOnChoice == 1) {
            addOnType = "Extra Cheese";
        } else if (foodAddOnChoice == 2) {
            addOnType = "Extra Sauce";
        } else if (foodAddOnChoice == 3) {
            addOnType = "Extra Mayonis";
        } else if (foodAddOnChoice == 4) {
            addOnType = "Mashed Potatoes";
        } else if (foodAddOnChoice == 5) {
            addOnType = "Coleslaw";
        } else
            addOnType = "None";
        return addOnType;
    }

    public String temperatureReceipt() {// print type of temperature:
        String temperatureType = "";
        if (temperature == 'H') {
            temperatureType = "Hot";
        } else if (temperature == 'C') {
            temperatureType = "Cold";
        } else
            temperatureType = "None";
        return temperatureType;
    }

    public String sizeReceipt() {// print type of size:
        String sizeType = "";
        if (size == 'R') {
            sizeType = "Regular";
        } else if (size == 'L') {
            sizeType = "Large";
        } else
            sizeType = "None";
        return sizeType;
    }

    public String drinkAddOnReceipt() {// print type drink of add-on:
        String addOnType = "";
        if (addOn == 'E') {
            addOnType = "Extra-shot";
        } else if (addOn == 'S') {
            addOnType = "Syrup";
        } else
            addOnType = "None";
        return addOnType;
    }

    public void printMenu(int choice) { // display menu
        if (choice == 1) {
            System.out.println("\n==============================================");
            System.out.print("|(1)Western Food:            |    Price:    |");
            System.out.print("\n==============================================");
            System.out.print("\n|(1)Chicken Chop             |   RM 19.00   |");
            System.out.print("\n|(2)Lamb Chop                |   RM 21.00   |");
            System.out.print("\n|(3)Spaghetti                |   RM 16.50   |");
            System.out.print("\n|(4)French Fries / Wedges    |   RM  8.50   |");
            System.out.print("\n|(5)Beef Steak               |   RM 27.00   |");
            System.out.print("\n|(6)Sizzling                 |   RM 18.00   |");
            System.out.print("\n|(7)Burger                   |   RM 15.50   |");
            System.out.println("\n===============================================");
        } else if (choice == 2) {
            System.out.println("\n==========================================");
            System.out.print("|(2)Dessert:              |    Price:    |");
            System.out.print("\n==========================================");
            System.out.print("\n|(1)Ice Cream             |   RM  7.00   |");
            System.out.print("\n|(2)Cake                  |   RM  8.50   |");
            System.out.print("\n|(3)Waffle                |   RM 11.00   |");
            System.out.print("\n|(4)Donut                 |   RM  4.50   |");
            System.out.print("\n|(5)Croissant             |   RM  9.00   |");
            System.out.println("\n==========================================");
        } else if (choice == 3) {
            System.out.println("\n====================================================");
            System.out.print("|(1)COFFEE:                 |    Hot:    |    Cold:   |");
            System.out.print("\n====================================================");
            System.out.print("\n|(1)Espresso             |  RM 5.00   |      -     |");
            System.out.print("\n|(2)Americano            |  RM 6.00   |  RM 7.00   |");
            System.out.print("\n|(3)Latte                |  RM 8.00   |  RM 9.00   |");
            System.out.print("\n|(4)Cappuccino           |  RM 8.00   |  RM 9.00   |");
            System.out.print("\n|(5)Mocha                |  RM 11.00  |  RM 12.00  |");
            System.out.print("\n|(6)Caramel Macchiato    |  RM 11.00  |  RM 12.00  |");
            System.out.println("\n====================================================");
        } else if (choice == 4) {
            System.out.println("\n(2)Blended: ");
            System.out.println("\n========================================");
            System.out.print("|Drinks:                 |   Price:   |");
            System.out.print("\n========================================");
            System.out.print("\n|(1)Strawberry           |  RM 8.00   |");
            System.out.print("\n|(2)Chocolate            |  RM 8.00   |");
            System.out.print("\n|(3)Vanilla              |  RM 8.00   |");
            System.out.print("\n|(4)Oreo                 |  RM 8.00   |");
            System.out.print("\n|(5)Green Tea            |  RM 8.50   |");
            System.out.println("\n========================================");
        } else
            System.out.println("WRONG CHOICE!!");
    }
    public String toString() {
        if (choice == 1 || choice == 2) { // food
            return "\n=============================================="
                    + "\n\t          WARCOFF          "
                    + "\n=============================================="
                    + "\n\nORDER: " + quantity + " " + menuReceipt() + " (" + orderReceipt() + ")"
                    + "\nADD-ON (Food): " + foodAddOnReceipt()
                    + String.format("\nADD-ON PRICE (Food): RM %,.2f", foodAddOn())
                    + String.format("\nSUBTOTAL: RM %,.2f\n", orderCalc())
                    + String.format("\nYOUR MONEY: RM %,.2f", payment)
                    + String.format("\nYOUR BALANCE: RM %,.2f\n", balance());
        } else if (choice == 3 || choice == 4) { // drink
            return "\n=================================================="
                    + "\n\t              WARCOFF          "
                    + "\n=================================================="
                    + "\n\nORDER: " + quantity + " " + menuReceipt2() + " (" + orderReceipt2() + ")"
                    + "\nTEMPERATURE: " + temperatureReceipt()
                    + "\nSIZE: " + sizeReceipt()
                    + "\nADD-ON (Drink): " + drinkAddOnReceipt()
                    + String.format("\nADD-ON PRICE (Drink): RM %,.2f", drinkAddOn())
                    + String.format("\nSUBTOTAL: RM %,.2f\n", orderCalc())
                    + String.format("\nYOUR MONEY: RM %,.2f", payment)
                    + String.format("\nYOUR BALANCE: RM %,.2f\n", balance());
        } else
            return "Empty receipt";
    }
}