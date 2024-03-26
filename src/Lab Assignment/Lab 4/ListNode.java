public class ListNode {
    private Object obj;
    private ListNode nextNode;

    // create a ListNode that refers to object
    ListNode(Object object) {
        this(object, null);
    }

    // create a ListNode that refers to object and to next
    // ListNode
    ListNode(Object object, ListNode node) {
        obj = object;
        nextNode = node;
    }

    // return reference to data in node
    Object getObject() {
        return obj;
    } // return object in this node

    void setObject(Object object) {
        this.obj = object;
    }

    // return refernce to next node in list
    ListNode getNext() {
        return nextNode;
    } // get next node

    void setNext(ListNode next) {
        this.nextNode = next;
    }

    public String toString() {
        return this.obj.toString();
    }
}