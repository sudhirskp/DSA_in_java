package Amazon;

import java.util.ArrayList;
import java.util.List;

public class M_Coloring {

        boolean graphColoring(int v, int[][] edges, int m) {
            // code here

            List<List<Integer>> adj = new ArrayList<>();
            int [] color = new int[v];

            for(int i=0;i<v;i++){
                adj.add(new ArrayList<>());

            }

            for(int [] node : edges){
                int u = node[0];
                int vv = node[1];
                adj.get(u).add(vv);
                adj.get(vv).add(u);
            }

            return Coloring(adj,v,m,0,color);
        }

        boolean Coloring(List<List<Integer>> adj, int v, int m, int curNode,int [] color){
            if(curNode==v) return true;

            for(int col = 1 ; col<=m;col++){
                if(valid(curNode,adj,color,col)){
                    color[curNode] = col;
                    if(Coloring(adj,v,m,curNode+1,color)) return true;
                    color[curNode] = 0;
                }
            }
            return false;
        }


        boolean valid(int curNode, List<List<Integer>> adj,int [] color,int col){
            for(int no : adj.get(curNode)) {
                if(color[no] == col) return false;
            }
            return true;
        }

    public static void main(String[] args) {
        M_Coloring ob = new M_Coloring();
        System.out.println(ob.graphColoring(4,new int[][]{{0,1},{1,2},{2,3},{3,0},{0,2}},3));
    }
}
//link - https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
//gfg problem : M-Coloring Problem