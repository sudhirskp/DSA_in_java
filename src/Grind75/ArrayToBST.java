package Grind75;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        TreeNode root = null;
        return Build(0,nums.length-1,nums);
    }

    private TreeNode Build(int l, int r, int [] nums){
        if(l > r) return null;

        int mid = l + (r - l)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = Build(l,mid-1,nums);
        node.right = Build(mid+1,r,nums);
        return node;
    }

    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        ArrayToBST ob = new ArrayToBST();
        int [] nums = {-10,-3,0,5,9};
        TreeNode root = ob.sortedArrayToBST(nums);
        ob.inorder(root);
    }
}

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/