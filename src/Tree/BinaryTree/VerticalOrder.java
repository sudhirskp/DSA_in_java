package Tree.BinaryTree;

import java.util.*;

public class VerticalOrder {

    class NNode{
        Node node;
        int hd;
        int depth;
        NNode(Node node, int hd, int depth){
            this.node = node;
            this.hd = hd;
            this.depth = depth;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<NNode> que = new LinkedList<>();
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();

        que.offer(new NNode(root,0,0));

        while(!que.isEmpty()){
            int size = que.size();
            while(size-->0){

                NNode no = que.poll();

                if(!map.containsKey(no.hd)){
                    map.put(no.hd,new ArrayList<>());
                }
                map.get(no.hd).add(new int []{no.node.data,no.depth});

                if(no.node.left!=null){
                    que.offer(new NNode(no.node.left,no.hd-1, no.depth+1));
                }

                if(no.node.right!=null){
                    que.offer(new NNode(no.node.right,no.hd+1,no.depth+1));
                }
            }
        }
        //System.out.print(map);
        for(List<int[]> ls : map.values()){

            ls.sort((a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);

            List<Integer> col = new ArrayList<>();
            for (int[] pair : ls) {
                col.add(pair[0]);
            }
            res.add(col);
        }
        return res;
    }

    public static void main(String[] args) {
        VerticalOrder ob = new VerticalOrder();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
//        root.right.left.left = new Node(8);
//        root.right.left.right = new Node(9);

        List<List<Integer>> res = ob.verticalTraversal(root);

        for(List<Integer> col : res){
            System.out.print("[");
            for(int i : col){
                System.out.print(i+" ");
            }
            System.out.print("] ");
        }
    }
}
//https://www.geeksforgeeks.org/vertical-order-traversal-of-a-binary-tree/
//LeetCode 987