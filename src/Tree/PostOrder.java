package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    //Iterative postOrder traversal
    public List<Integer> PostTraversal(Node root) {

        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        Stack<Node> output = new Stack<>();
        if (root == null) {
            return list;
        }
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            output.push(node);
            if (node.l != null) stk.push(node.l);
            if (node.r != null) stk.push(node.r);
        }
        while (!output.isEmpty()) {
            list.add(output.pop().val);
        }
        return list;
    }

    //by using One Stack
    public List<Integer> PostTraversalOneStack(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        if (root == null) return list;
        Node node = root;
        while (!stk.isEmpty() || node != null) {
            while (node != null) {
                stk.push(node);
                node = node.l;
            }
            if(stk.peek().r!=null){
                node = stk.peek().r;
            }else{
                Node Temp =  stk.pop();
                list.add(Temp.val);
                while(!stk.isEmpty() && Temp == stk.peek().r){
                    Temp = stk.pop();
                    list.add(Temp.val);
                }
            }
    }
        return list;
}

    //Recursive postOrder traversal
    public List<Integer> PostTraversalRecursive(Node root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        list.addAll(PostTraversalRecursive(root.l));
        list.addAll(PostTraversalRecursive(root.r));
        list.add(root.val);
        return list;
    }
    public static void main(String[] args) {

        PostOrder post = new PostOrder();
        Node root = new Node(1);
        root.l = new Node(2);
        root.l.l = new Node(4);
        root.l.r = new Node(5);
        root.r = new Node(3);
        root.r.r = new Node(6);
        root.r.r.l = new Node(7);

        System.out.println(post.PostTraversalRecursive(root));
        //System.out.println(post.PostTraversal(root));
        //System.out.println(post.PostTraversalOneStack(root));
    }
}
