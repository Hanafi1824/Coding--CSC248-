import java.util.*;
import java.text.*;

public class FruitApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("###,###.00");

        // Declare array of object
        System.out.print("Enter the size of array: ");
        int size = scan1.nextInt();
        System.out.println("");
        Fruit[] fruitList = new Fruit[size];

        for (int i = 0; i < size; i++) {
            fruitList[i] = new Fruit();
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Enter fruit name: ");
            String nme = scan.nextLine();
            System.out.print("Enter fruit type (Local(l) / Import(i)): ");
            String ty = scan.nextLine();
            System.out.print("Enter fruit weight(kg): ");
            double w = scan1.nextDouble();
            System.out.print("Enter fruit price: RM ");
            double p = scan1.nextDouble();
            System.out.println("");

            // Store into object
            fruitList[i] = new Fruit(nme, ty, w, p);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(fruitList[i].toString() + "\nLocal: " + fruitList[i].isLocal()
                    + "\nTotal price of fruits: RM " + df.format(fruitList[i].calcTotalPrice()));
        }

        double highestPricedLocalFruit = 0;
        double totalSaleOfImportedFruits = 0.0;
        Fruit maxLocal = new Fruit();

        for (int i = 0; i < size; i++) {
            if (fruitList[i].isLocal()) {
                if (fruitList[i].getPrice() > highestPricedLocalFruit) {
                    highestPricedLocalFruit = fruitList[i].getPrice();
                    maxLocal = new Fruit(fruitList[i]);
                }
            } else {
                totalSaleOfImportedFruits += fruitList[i].calcTotalPrice();
            }
        }

        System.out.println("\n---------" + "\nThe highest price of local fruit: " + maxLocal.toString()
                + "\nThe highest price: RM " + highestPricedLocalFruit);

        int importedFruit = 0;
        for (int i = 0; i < size; i++) {
            if (!fruitList[i].isLocal()) {
                importedFruit++;
            }
        }
        System.out.println("\nTotal sales imported fruit: " + importedFruit);

        double total = 0;
        for (int i = 0; i < size; i++) {
            total += fruitList[i].calcTotalPrice();
        }
        System.out.println("\n\nTotal price: RM " + df.format(total));
        scan.close();
        scan1.close();
    }
}
