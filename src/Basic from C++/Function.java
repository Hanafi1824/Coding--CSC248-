import java.util.*;

public class Function{
    public static void main(String args[]){
        findSum();
    }
    static void findSum(){
        Scanner test = new Scanner(System.in);
        int num1, num2;

        System.out.print("Enter first number: ");
        num1 = test.nextInt();
        
        System.out.print("Enter second number: ");
        num2 = test.nextInt();

        
        int sum = num1 + num2;
        System.out.print("The sum is " + sum);
    }
}