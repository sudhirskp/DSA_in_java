package Jus;

import java.util.LinkedList;
import java.util.Queue;

//kind of this question coming in Juspay

public class MinDepth {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth =0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode node = que.poll();
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }

                if(node.left == null && node.right == null) return depth+1;
            }
            depth++;
        }
        return -1;
    }
    public static void main(String[] args) {

        MinDepth ob = new MinDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(ob.minDepth(root));

    }
}
//leet 111