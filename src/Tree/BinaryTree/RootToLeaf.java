package Tree.BinaryTree;


import java.util.ArrayList;

public class RootToLeaf {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root,path,res);
        return res;
    }

    private void dfs(Node node, ArrayList<Integer>path, ArrayList<ArrayList<Integer>>res){
        if(node==null) return;

        path.add(node.data);

        if(node.left==null && node.right==null){
            res.add(new ArrayList<>(path));
        }else {

            dfs(node.left,path,res);
            dfs(node.right,path,res);
        }

        path.remove(path.size()-1); //backtrack
    }

    public static void main(String[] args) {
        RootToLeaf obj = new RootToLeaf();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(obj.Paths(root));
    }
}
//https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
