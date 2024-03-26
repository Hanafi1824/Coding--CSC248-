public class ListNode {
    private Node first;
    private Node last;

    public ListNode(){
        first = last = null;
    }

    public boolean isEmpty(){ return first == null; }

    public synchronized void insertAtFront(Object insertItem){
        if (isEmpty()){
            first = last = new Node(insertItem);
        } 

        else 
            first = new Node(insertItem, first);
    }

    public synchronized void insertAtBack(Object insertItem){
        if (isEmpty()){
            first = last = new Node(insertItem);
        } 

        else 
            last = last.link = new Node(insertItem);
    }

    public synchronized Object removeFromFront(){
        Object rItem = null;
        if (isEmpty())
            return null;

        rItem = first.data;
        if(first.equals(last)){
            first = last = null;
        }

        else
            first = first.link;

        return rItem;
    }
    
    public synchronized Object removeAtBack(){
        Object rItem = null;
        if (isEmpty())
            return null;
        rItem = last.data;
        if(first.equals(last)){
            first = last = null;
        }
        else{
            Node current = first;
            while(current.link != last)
                current = current.link;
            last = current;
            last.link = null;
        }
        return rItem;
    }

    public Object getFirst(){
        Node curr = first;
        if (isEmpty()){
            return null;
        }

        else{
            curr = first;
            return curr.data;
        }
    }

    public Object getNext(){
        Node curr = first;
        if(curr != last){
            curr = curr.link;
            return curr.data;
        }
        else
            return null;
    }

    public synchronized void print(){
        if (isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("The list is: ");
        Node current = first;
        while(current != null){
            System.out.print(current.data.toString() + " ");
            current = current.link;
        }
        System.out.println();
    }
}