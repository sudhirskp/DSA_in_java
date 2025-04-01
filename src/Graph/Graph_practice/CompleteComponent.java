package Graph.Graph_practice;

import java.util.ArrayList;
import java.util.List;

class CompleteComponent{
    public static void main(String[] args) {
       int n = 6;
        int [][] edges = {{0,1},{0,2},{1,2},{3,4}};
        CompleteComponent ob = new CompleteComponent();
        System.out.println(ob.countCompleteComponents(n,edges));
    }

    public void dfs(int Node ,boolean [] visited ,List<List<Integer>> adj , List<Integer> component){
        visited[Node] = true;
        component.add(Node);
        for(int node : adj.get(Node)){
            if(!visited[node]){
                dfs(node,visited,adj,component);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean [] visited = new boolean [n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int count =0;
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, adj, component);

                boolean isComplete = true;
                int size = component.size();
                for (int node : component) {
                    if (adj.get(node).size() != size - 1) {
                        isComplete = false;
                        break;
                    }
                }
                if(isComplete){
                    count++;
                }
            }
        }
        return count;
    }
}