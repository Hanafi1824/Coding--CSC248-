import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class deliverooApp {
    public static void main(String[] args) {
        // Step 1: Exception Handling (Block Try)
        try {
            // Step 2: Open All file
            BufferedReader in = new BufferedReader(new FileReader("deliveroo.txt"));
            PrintWriter outEarnings = new PrintWriter(new BufferedWriter(new FileWriter("earnings.txt")));

            outEarnings.println("Profit earned for each delivery ");
            outEarnings.println("Date(Day)\t\t\t\tProfit");
            outEarnings.println("====================================");

            int countEarningsAfter9 = 0;
            int count = 0;
            double profit = 0;
            double total = 0;
            // Step 3: Read data from input file
            String inData = null;
            while ((inData = in.readLine()) != null) {
                // String[] token = inData.split(",");
                /*
                 * token[0] = deliveryDate;
                 * token[1] = day;
                 * token[2] = startTime;
                 * token[3] = endTime;
                 * token[4] = restaurantName;
                 * token[5] = totalPrice
                 * token[6] = deliveryDistance(km)
                 * token[7] = priceMultiplier
                 */

                // Step 4: Tokenize the record into field / attributes
                StringTokenizer st = new StringTokenizer(inData, ",");
                String deliveryDate = st.nextToken();
                String day = st.nextToken();
                Date startTime = new SimpleDateFormat("hh:mm:ss a").parse(st.nextToken()); // example 09:00 PM
                Date endTime = new SimpleDateFormat("hh:mm:ss a").parse(st.nextToken());
                String restaurantName = st.nextToken();
                double price = Double.parseDouble(st.nextToken());// token[5]
                String deliveryDistance = st.nextToken();
                double priceMultiplier = Double.parseDouble(st.nextToken());
                profit = (priceMultiplier * price) - price;

                total += profit;
                count++;
                if (startTime.after(new SimpleDateFormat("hh:mm:ss a").parse("09:00:00 PM")) 
                || startTime.equals(new SimpleDateFormat("hh:mm:ss a").parse("09:00:00 PM"))) {
                    countEarningsAfter9++;
                }

                day = day.substring(0, 3);
                String formattedProfit = String.format("%.2f", profit);
                // Step 5: Manipulation
                outEarnings.println(deliveryDate + "(" + day + ")" + "\t\t\t\tRM" + formattedProfit);
            } // end while
            double averageProfit = total / count;
            String formattedProfit = String.format("%.2f", averageProfit);
            outEarnings.println("====================================");
            outEarnings.println("Average profit for each order: RM" + formattedProfit);
            System.out.println("Delivery after 9pm: " + countEarningsAfter9);

            // Step 6: Close All file
            in.close();
            outEarnings.close();

        } // end try (Step 7: End block try)
          // Step 8: Exception Handling (Catch Block)

        catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }

        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        catch (Exception e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }
}