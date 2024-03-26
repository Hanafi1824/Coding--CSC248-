import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Node {
    Object data;
    Node next;
    // create a ListNode that refers to object
    Node(Object object) {
        this(object, null);
    }

    // create a ListNode that refers to object and to next
    // ListNode
    Node(Object d, Node n) {
        data = d;
        next = n;
    }

    // return reference to data in node
    Object getObject() {
        return data;
    } // return object in this node

    void setObject(Object object) {
        this.data = object;
    }

    // return refernce to next node in list
    Node getNext() {
        return next;
    } // get next node

    void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return this.data.toString();
    }
}

public class List{
    private Node first; //reference to the first node in the list
    private Node last; //reference to the last node in the list
    private Node curr; //to traversal purpose
    private Object Staff;
        
    public List(){
        this("list");
    }
        
    //construct an empty List with a name
    public List(Object serialNumber){
        Staff = serialNumber;
        first = last = null;
    }

    public boolean isEmpty(){ return first == null; }

    //insert Object at front of list
    public void insertAtFront(Object insertItem){  
        if(isEmpty()){
            first = last = new Node(insertItem);
        }else{ //firstnode refer to new node
            first = new Node(insertItem, first);
        }
    }

    public void insertAtBack(Object insertItem){
        //firstnode and lastnode refer to same object
        Node newNode = new Node(insertItem, null);
        if(this.last == null){
            this.first = newNode;
            this.last = newNode;
        }else{ //lastnode's nextnode refers to new node
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }

    public void insertAtMiddle(Object insertItem){
        //firstnode and lastnode refer to same object
        if(isEmpty()){ // case 1
            first = last = new Node(insertItem);
        }
        else if(first == last){ // case 2 : only 1 node
            first = new Node(insertItem, last);
        }
        else if(first.getNext() == last){ // case 3 : only 2 mode
            first.setNext(new Node(insertItem, last));
        }
        else{ // case 4 : more than 2 nodes
            int count = 0;
            curr = first;

            while (curr != null){
                count++;
                curr = curr.getNext();
            }
            int middle = count / 2;
            curr = first;
            for(int i = 0; i < middle; i++){
                curr = curr.getNext();
            }
            curr.setNext(new Node(insertItem, curr.getNext()));
        }
    }

    public Object remove(String staffID) {
        Node previousNode = null;
        Node currentNode = first;
        
        // Traverse the list to find the node with the specified serial number
        while (currentNode != null && !(((Staff) currentNode.getObject()).getStaffID().equalsIgnoreCase(staffID))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        
        if (currentNode != null) {
            // Node with specified serial number is found, remove it
            if (previousNode == null) {
                // Node to be removed is the first node
                first = currentNode.getNext();
                if (first == null) {
                    // If the list becomes empty after removal, update lastNode
                    last = null;
                }
            } else {
                // Node to be removed is not the first node
                previousNode.setNext(currentNode.getNext());
                if (currentNode.getNext() == null) {
                    // If the node to be removed is the last node, update lastNode
                    last = previousNode;
                }
            }
        
            return currentNode.getObject(); // Return the removed object
        } else {
                // Node with specified serial number not found
                return null;
        }
    }        
    public Object searchStaff(String staffID) {
        String word = "";
        Node current = first;

        while (current != null) {
            Staff staff = (Staff) current.getObject();
            if (((Staff) current.getObject()).getStaffID().equalsIgnoreCase(staffID)) {
                return "Staff ID: " + staff.getStaffID() +
                "\nStaff name: " + staff.getStaffName() +
                "\nContact Number: " + staff.getContactNo() +
                "\nStatus: " + staff.printStatus() +
                "\nPosition: " + staff.printPosition() +
                "\nState: " + staff.getAddress() +
                "\nSalary: RM " + staff.getSalary();
            }
            current = current.getNext();
        }

        if (current == null)
            word = "Record not found!";
        return word;
    }
    public int countCurrentStaff() { //count total current staff
        int count = 0;
            
        if (isEmpty()) {
            System.out.println("Empty list");
            return count;
        }            
        Node current = first;
        
        while (current != null) {
            Staff s = (Staff) current.getObject();
        
            if (s.getStaffID() != null) {
                count++;
            }
            current = current.getNext();
        }        
        return count;
    }

    public int countStaffPosition(String word) {
        int count = 0;
    
        if (isEmpty()) {
            System.out.println("Empty list");
            return count;
        }
    
        Node current = first;
    
        while (current != null) {
            Staff s = (Staff) current.getObject();
            char positionChar = s.getPosition();
            String positionWord = convertPositionCharToString(positionChar);
    
            if (positionWord.equalsIgnoreCase(word)) {
                count++;
            }
            current = current.getNext();
        }
    
        return count;
    }
    
    // Helper method to convert position char to string
    private String convertPositionCharToString(char positionChar) {
        switch (positionChar) {
            case 'A':
                return "Assistant";
            case 'H':
                return "Chef";
            case 'C':
                return "Cashier";
            case 'L':
                return "Cleaner";
            case 'B':
                return "Barista";
            case 'M':
                return "Manager";
            case 'W':
                return "Waiter";
            default:
                return "Unknown";
        }
    }
    

    public int countStaffStatus(char s) { //count total related staff status
        int count = 0;
            
        if (isEmpty()) {
            System.out.println("Empty list");
            return count;
        }            
        Node current = first;
        
        while (current != null) {
            Staff st = (Staff) current.getObject();
        
            if (st.getStaffStatus() == s) {
                count++;
            }
            current = current.getNext();
        }        
        return count;
    }

    public Object updateStaff(String staffID, int fieldToUpdate, Object update) {
        if (isEmpty()) {
            System.out.println("Empty " + Staff);
            return null;
        }
    
        Node current = first;
        
        while (current != null) {
            Staff st = (Staff) current.getObject();
            if (st.getStaffID().equals(staffID)) {
                // Found the staff with the given ID, update the specified field based on the option
                switch (fieldToUpdate) {
                    case 1:
                        st.setStaffName((String) update);
                        break;
                    case 2:
                        st.setContactNo((String) update);
                        break;
                    case 3:
                        st.setStaffStatus((char) update);
                        break;
                    case 4:
                        st.setPosition((char) update);
                        break;
                    case 5:
                        st.setAddress((String) update);
                        break;
                    case 6:
                        st.setSalary((int) update);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                return current.getObject(); // Return the updated staff object
            }
            current = current.getNext();
        }
        return null;
    }
    
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty " + Staff);
            return;
        }
        Node current = first;
        // while not at the end of the list, output the current node's data
        while (current != null) {
            Staff staff = (Staff) current.getObject();

            System.out.println("Staff ID: " + staff.getStaffID() + "\nStaff name: " + staff.getStaffName() +
                    "\nContact Number: " + staff.getContactNo() + "\nStatus: " + staff.printStatus() +
                    "\nPosition: " + staff.printPosition() + "\nState: " + staff.getAddress() +
                    "\nSalary: RM " + staff.getSalary());

            current = current.getNext();
        }
    }

    public void print2() {
        if (isEmpty()) {
            System.out.println("Empty " + Staff);
            return;
        }
        Node current = first;
        // while not at the end of the list, output the current node's data
        while (current != null) {
            Staff staff = (Staff) current.getObject();
            System.out.println(staff.toString());

            current = current.getNext();
        }
    }

    public void saveToFile(String fileName) { //using append
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            Node current = first;

            while (current != null) {
                writer.newLine();
                writer.write(current.getObject().toString());
                
                current = current.getNext();
            }

            System.out.println("\nData saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void saveToFile2(String fileName) { // using overwrite
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            Node current = first;
            StringBuilder content = new StringBuilder();
    
            while (current != null) {
                content.append(current.getObject().toString()).append("\n");
                current = current.getNext();
            }
    
            writer.print(content.toString().trim()); // trim to remove trailing whitespace
            System.out.println("\nData saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }


    //QUEUE IMPLEMENTATION:
    public Object removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        Object removed = first.data;
        if (first == last)
            first = last = null;
        else
            first = first.next;

        return removed;
    }
    public Object removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        Object removed = last.data;
        if (first == last)
            first = last = null;
        else {
            curr = first;
            while (curr.next != last)
                curr = curr.next;
            last = curr;
            curr.next = null;
        }
        return removed;
    }
    public Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            curr = first;
            return curr.data;
        }
    }
}

class Queue extends List {
    public Queue() {}
    public void enqueue(Object x) { insertAtBack(x); }
    public Object dequeue() { return removeFromFront(); }
    public Object getFront() { return getFirst(); }
    public Object getEnd() {
        Object o = removeFromBack();
        insertAtBack(o);
        return o;
    }
}