import java.util.*;
import javax.swing.JOptionPane;

public class App{
    public static void main(String args[]){
        Scanner test = new Scanner(System.in);
        String result;
        result = JOptionPane.showInputDialog(null, "What is your name?");
        JOptionPane.showMessageDialog(null, "Hello " + result + "!");

        result = JOptionPane.showInputDialog(null, "Enter first number: ");
        int num1 = Integer.parseInt(result);
        
        result = JOptionPane.showInputDialog(null, "Enter second number: ");
        int num2 = Integer.parseInt(result);

        findSum(num1, num2);
    }
    static void findSum(int num1, int num2){
        int sum = num1 + num2;
        JOptionPane.showMessageDialog(null, "The sum is " + sum);
    }
}