package Grind75;

import java.util.LinkedList;
import java.util.Queue;

public class Serialization_de {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);

            while (!que.isEmpty()) {
                TreeNode node = que.poll();
                if (node == null) {
                    sb.append("-,");
                    continue;
                }

                sb.append(node.val).append(",");
                que.offer(node.left);
                que.offer(node.right);
            }
            //System.out.println(sb.toString());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==0 || data == "") return null;
            Queue<TreeNode> que = new LinkedList<>();
            String [] val = data.split(",");
            TreeNode  node = new TreeNode(Integer.parseInt(val[0]));
            que.offer(node);
            for(int i=1;i<val.length;i++){
                TreeNode parent = que.poll();
                if(!val[i].equals("-")){
                    TreeNode  left = new TreeNode(Integer.parseInt(val[i]));
                    parent.left = left;
                    que.offer(left);
                }
                if(!val[++i].equals("-")){
                    TreeNode  right = new TreeNode(Integer.parseInt(val[i]));
                    parent.right = right;
                    que.offer(right);
                }
            }
            return  node;
        }

    // Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

    public static void main(String[] args) {
        String data = "1,2,3,-,-,4,5,-,-,-,-";
        Serialization_de ser = new Serialization_de();
        TreeNode root = ser.deserialize(data);
        String serialized = ser.serialize(root);
        System.out.println(serialized);
    }
}
//leetCode 297
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
//hard
//time complexity : O(n)
//space complexity : O(n)