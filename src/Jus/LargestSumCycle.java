package Jus;


import java.util.HashMap;
import java.util.Map;

public class LargestSumCycle {

        int maxSum =-1;
        public long largesSumCycle(int N, int Edge[]) {
            boolean [] visited = new boolean [N];
            boolean [] ispath = new boolean [N];
            int [] path = new int [N];




            for(int i=0;i<N;i++){
                if(!visited[i]){
                    dfs(i,visited,ispath,new HashMap<>(),Edge,0);

                }
            }

            return maxSum;

        }

        public void dfs(int node, boolean [] visited, boolean [] ispath,
                        HashMap<Integer, Integer> IndexMap, int [] edge, int depth){

            if(node == -1 ) return;

            if(ispath[node]){
                int cycleSum = 0;
                for(Map.Entry<Integer,Integer> entry : IndexMap.entrySet()){
                    if(entry.getValue() >= IndexMap.get(node)){
                        cycleSum += entry.getKey();
                    }
                }

                maxSum = Math.max(maxSum, cycleSum);
                return;
            }

            if(visited[node]) return ;

            visited[node] = true;
            ispath[node] = true;
            IndexMap.put(node,depth);

            dfs(edge[node], visited, ispath, IndexMap, edge, depth + 1);

            ispath[node] = false;
            IndexMap.remove(node);

        }
    public static void main(String[] args) {
            LargestSumCycle l = new LargestSumCycle();
            int [] edge = {1,2,0,-1};
            System.out.println(l.largesSumCycle(4,edge));
    }
}
// https://practice.geeksforgeeks.org/problems/largest-sum-cycle/1