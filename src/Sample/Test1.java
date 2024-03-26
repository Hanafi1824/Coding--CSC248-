import java.util.*;

public class Test1 {
    public static void main(String[] args){
        Scanner java = new Scanner (System.in);
        System.out.print("Enter the first number: ");
        int a = java.nextInt();

        System.out.println(a + "\t" + a);

        java.close();
    }
    
}