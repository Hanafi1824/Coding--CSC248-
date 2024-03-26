public class BSTCandidate {
    TreeNode root;
    
    public BSTCandidate(){ root = null; }

    public void insertCandidate(JobCandidate d){
        if (root == null)
            root = new TreeNode(d);
        else 
            root.insert(d);
    }

    //INORDER TRAVERSAL
    public void inorderTraversal(){
        inorderHelper(root);
    }

    public void inorderHelper(TreeNode root){
        if (root == null)
            return;
        inorderHelper(root.left);
        // inorderHelper(root.right);
        System.out.print(root.data + "");
        inorderHelper(root.right);
        // inorderHelper(root.left);
    }

    //POSTORDER TRAVERSAL
    public void postorderTraversal(){
        postorderHelper(root);
    }

    public void postorderHelper(TreeNode root){
        if (root == null)
            return;
        postorderHelper(root.left);
        postorderHelper(root.right);
        System.out.print(root.data + "");
    }

    public int countLeafNodes(){
        return cntLeaf(root);
    }

    public int cntLeaf(TreeNode root){
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1; //Leaf node
        else
            return cntLeaf(root.left) + cntLeaf(root.right);
    }

    public void displayDetails(){
        disDetails(root);
    }

    public void disDetails(TreeNode root){//descending
        if (root == null)
            return;
        // disDetails(root.left);
        disDetails(root.right);
        //casting
        JobCandidate j = root.data;
        System.out.println("RegNo: " + j.getRegNo());
        System.out.println("Name: " + j.getName());
        System.out.println("Qualification: " + j.getQualification());
        System.out.println("Age: " + j.getAge());
        System.out.println("Gender: " + j.getGender());
        System.out.println();
        disDetails(root.left);
        // disDetails(root.right);
    } 

    public int countCandidate(char q){
        return cntCand(root, q);
    }

    public int cntCand(TreeNode root, char q){
        if (root == null)
            return 0;

        // casting
        JobCandidate j = root.data;
        if (j.getQualification() == q)
            return 1 + cntCand(root.left, q) + cntCand(root.right, q);
        else
            return cntCand(root.left, q) + cntCand(root.right, q);
    }
}
