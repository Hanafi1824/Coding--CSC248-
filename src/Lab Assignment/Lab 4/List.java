public class List{
    private ListNode firstNode; //reference to the first node in the list
    private ListNode lastNode; //reference to the last node in the list
    private ListNode currNode; //to traversal purpose
    private Object computer;
        
    public List(){
        this("list");
    }
        
    //construct an empty List with a name
    public List(Object serialNumber){
        computer = serialNumber;
        firstNode = lastNode = null;
    }

    public boolean isEmpty(){ return firstNode == null; }

    //insert Object at front of list
    public void insertAtFront(Object insertItem){  
        if(isEmpty()){
            firstNode = lastNode = new ListNode(insertItem);
        }else{ //firstnode refer to new node
            firstNode = new ListNode(insertItem, firstNode);
        }
    }

    public void insertAtBack(Object insertItem){
        //firstnode and lastnode refer to same object
        ListNode newNode = new ListNode(insertItem, null);
        if(this.lastNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
        }else{ //lastnode's nextnode refers to new node
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
        }
    }

    public void insertAtMiddle(Object insertItem){
        //firstnode and lastnode refer to same object
        if(isEmpty()){ // case 1
            firstNode = lastNode = new ListNode(insertItem);
        }
        else if(firstNode == lastNode){ // case 2 : only 1 node
            firstNode = new ListNode(insertItem, lastNode);
        }
        else if(firstNode.getNext() == lastNode){ // case 3 : only 2 mode
            firstNode.setNext(new ListNode(insertItem, lastNode));
        }
        else{ // case 4 : more than 2 nodes
            int count = 0;
            currNode = firstNode;

            while (currNode != null){
                count++;
                currNode = currNode.getNext();
            }
            int middle = count / 2;
            currNode = firstNode;
            for(int i = 0; i < middle; i++){
                currNode = currNode.getNext();
            }
            currNode.setNext(new ListNode(insertItem, currNode.getNext()));
        }
    }

    public Object remove(int serialNumber) {
        ListNode previousNode = null;
        ListNode currentNode = firstNode;
        
        // Traverse the list to find the node with the specified serial number
        while (currentNode != null && ((Computer) currentNode.getObject()).getSerialNo() != serialNumber) {
            previousNode = currentNode;
            // currentNode = currentNode.nextNode;
            currentNode = currentNode.getNext();
        }
        
        if (currentNode != null) {
            // Node with specified serial number is found, remove it
            if (previousNode == null) {
                // Node to be removed is the first node
                // firstNode = currentNode.nextNode;
                firstNode = currentNode.getNext();
                if (firstNode == null) {
                    // If the list becomes empty after removal, update lastNode
                    lastNode = null;
                }
            } else {
                // Node to be removed is not the first node
                // previousNode.nextNode = currentNode.nextNode;
                previousNode.setNext(currentNode.getNext());
                if (currentNode.getNext() == null) {
                    // If the node to be removed is the last node, update lastNode
                    lastNode = previousNode;
                }
            }
        
            return currentNode.getObject(); // Return the removed object
        } else {
                // Node with specified serial number not found
                return null;
        }
    }        
    public Object searchComputer(int serialNumber) {
        ListNode current = firstNode;

        while (current != null) {
            if (((Computer) current.getObject()).getSerialNo() == serialNumber) {
                return current.getObject();
            }
            current = current.getNext();
        }
        return null;
    }
    public int countComputer(double priceThreshold) {
        int count = 0;
            
        if (isEmpty()) {
            System.out.println("Empty list");
            return count;
        }
        System.out.println("Computers exceeding the price threshold of " + priceThreshold + ":");
            
        ListNode current = firstNode;
        
        while (current != null) {
            Computer computer = (Computer) current.getObject();
        
            if (computer.getPrice() > priceThreshold) {
                // Print brand code and year of buying for computers exceeding the price threshold
                System.out.println("Brand Code: " + computer.getBrand());
                System.out.println("Year of Buying: " + computer.getYear());
                System.out.println("--------");
        
                count++;
            }
            current = current.getNext();
        }
        
        System.out.println("Total computers exceeding the price threshold: " + count);
        return count;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Empty " + computer);
            return;
        }
        System.out.print("\nThe " + computer + " is: ");
        ListNode current = firstNode;
            
        // while not at end of list, output current node's data
        while(current != null){
            System.out.println(current.getObject().toString() + " ");
            // current = current.nextNode;
            current = current.getNext();
        }
        System.out.println("\n");
    }
}