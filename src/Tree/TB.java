package Tree;

class Node {
    int val;
    Node l;
    Node r;

    Node(int val) {
        this.val = val;
        this.l = null;
        this.r = null;
    }
}

public class TB {
    void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.l);
        System.out.print(" "+root.val);
        Inorder(root.r);
    }

    public static void main(String[] args) {
        TB ob = new TB();
        Node root = new Node(1);
        root.l = new Node(2);
        root.r = new Node(3);
        root.l.l = new Node(4);
        root.r.l = new Node(6);
        root.r.r = new Node(7);
        root.r.l.l = new Node(8);
        root.r.l.r = new Node(9);

        // Call the Inorder method
        ob.Inorder(root);
    }
}
