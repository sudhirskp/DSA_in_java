package Tree.BinaryTree;

public class ChildSum {

    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;

        int leftchild  =  root.left==null ? 0 : root.left.data;
        int rightchild = root.right==null ? 0 : root.right.data;

        return (root.data == leftchild+rightchild) ? isSumProperty(root.left) && isSumProperty(root.right) : false;
    }

    public static void main(String[] args) {
        ChildSum obj = new ChildSum();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(obj.isSumProperty(root));
    }
}
//https://www.geeksforgeeks.org/problems/children-sum-parent/1