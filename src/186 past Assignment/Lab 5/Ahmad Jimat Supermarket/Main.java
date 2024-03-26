import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args){

        int count = 0;
        try{
            BufferedReader in = new BufferedReader(new FileReader("20180221.txt"));
            PrintWriter outReportSales = new PrintWriter(new BufferedWriter(new FileWriter(("reportSale.txt"))));

            Supermarket[] arrStore = new Supermarket[100];

            String inData = null;
            while ((inData = in.readLine()) != null) {
                //Step 5: Tokenize the record into fields / attributes
                StringTokenizer st = new StringTokenizer(inData,",");
                String itemName = st.nextToken();
                int quantity = Integer.parseInt(st.nextToken());
                double unitPrice = Double.parseDouble(st.nextToken());
                
                //Step 6: Store onto array of object
                arrStore[count] = new Supermarket(itemName, quantity, unitPrice);
                
                //Step 7: Count record
                count++;
            }
            //Step 8: Manipulation
            outReportSales.printf("%-20s%-20s%-20s%-20s\n","Item","Quantity","Price(RM)","Sub Total(RM)");

            double subTotal = 0;
            double totSales = 0;
            for (int i = 0; i < count; i++){
                subTotal = arrStore[i].getQuantity() * arrStore[i].getUnitPrice();
                outReportSales.printf("%-20s%-20d%-20.2f%-20.2f\n", arrStore[i].getItemName(),
                arrStore[i].getQuantity(), arrStore[i].getUnitPrice(), subTotal);
                totSales += subTotal;
            }
            outReportSales.printf("%-20s%-20.2f","TOTAL SALE for date: 21st, February 2018 is: RM ",totSales);

            //Step 9: Close All File
            in.close();
            outReportSales.close();
        }//End Try (Step 10: End block try)
        //Step 11: Exception Handling
        catch(FileNotFoundException fe){
            System.out.println(fe.getMessage());
        }

        catch(IOException iox){
            System.out.println(iox.getMessage());
        }

        catch (Exception e){
            System.out.println("Problem: " + e.getMessage());
        }
    }
}