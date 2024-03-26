public class Node {
    public Object data;
    public Node link;

    Node(Object object){
        this(object, null);
    }

    Node(Object d, Node n){
        data = d;
        link = n;
    }

    Object getObject(){ return data; }
    Node getNext(){ return link; }
}
