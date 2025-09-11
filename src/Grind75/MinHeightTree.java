package Grind75;

import java.util.*;

public class MinHeightTree {

    //1st approach
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(adj.get(i).size()==1) leaves.add(i);
        }

        while(n>2){
            n-= leaves.size();

            List<Integer> newl = new ArrayList<>();
            for(int leaf : leaves){
                int neigh = adj.get(leaf).iterator().next();
                adj.get(neigh).remove(leaf);
                if(adj.get(neigh).size()==1){
                    newl.add(neigh);
                }
            }
            leaves = newl;
        }
        return leaves;
    }


    //2nd approach - using Kahn's algorithm - easy to understand
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        if(n<=0)
            return ans;

        if(n==1){
            ans.add(0);
            return ans;
        }

        int[] inDeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges){
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(inDeg[i]==1)
                q.add(i);
        }

        while(n>2){
            int size = q.size();
            n-=size;

            while(size>0){
                int src = q.poll();

                for(int neighbour : adj.get(src)){
                    inDeg[neighbour]--;
                    if(inDeg[neighbour]==1){
                        q.add(neighbour);
                    }
                }
                size--;
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinHeightTree minHeightTree = new MinHeightTree();
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(minHeightTree.findMinHeightTrees1(n, edges));
    }
}

//leetcode 310
//https://leetcode.com/problems/minimum-height-trees/description/