package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNext_II {

    //TC: O(N) | SC: O(1)
    public Node connect(Node root) {
        if(root==null) return root;

        Node cur = root;

        while(cur!=null){
            Node dummy = new Node(0);
            Node tail = dummy;

            while(cur!=null){

                if(cur.left!=null){
                    tail.next = cur.left;
                    tail = tail.next;
                }

                if(cur.right!=null){
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

    //TC: O(N) | SC: O(N)
    public Node connect1(Node root) {
        if(root==null) return root;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            Node pre = null;
            while(size-->0){
                Node node = que.poll();

                if(pre!=null){
                    pre.next = node;
                }
                pre = node;

                if(node.left!=null){
                    que.offer(node.left);
                }

                if(node.right!=null){
                    que.offer(node.right);
                }
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        PopulateNext_II obj = new PopulateNext_II();
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
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
//LeetCode 117