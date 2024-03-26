public class BSTCrimeComplaint{
    TreeNode root;
    public BSTCrimeComplaint(){ //constructor
        root = null;
    }

    public void insertNode (CCrimeComplaint d){
        if (root == null)
            root = new TreeNode(d);
        else 
            root.insert(d);
    }

    public void cElementDisplayAll(){
        cElementDisAll(root);
    }

    public void cElementDisAll(TreeNode root){
        if (root == null)
            return;
        cElementDisAll(root.left);
        //casting
        CCrimeComplaint c = root.info;
        System.out.println("Complaint Element: " + c.getCElement());
        System.out.println("Year: " + c.getYear());
        System.out.println("Total Number of Complaint: " + c.getNoOfComplaint());
        System.out.println();
        cElementDisAll(root.right);
    }

    public void displayBySpesific(String finding){
        disBySpesific(root, finding);
    }

    public void disBySpesific(TreeNode root, String finding){
        if (root == null)
            return;

        // casting
        CCrimeComplaint c = root.info;
        if (c.getCElement().equalsIgnoreCase(finding)){
            System.out.println("Complaint Element: " + c.getCElement());
            System.out.println("Year: " + c.getYear());
            System.out.println("Total Number of Complaint: " + c.getNoOfComplaint());
        }
        disBySpesific(root.left, finding);     
        disBySpesific(root.right, finding); 
    }

    public int calTotComplaint(int y){
        return calTotCom(root, y);
    }

    public int calTotCom(TreeNode root, int y){
        if (root == null)
            return 0;

        // casting
        CCrimeComplaint c = root.info;
        if (c.getYear() == y)
            return 1 + calTotCom(root.left, y) + calTotCom(root.right, y);
        else
            return calTotCom(root.left, y) + calTotCom(root.right, y);
    }
}
