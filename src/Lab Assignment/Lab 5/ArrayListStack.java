import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListStack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Character> stack = new ArrayList<>();

        // Get the decimal number from the user
        System.out.print("Enter a decimal number: ");
        int dNum = s.nextInt();
        char hexDigit;

        while (dNum > 0) {
            int remainder = dNum % 16;
            if (remainder >= 0 && remainder <= 9) {
                hexDigit = (char) ('0' + remainder);
            } else {
                hexDigit = (char) ('A' + remainder - 10);
            }
            stack.add(hexDigit);
            dNum /= 16;
        }

        // Construct the hexadecimal
        String hexaDecimal = "";
        while (!stack.isEmpty()) {
            hexaDecimal += stack.remove(stack.size() - 1);
        }

        System.out.println("Hexadecimal number: " + hexaDecimal);
        s.close();
    }
}
