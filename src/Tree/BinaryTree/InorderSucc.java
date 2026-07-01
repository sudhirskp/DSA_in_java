package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderSucc {

    public int inOrderSuccessor(Node root, Node k) {
        // code here

        Node succ = null;

        while(root!=null){

            if(root.data>k.data){
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }

        return succ == null ? -1 : succ.data;
    }

    int ans = -1;
    Node pre = null;
    public int inOrderSuccessor1(Node root, Node k) {
        // code here
        find(root,k);
        return ans;
    }

    private void find(Node root, Node k){
        if(root==null || ans != -1) return;

        find(root.left,k);

        if(ans!=-1) return;

        int cur = root.data;

        if(pre == k){
            ans = cur;
            return;
        }
        pre = root;

        find(root.right,k);

    }
    public static void main(String[] args) {
        InorderSucc obj = new InorderSucc();
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        Node k = root;
        System.out.println(obj.inOrderSuccessor(root, k));
        System.out.println(obj.inOrderSuccessor1(root, k));
    }
}
//https://www.geeksforgeeks.org/inorder-successor-in-bst/