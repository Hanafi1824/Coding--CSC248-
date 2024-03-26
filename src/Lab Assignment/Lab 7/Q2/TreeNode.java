public class TreeNode {
    TreeNode left;
    CCrimeComplaint info;
    TreeNode right;

    public TreeNode(CCrimeComplaint d) {
        info = d;
        left = right = null;
    }

    public void insert(CCrimeComplaint d){
        if(d.getNoOfComplaint() < info.getNoOfComplaint()|| 
        (d.getNoOfComplaint() == info.getNoOfComplaint() && d.getYear() < info.getYear())){
            if(left == null)
                left = new TreeNode(d);
            else
                left.insert(d);
        }
        else if (d.getNoOfComplaint() > info.getNoOfComplaint()|| 
        (d.getNoOfComplaint() == info.getNoOfComplaint() && d.getYear() > info.getYear())){
            if(right == null)
                right = new TreeNode(d);
            else
                right.insert(d); 
        }
    }
}
