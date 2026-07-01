package Tree.BinaryTree;

public class Node {
    int data;
    Node left;
    Node right;
    Node next;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        data = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
