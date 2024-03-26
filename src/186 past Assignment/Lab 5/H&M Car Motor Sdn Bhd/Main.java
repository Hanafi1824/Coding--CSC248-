import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args){

        int count = 0;
        try{
            BufferedReader in = new BufferedReader(new FileReader("car.txt"));
            PrintWriter outSelangor = new PrintWriter(new BufferedWriter(new FileWriter(("selangor.txt"))));
            PrintWriter outTerengganu = new PrintWriter(new BufferedWriter(new FileWriter(("terengganu.txt"))));

            Vehicle[] arrCar = new Vehicle[100];

            String inData = null;
            while ((inData = in.readLine()) != null) {
                //Step 5: Tokenize the record into fields / attributes
                StringTokenizer st = new StringTokenizer(inData,";");
                String carType = st.nextToken();
                String carPlate = st.nextToken();
                double carPrice = Double.parseDouble(st.nextToken());
                
                //Step 6: Store onto array of object
                arrCar[count] = new Vehicle(carType, carPlate, carPrice);
                
                //Step 7: Count record
                count++;
            }
            //Step 8: Manipulation
            outSelangor.println("Type\t\tPlat Number\t\tPrice RM");
            outSelangor.println("----\t\t----------\t\t---------");
            outTerengganu.println("Type\t\tPlat Number\t\tPrice RM");
            outTerengganu.println("----\t\t----------\t\t---------");

            double totSelangor = 0;
            for (int i = 0; i < count; i++){
                if (arrCar[i].getCarPlate().charAt(0) == 'B' || arrCar[i].getCarPlate().charAt(0) == 'b'){
                    outSelangor.println(arrCar[i].getCarType() + "\t\t" + arrCar[i].getCarPlate() + "\t\t\t" + arrCar[i].getCarPrice());
                    totSelangor += arrCar[i].getCarPrice();
                }
            }

            double totTerengganu = 0;
            for (int i = 0; i < count; i++){
                if (arrCar[i].getCarPlate().charAt(0) == 'T' || arrCar[i].getCarPlate().charAt(0) == 't'){
                    outTerengganu.println(arrCar[i].getCarType() + "\t\t" + arrCar[i].getCarPlate() + "\t\t\t" + arrCar[i].getCarPrice());
                    totTerengganu += arrCar[i].getCarPrice();
                }
            }
            outTerengganu.println("Total price for all cars in Terengganu: RM " + totTerengganu);

            //Step 9: Close All File
            in.close();
            outSelangor.close();
            outTerengganu.close();
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