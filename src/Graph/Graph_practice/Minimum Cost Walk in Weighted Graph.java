package Graph.Graph_practice;
class Ds {
    int node;
    int[] rank;
    int[] parents;

    Ds(int node) {
        this.rank = new int[node];
        this.parents = new int[node];
        for (int i = 0; i < node; i++) {
            this.parents[i] = i;
        }
    }

    public int findParent(int node) {
        if (node == parents[node]) {
            return node;
        }
        return parents[node] = findParent(parents[node]);
    }

    public void unionByRank(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);
        if (parentU == parentV) return;
        if (rank[parentU] > rank[parentV]) {
            parents[parentV] = parentU;
        } else if (rank[parentV] > rank[parentU]) {
            parents[parentU] = parentV;
        } else {
            parents[parentV] = parentU;
            rank[parentU]++;
        }
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] weight = new int[n];
        int[] result = new int[query.length];
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        Ds ds = new Ds(n);
        for(int edge [] : edges){
            ds.unionByRank(edge[0] , edge[1]);
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (ds.findParent(u) == ds.findParent(v)) {
                weight[ds.findParent(u)] = weight[ds.findParent(u)] & w;
            }
        }

        int j = 0;
        for (int[] q : query) {
            int u = ds.findParent(q[0]);
            int v = ds.findParent(q[1]);
            if (u == v) {
                result[j++] = weight[ds.findParent(u)];
            } else {
                result[j++] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test the solution here
        Solution solution = new Solution();

        int n = 5;
        int [][] edges = {{0,1,7},{1,3,7},{1,2,1}};
        int [][] query = {{0,3},{3,4}};
        int[] result = solution.minimumCost(n, edges, query);
        for (int i : result) {
            System.out.print(i + " ");
        }


    }
}