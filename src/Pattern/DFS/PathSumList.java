package Pattern.DFS;

import java.util.ArrayList;
import java.util.List;


public class PathSumList {

   static class Node {
        int val;
        Node left;
        Node right;

        Node() {
            this.val = 0;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(Node node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.val == targetSum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath));
        }

        findPaths(node.left, targetSum - node.val, currentPath, result);
        findPaths(node.right, targetSum - node.val, currentPath, result);

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        PathSumList ob = new PathSumList();
        Node root = new Node();
        root.val = 5;
        root.left = new Node();
        root.left.val = 4;
        root.right = new Node();
        root.right.val = 8;
        root.left.left = new Node();
        root.left.left.val = 11;
        root.left.left.left = new Node();
        root.left.left.left.val = 7;
        root.left.left.right = new Node();
        root.left.left.right.val = 2;
        root.right.right = new Node();
        root.right.right.val = 4;
        root.right.left = new Node();
        root.right.left.val = 13;
        root.right.right.left = new Node();
        root.right.right.left.val = 5;
        root.right.right.right = new Node();
        root.right.right.right.val = 1;

        System.out.println(ob.pathSum(root, 22));
    }
}

//leet 113
