package Pattern.BinaryTreeTraversal;

import java.util.Stack;

public class SecondSmallest {
    public int findSecondMinimumValue(Node root) {
        if (root == null) return -1;

        int rootVal = root.val;
        long secondMin = Long.MAX_VALUE;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.val > rootVal && node.val < secondMin) {
                secondMin = node.val;
            } else if (node.left != null && node.right != null) {
                stack.push(node.left);
                stack.push(node.right);
            }
        }

        return secondMin < Long.MAX_VALUE ? (int) secondMin : -1;
    }

    public static void main(String[] args){

        SecondSmallest s = new SecondSmallest();
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        System.out.println(s.findSecondMinimumValue(root));
    }
}
//leetCODE 671