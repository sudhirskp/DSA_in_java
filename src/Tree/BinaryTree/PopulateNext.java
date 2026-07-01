package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PopulateNext {

    //Time: O(N) | Space: O(1)
    public Node connect(Node root) {
        if(root==null) return root;

        Node leftmost = root;

        while(leftmost.left!=null){
            Node cur = leftmost;

            while(cur!=null){
                cur.left.next = cur.right;

                if(cur.next!=null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    //Time: O(N) | Space: O(h) where h is height of tree
    public Node connect1(Node root) {
        if(root==null) return root;

        if(root.left!=null){
            root.left.next = root.right;

            if(root.next!=null){
                root.right.next = root.next.left;
            }
        }
        connect1(root.left);
        connect1(root.right);
        return root;
    }


    public static void main(String[] args) {
        PopulateNext obj = new PopulateNext();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node res = obj.connect(root);
        Node res1 = obj.connect1(root);
    }
}
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//leetcode 116