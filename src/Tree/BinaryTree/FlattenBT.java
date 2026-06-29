package Tree.BinaryTree;

public class FlattenBT {

    Node pre;
    public void flatten1(Node root) {
        if(root==null) return;


        flatten1(root.right);
        flatten1(root.left);

        root.right = pre;
        root.left = null;
        pre=root;

    }

    public void flatten(Node root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);

        Node temp = root.right;

        root.right = root.left;
        root.left = null;

        Node cur = root;

        while(cur.right != null){
            cur = cur.right;
        }

        cur.right = temp;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        FlattenBT ob = new FlattenBT();
        ob.flatten(root);

        ob.printTree(root);
    }

    public void printTree(Node root){
        if(root==null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
}
//LeetCode 114