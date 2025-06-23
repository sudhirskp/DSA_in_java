package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    //Iterative inOrder traversal
    public List<Integer> InTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stk = new Stack<>();
        Node node = root;
        while (node != null || !stk.isEmpty()) {
           while(node!=null){
               stk.push(node);
               node = node.l;
           }
               node = stk.pop();
               list.add(node.val);
               node = node.r;
        }
        return list;
    }

    //Recursive inOrder traversal
    public List<Integer> InTraversalRecursive(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.addAll(InTraversalRecursive(root.l));
        list.add(root.val);
        list.addAll(InTraversalRecursive(root.r));
        return list;
    }

    public static void main(String[] args) {
        InOrder in = new InOrder();
        Node root = new Node(1);
        root.l = new Node(2);
        root.l.l = new Node(4);
        root.l.r = new Node(5);
        root.r = new Node(3);
        root.r.r = new Node(6);
        root.r.r.l = new Node(7);

        System.out.println(in.InTraversal(root));
    }
}
