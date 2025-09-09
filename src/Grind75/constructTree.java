package Grind75;

import java.util.HashMap;

public class constructTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        HashMap<Integer,Integer> map;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            for(int i =0;i<inorder.length;i++){
                map.put(inorder[i],i);
            }

            return construct(0,inorder.length-1,preorder,inorder);
        }

        int preindex = 0;
        public TreeNode construct(int l,int r,int [] preorder,int [] inorder){
            if(l>r) return null;
            if(preindex>=inorder.length) return null;
            int root_val = preorder[preindex];
            preindex++;

            TreeNode root = new TreeNode(root_val);

            int in_index = map.get(root_val);

            root.left = construct(l,in_index-1,preorder,inorder);
            root.right = construct(in_index+1,r,preorder,inorder);

            return root;
        }

    public void Inorder(TreeNode root){
        if(root==null) return;
        Inorder(root.left);
        System.out.print(root.val+" ");
        Inorder(root.right);
    }


    public static void main(String[] args) {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        constructTree ct = new constructTree();
        TreeNode root = ct.buildTree(preorder,inorder);
        ct.Inorder(root);
    }
}

//leetCode 105
// link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// time : O(n)
// space : O(n)
