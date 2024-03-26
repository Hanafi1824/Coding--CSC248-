public class QUEUE extends ListNode{
    public QUEUE(){
        super();
    }
    
    public void enqueue(Object elem){
        insertAtBack(elem);
    }

    public Object dequeue(){
        return removeFromFront();
    }

    public Object getFirst(){
        return getFirst();
    }

    public Object getNext(){
        return getNext();
    }
}
