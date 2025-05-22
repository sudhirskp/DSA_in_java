package Pattern.BinaryTreeTraversal;

import java.util.ArrayList;

public class KthSmallestInBST {
        public int kthSmallest1(Node root, int k) {
            int[] count = {0};
            int[] result = { -1 };
            inorder(root, k, count, result);
            return result[0];
        }

        private void inorder(Node node, int k, int[] count, int[] result) {
            if (node == null) return;
            inorder(node.left, k, count, result);
            count[0]++;
            if (count[0] == k) {
                result[0] = node.val;
                return;
            }
            inorder(node.right, k, count, result);
        }

        //----------------------------------------------------

    public int kthSmallest2(Node root, int k) {
        Node res = inOrder(root,k);
        return res.val;
    }
    int pos =0;
    public Node inOrder(Node node,int k){
        if(node == null) return node;
        Node left = inOrder(node.left,k);
        if(left!=null) return left;
        pos++;
        if(k==pos){
            return node;
        }
        return inOrder(node.right,k);
    }

    //---------------------------------------------------------------

    public int kthSmallest3(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list.get(k-1);
    }
    public void inorder (Node node , ArrayList<Integer> list){
        if(node == null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

    public static void main(String[] args) {
        KthSmallestInBST k = new KthSmallestInBST();
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.right = new Node(2);
        System.out.println(k.kthSmallest3(root, 1));
    }
}
//leetCode 230