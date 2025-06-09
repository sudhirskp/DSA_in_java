package Pattern.BinaryTreeTraversal;

public class BnTreeMaxPathSum {
    public int maxPathSum(Node root) {
        int [] max = new int [1];
        max[0] = Integer.MIN_VALUE;
        maxPath(root,max);
        return max[0];
    }

    private int maxPath(Node node , int[]max){
        if(node==null) return 0;
        int l = Math.max(0,maxPath(node.left,max));
        int r = Math.max(0,maxPath(node.right,max));
        max[0] = Math.max(max[0],l+r+node.val);
        return Math.max(l,r)+node.val;
    }
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        BnTreeMaxPathSum obj = new BnTreeMaxPathSum();
        System.out.println(obj.maxPathSum(root)); // output: 42
    }
}
//leetcode 124


//In Java, primitive types (like int) are passed by value, meaning that
//    if we passed max as an int, modifications inside the recursive function wouldn’t persist outside of that specific call.
//        However, arrays (and objects) are passed by reference,
//allowing the changes to max[0] inside maxPath() to be reflected in all recursive calls
