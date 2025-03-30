package DSU;

public class DisjoinSet {
    int [] parent;
    int [] rank;
    int components;
    int []size;

    DisjoinSet(int node){
        this.rank = new int[node];
        this.parent = new int[node];
        this.components = node;
        this.size = new int[node];

        for(int i = 0; i< node; i++){
            this.parent[i] = i;
            this.size[i] = 1;
            //rank[i] = 0; // No need to do this because in java all value Initially is zero
        }
    }

    public int findRootParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findRootParent(parent[node]);
        //return parent[node];
    }

    public void unionByRank(int u , int v){
        u = findRootParent(u);
        v = findRootParent(v);

        if(u == v){
            return;
        }
        components--;

        if(rank[u] < rank[v]){
            parent[u] = v;
        }else if(rank[u] > rank[v]){
            parent[v] = u;
        }else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public void unionBySize(int u, int v){
        u = findRootParent(u);
        v = findRootParent(v);

        if(u == v){
            return;
        }
        components--;

        if(size[u] < size[v]){
            parent[u] = v;
            size[v]+=size[u];
//        }else if(size[u] > size[v]){
//            parent[v] = u;
        }else {
            parent[v] = u;
            size[u]+=size[v];
        }
    }

    public static void main(String[] args) {
//        DisjoinSet ds = new DisjoinSet(5);
//        System.out.println("total no of Components -> "+ ds.components);
//        //ds.unionByRank(0, 3);
//        System.out.println(ds.findRootParent(0)==ds.findRootParent(3));
//        ds.unionByRank(0, 3);
//        System.out.println("total no of Components -> "+ ds.components);
//        System.out.println(ds.findRootParent(0)==ds.findRootParent(3));

//        DisjoinSet ds = new DisjoinSet(4);
//        System.out.println("total no of Components -> "+ ds.components);
//        //ds.unionByRank(0, 3);
//        System.out.println(ds.findRootParent(0)==ds.findRootParent(3));
//        ds.unionBySize(0, 3);
//        System.out.println("total no of Components -> "+ ds.components);
//        System.out.println(ds.findRootParent(0)==ds.findRootParent(3));
    }

}
