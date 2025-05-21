package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    //Iterative preOrder traversal
    public List<Integer> PreTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        if(root== null) return list;
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            Node node = stk.pop();
            list.add(node.val);

            // Push right child first so that left child is processed first
            if(node.r!=null){
                stk.push(node.r);
            }

            if(node.l!=null){
                stk.push(node.l);
            }
        }
        return list;
    }

    //Recursive preOrder traversal
    public List<Integer> PreTraversalRec(Node root){
        List<Integer> list = new ArrayList<>();
        if(root== null) return list;
        list.add(root.val);
        list.addAll(PreTraversalRec(root.l));
        list.addAll(PreTraversalRec(root.r));
        return list;
    }

    public static void main(String[] args) {
        InOrder pre = new InOrder();
        Node root = new Node(1);
        root.l = new Node(2);
        root.l.l = new Node(4);
        root.l.r = new Node(5);
        root.r = new Node(3);
        root.r.r = new Node (6);
        root.r.r.l = new Node(7);

        System.out.println(pre.InTraversal(root));
    }
}
