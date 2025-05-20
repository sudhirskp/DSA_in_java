package Pattern.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class  Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Node {
     int val;
      Node left;
      Node right;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class BNTreePath {
    public List<String> binaryTreePaths(Node root) {
        Stack<Pair<Node, String>> stk = new Stack<>();
        List<String> list = new ArrayList<>();
        stk.push(new Pair(root , Integer.toString(root.val)));

        while(!stk.isEmpty()){
            Pair<Node, String> current = stk.pop();
            Node node = current.getKey();
            String path = current.getValue();
            if(node.left==null && node.right==null){
                list.add(path);
            }

            if(node.left!=null){
                stk.push(new Pair(node.left , path + "->" + node.left.val));
            }

            if(node.right!=null){
                stk.push(new Pair(node.right , path + "->" + node.right.val));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        BNTreePath b = new BNTreePath();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        List<String> list = b.binaryTreePaths(root);
        for(String s : list){
            System.out.println(s);
        }
    }
}

//leetcode 257