public class bookRecord {
    private TreeNode root;

    public bookRecord(){ root = null; } // constructor

    public void insertBook(Object d){
        if (root == null)
            root = new TreeNode(d);
        else 
            root.insert(d);
    }

    public void countBookCode(){
        System.out.println("Number of Books with code A: " + cntBookCode(root, 'A'));
        System.out.println("Number of Books with code B: " + cntBookCode(root, 'B'));
        System.out.println("Number of Books with code C: " + cntBookCode(root, 'C'));
        System.out.println("Number of Books with code D: " + cntBookCode(root, 'D'));
        System.out.println("Number of Books with code E: " + cntBookCode(root, 'E'));
    }

    public int cntBookCode(TreeNode root, char code){
        if (root == null)
            return 0;

        // casting
        Book b = (Book) root.data;
        if (b.getCode() == code)
            return 1 + cntBookCode(root.left, code) + cntBookCode(root.right, code);
        else
            return cntBookCode(root.left, code) + cntBookCode(root.right, code);
    }

    public void searchBook(int serialNum){
        schBook(root, serialNum);
    }

    public void schBook(TreeNode root, int serialNum){
        if (root == null)
            return;

        // casting
        Book b = (Book) root.data;
        if (b.getSerialNum() == serialNum){
            System.out.println("Book Information: ");
            System.out.println("Serial Number: " + b.getSerialNum());
            System.out.println("Title: " + b.getTitle());
            System.out.println("Author: " + b.getAuthor());
            System.out.println("Code: " + b.getCode());
            System.out.println("Publisher: " + b.getPublisher());
            System.out.println("Year: " + b.getYear());
        }
        schBook(root.left, serialNum);     
        schBook(root.right, serialNum);       
    }

    public void displayAll(){
        disAll(root);
    }

    public void disAll(TreeNode root){
        if (root == null)
            return;
        disAll(root.left);
        //casting
        Book b = (Book) root.data;
        System.out.println("Serial Number: " + b.getSerialNum());
        System.out.println("Title: " + b.getTitle());
        System.out.println("Author: " + b.getAuthor());
        System.out.println("Code: " + b.getCode());
        System.out.println("Publisher: " + b.getPublisher());
        System.out.println("Year: " + b.getYear());
        System.out.println();
        disAll(root.right);
    }
}
