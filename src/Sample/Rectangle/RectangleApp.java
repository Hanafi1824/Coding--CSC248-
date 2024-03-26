import java.util.*;
public class RectangleApp{
    public static void main(String[] args){
        Rectangle obj1 = new Rectangle();//declare & create an object
        System.out.println("The initial value of length is: " + obj1.getLength());

        //Accessor - is a method used to access the attributes
        Scanner x = new Scanner(System.in);
        System.out.print("Enter the length: ");
        int value = x.nextInt();
        obj1.setLength(value);
        System.out.print("The new value of length is: " + obj1.getLength());

        //processor 
        System.out.print(obj1.findArea());
    }
}