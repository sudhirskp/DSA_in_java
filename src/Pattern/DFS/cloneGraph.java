package Pattern.DFS;


import java.util.*;

// Definition for a Node.
 class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//by using BFS
public class cloneGraph {

    public Node cloneGraph(Node node) {
        if(node==null) return node;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();
        map.put(node,new Node(node.val ,new ArrayList<>()));
        que.offer(node);
        while(!que.isEmpty()){
            Node nod = que.poll();
            for(Node neigh : nod.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh,new Node(neigh.val,new ArrayList<>()));
                    que.offer(neigh);
                }
                map.get(nod).neighbors.add(map.get(neigh));
            }
        }
        return map.get(node);
    }

    //by using DFS
    public Node cloneGraph2(Node node) {
        if(node==null) return node;
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,map);
        return map.get(node);
    }
    public void dfs(Node node, HashMap<Node,Node> map){
        if(map.containsKey(node)) return;
        map.put(node, new Node(node.val, new ArrayList<>()));
        for(Node neigh : node.neighbors){
            dfs(neigh, map);
            map.get(node).neighbors.add(map.get(neigh));
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        cloneGraph obj = new cloneGraph();
        Node clonedGraph = obj.cloneGraph(node1);

        Set<Node> visited = new HashSet<>();
        printGraph(clonedGraph, visited);
    }

    // Helper method to print the graph (DFS)
    private static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        System.out.print("Node " + node.val + " neighbors: ");
        for (Node n : node.neighbors) {
            System.out.print(n.val + " ");
        }
        System.out.println();
        for (Node n : node.neighbors) {
            printGraph(n, visited);
        }
    }
}

//leet 133
