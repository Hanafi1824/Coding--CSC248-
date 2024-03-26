public class TreeNode {
    TreeNode left;
    JobCandidate data;
    TreeNode right;

    public TreeNode(JobCandidate d){
        data = d;
        left = right = null;
    }

    public void insert(JobCandidate d){
        if(d.getRegNo() < data.getRegNo()){
            if(left == null)
                left = new TreeNode(d);
            else
                left.insert(d);
        }
        else if(d.getRegNo() > data.getRegNo()){
            if(right == null)
                right = new TreeNode(d);
            else
                right.insert(d);
        }
    }
}
