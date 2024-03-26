import java.util.*;

public class MainApp {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        ArrayList<Product> listProduct1 = new ArrayList<Product>();
        ArrayList<Product> listProduct2 = new ArrayList<Product>();

        // insert ten products into listProduct1
        listProduct1.add(new Product("Pen", 9.99, 100));
        listProduct1.add(new Product("Eraser", 0.99, 10000));
        listProduct1.add(new Product("Pencil", 1.99, 300));
        listProduct1.add(new Product("Ruler", 2.99, 259));
        listProduct1.add(new Product("Sharpener", 3.99, 500));
        listProduct1.add(new Product("Scissor", 4.99, 50));
        listProduct1.add(new Product("Paper", 5.99, 99));
        listProduct1.add(new Product("Book", 6.99, 369));
        listProduct1.add(new Product("Bag", 7.99, 20));
        listProduct1.add(new Product("Pencil Case", 8.99, 10));

        // display all records in listProduct1
        System.out.println("---------------------------------------");
        System.out.println("List of products: ");
        for (int i = 0; i < listProduct1.size(); i++){
            System.out.println(listProduct1.get(i).getProductName());
        }
        System.out.println("---------------------------------------");


        System.out.print(">>Enter the product name: ");
        String productName = scan.nextLine();

        boolean found = false;
        int index = -1;
        for (int i = 0; i < listProduct1.size(); i++){
            if (listProduct1.get(i).getProductName().equalsIgnoreCase(productName)){
                found = true;
                index = i;
            }
        }
        if (found){
            System.out.println("---------------------------------------");
            System.out.println("<<The product found!>>");
            System.out.println("\nProduct details:\n" + listProduct1.get(index));
            System.out.println("---------------------------------------");
        }

        else
            System.out.println("\n<<The product are not found!>>");

        System.out.print("\n>>Enter space to continue.");
        scan.nextLine();
        System.out.print("\033\143");//clear the output

        System.out.println("---------------------------------------");
        System.out.println(">>Before updating the product 'Pen': ");
        for (int i = 0; i < listProduct1.size(); i++){
            if (listProduct1.get(i).getProductName().equalsIgnoreCase("pen")){
                System.out.println(listProduct1.get(i));
            }
        }
        System.out.println("---------------------------------------");

        System.out.println("---------------------------------------");
        System.out.println(">>After updating the product 'Pen'");
        for (int i = 0; i < listProduct1.size(); i++){
            if (listProduct1.get(i).getProductName().equalsIgnoreCase("pen")){
                listProduct1.get(i).setQuantity(30);
                listProduct1.get(i).setPrice(1.00);
                System.out.println(listProduct1.get(i));
                found = true;
            }
        }
        System.out.println("---------------------------------------");
        if (!found)
            System.out.println("<<The product are not found!>>");

        System.out.print(">>Enter space to continue.");
        scan.nextLine();
        System.out.print("\033\143");//clear the output

        System.out.print(">>Checking the first product list before delete(Y/N): ");
        char choice = scan.next().charAt(0);
        choice = Character.toUpperCase(choice);
        if (choice == 'Y'){ // can be skip
            for (int i = 0; i < listProduct1.size(); i++){
                System.out.println(listProduct1.get(i));
            }
        }

        System.out.println("\n<<<Transfering all first product list if total price over than RM1000.>>>");
        for (int i = 0; i < listProduct1.size(); i++){
            double total;
            total = listProduct1.get(i).getPrice() * listProduct1.get(i).getQuantity();
            if (total > 1000){
                listProduct2.add(listProduct1.get(i));
                listProduct1.remove(i);
                i--;
            }
        }

        //after transfering list1 to list2 & deleting list1 data
        System.out.println("---------------------------------------");
        System.out.println(">>First product list updated: ");
        for (int i = 0; i < listProduct1.size(); i++){
            System.out.println(listProduct1.get(i));
        }
        System.out.println("---------------------------------------");

        System.out.println("---------------------------------------");
        System.out.println(">>Second product list updated: ");
        for (int i = 0; i < listProduct2.size(); i++){
            System.out.println(listProduct2.get(i));
        }
        System.out.println("---------------------------------------");
        System.out.println("\n<<<The program ended.>>>");
        scan.close();
    }
    
}