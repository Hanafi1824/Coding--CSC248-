import java.util.LinkedList;
public class Queue extends LinkedList{
    protected LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(Object element){
        list.addLast(element);
    }

    public Object dequeue(){
        return list.removeFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
