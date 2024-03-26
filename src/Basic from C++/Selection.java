import java.util.*;

public class Selection {
    public static void main(String[] args) {
      int n1, n2, sum;
      Scanner bruh =  new Scanner (System.in);

      System.out.print("Enter name: ");
      String name = bruh.next();
      System.out.println("Hi " + (name));

      System.out.print("Enter first number: ");
      n1 = bruh.nextInt();
      
      System.out.print("Enter second number: ");
      n2 = bruh.nextInt();

      if (n1 % 2 == 0){
        System.out.println("The first number is even");
      }
      else{
        System.out.println("The first number is odd");
      }

      sum = n1 + n2;
      System.out.print("The sum is " + (sum));
    }
  }