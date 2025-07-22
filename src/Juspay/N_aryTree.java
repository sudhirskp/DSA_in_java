package Juspay;

import java.util.List;
//kind of this question coming in Juspay
public class N_aryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int max =0;
        for(Node node : root.children){
            int depth = maxDepth(node);
            max = Math.max(max,depth);
        }
        return max+1;
    }

    public static void main(String[] args) {
        N_aryTree ob = new N_aryTree();
        //add node elements
        System.out.println(ob.maxDepth(null));
    }
}
