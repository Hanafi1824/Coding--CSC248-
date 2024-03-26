public class TreeNode{ //generic class
    TreeNode left; //left node
    Object data; //data item
    TreeNode right; //right node

    public TreeNode(Object d){
        data = d;
        left = right = null; //this node has no children
    }

    public void insert(Object d){
        //casting
        Book b = (Book) d;
        Book dat = (Book) data;

        if(b.getSerialNum() < dat.getSerialNum()){
            if(left == null)
                left = new TreeNode(b);
            else
                left.insert(b);
        }
        else if (b.getSerialNum() > dat.getSerialNum()){
            if(right == null)
                right = new TreeNode(b);
            else
                right.insert(b); 
        }
    }
}
