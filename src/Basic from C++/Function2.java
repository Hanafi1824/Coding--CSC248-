import java.util.*;
public class Function2 {
    static void Calc(int num1, int num2) {
      int sum = num1 - num2;
      System.out.println("Sum is " + sum);

    }
  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      int num1, num2;
      System.out.print("Enter first number: ");
      num1 = scan.nextInt();
      
      System.out.print("Enter second number: ");
      num2 = scan.nextInt();

      Calc(num1, num2);
    }
  }