package Pattern.DFS;


import com.sun.source.tree.Tree;

public class PathSum {

    class TreeNode {
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(){
            this.val = 0;
            this.left = null;
            this.right = null;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null ) return false;

        if(root.left == null && root.right==null){
            if(targetSum == root.val) return true;
        }

        int rem = targetSum - root.val;
        return hasPathSum(root.left,rem) || hasPathSum(root.right,rem);
    }
    public static void main(String[] args) {
        PathSum ob = new PathSum();
        TreeNode root = ob.new TreeNode();
        root.val = 5;
        root.left = ob.new TreeNode();
        root.left.val = 4;
        root.right = ob.new TreeNode();
        root.right.val = 8;
        root.left.left = ob.new TreeNode();
        root.left.left.val = 11;
        root.left.left.left = ob.new TreeNode();
        root.left.left.left.val = 7;
        root.left.left.right = ob.new TreeNode();
        root.left.left.right.val = 2;
        root.right.right = ob.new TreeNode();
        root.right.right.val = 4;
        System.out.println(ob.hasPathSum(root,22));
    }
}
//leet 112
