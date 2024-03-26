import java.io.*;

public class FTMSKApp {
    public static void main(String[] args){
        //Step 1: Exception Handling (Block Try)
        // %-20s (format to synchronize when print output)
        // -20 : 20 white space
        // s : string
        // d : decimal(nombor bulat)
        try {
            //Step 2: Open All file
            BufferedReader in = new BufferedReader(new FileReader("FTMSK.txt"));
            PrintWriter outCS110 = new PrintWriter(new BufferedWriter(new FileWriter("CS110Male.txt")));
            PrintWriter outCS111 = new PrintWriter(new BufferedWriter(new FileWriter("CS111Male.txt")));

            outCS110.printf("%-20s\n","Male Student from CS110: ");
            outCS110.printf("%-20s%-30s%-20s\n","Matrix Number","Name","Part");
            outCS111.printf("%-20s\n","Male Student from CS111: ");
            outCS111.printf("%-20s%-30s%-20s\n","Matrix Number","Name","Part");

            int cntCS110 = 0;
            int cntCS111 = 0;
            //Step 3: Read data from input file
            String inData = null;
            while ((inData = in.readLine()) != null) {
                String[] token = inData.split(";");
                /*
                token[0] = matrixNum;
                token[1] = studName;
                token[2] = program;
                token[3] = part;
                token[4] = gender;*/
                
                //Step 4: Tokenize the record into field / attributes
                /*StringTokenizer st = new StringTokenizer(inData,";");
                String matrixNum = st.nextToken();
                String studName = st.nextToken();
                String program = st.nextToken();
                String part = st.nextToken();
                String gender = st.nextToken();*/

                //Step 5: Manipulation
                if (token[2].equalsIgnoreCase("CS110") && token[4].equalsIgnoreCase("M")){
                    outCS110.printf("%-20s%-30s%-20s\n", token[0], token[1], token[3]);
                    cntCS110++;
                }

                if (token[2].equalsIgnoreCase("CS111") && token[4].equalsIgnoreCase("M")){
                    outCS111.printf("%-20s%-30s%-20s\n", token[0], token[1], token[3]);
                    cntCS111++;
                }
            }//end while
            outCS110.printf("%-20s\n","Number of male student for CS110: " + cntCS110);
            outCS111.printf("%-20s\n","Number of male student for CS111: " + cntCS111);

            //Step 6: Close All file
            in.close();
            outCS110.close();
            outCS111.close();
            
        }//end try (Step 7: End block try)
        //Step 8: Exception Handling (Catch Block)

        catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }

        catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        catch (Exception e){
            System.out.println("Problem: " + e.getMessage());
        }
    }//end main
}//end class
