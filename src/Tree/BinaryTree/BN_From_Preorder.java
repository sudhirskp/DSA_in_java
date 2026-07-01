package Tree.BinaryTree;

public class BN_From_Preorder {

    int i = 0;
    public Node bstFromPreorder(int[] preorder) {
        return build(preorder,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private Node build(int [] pre, long min, long max){
        if(i==pre.length){
            return null;
        }

        int v = pre[i];

        if(v<min || v>max) return null;

        i++;

        Node node = new Node(v);

        node.left = build(pre,min,v);
        node.right = build(pre,v,max);

        return node;
    }

    public static void main(String[] args) {
        BN_From_Preorder obj = new BN_From_Preorder();
        int [] pre = {8,5,1,7,6,3,0,2};
        Node root = obj.bstFromPreorder(pre);

    }
}
//https://leetcode.com/problems/construct-bst-from-preorder-traversal/
//LeetCode 1008