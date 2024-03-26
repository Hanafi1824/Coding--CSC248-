import java.util.Scanner;

class Node {
    int data;
    Node nextNode;
}

class LinkedList {
    Node first;

    LinkedList() {
        first = null;
    }

    public void push(int x) {
        Node newNode = new Node();
        newNode.data = x;
        newNode.nextNode = first;
        first = newNode;
    }

    public int pop() {
        if (first == null)
            return -1;
        else {
            int temp = first.data;
            first = first.nextNode;
            return temp;
        }
    }
}

public class LinkedListStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // LinkedListStack stack = new LinkedListStack();
        LinkedList stack = new LinkedList();

        System.out.print("Enter arithmetic expression: ");
        String arithmetic = sc.nextLine();
        String[] t = arithmetic.split(" ");

        for (int i = 0; i < t.length; i++) {
            if (t[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = a + b;
                stack.push(c);
            } else if (t[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = b - a;
                stack.push(c);
            } else if (t[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = a * b;
                stack.push(c);
            } else if (t[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = b / a;
                stack.push(c);
            } else
                stack.push(Integer.parseInt(t[i]));
        }

        System.out.println("Postfix after evaulated: " + stack.pop());
        sc.close();
    }
}