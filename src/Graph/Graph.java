package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public class  pair{
        int n;
        int w;
        pair(int n, int w){
            this.n = n;
            this.w = w;
        }

        @Override
        public String toString() {
            return "[Node: " + n + ", Weight: " + w + "]";
        }
    }


    int adjMatrix[][];
    List<List<Integer>> adjList;
    List<List<pair>> adjListWithWeight;
    public Graph(int nodes){
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();

        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    public void edgesInGraph(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(isDirected){
                adjMatrix[u][v] = 1;
            }else{
                adjMatrix[u][v] =1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void weightEdgesInGraph(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(isDirected){
                adjMatrix[u][v] = w;
            }else{
                adjMatrix[u][v] =w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public void edgesInList(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(isDirected){
              adjList.get(u).add(v);
            }else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    public void edgesWithWeightInList(int edges[][] , boolean isDirected){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w =edge[2];

            if(isDirected){
                pair p = new pair(v,w);
                adjListWithWeight.get(u).add(p);
            }else{
                pair p1 = new pair(v,w);
                pair p2 = new pair(u,w);

                adjListWithWeight.get(u).add(p1);
                adjListWithWeight.get(v).add(p2);
            }
        }
    }

    public void degreeOfdictedGraph(int [][]edges , int nodes){
        int indegree[] = new int[nodes];
        int outdegree[] = new int[nodes];

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            outdegree[u]++;
            indegree[v]++;
        }
        for(int i=0;i<nodes;i++){
            System.out.println("Node " + i + " has indegree " + indegree[i] + " and outdegree " + outdegree[i]);
        }

    }

    public void degreeOfUndirectedGraph(int [][]edges , int nodes){
        int degree[] = new int[nodes];

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }
        for(int i=0;i<nodes;i++){
            System.out.println("Node " + i + " has degree " + degree[i]);
        }

    }

    public void printadjMatrix(){
        for(int i=0; i<adjMatrix.length;i++) {
            System.out.print("Vertex " + i + " is connected to : ");
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printadjList(){
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Vertex " + i + "->");
            System.out.print("[ ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    //Home work - find degree using adjList

    public void degreeByListForDirected(List<List<Integer>> adjList){
        int indegree[] = new int[adjList.size()];
        int outdegree[] = new int[adjList.size()];

        for(int i=0;i<adjList.size();i++){
            for(int j=0;j<adjList.get(i).size();j++){
                outdegree[i]++;
                indegree[adjList.get(i).get(j)]++;
            }
        }

        for(int i=0;i<adjList.size();i++){
            System.out.println("Node " + i + " has indegree " + indegree[i] + " and outdegree " + outdegree[i]);
        }
    }

    public void degreeByListForUndirected(List<List<Integer>> adjList){
        int degree[] = new int[adjList.size()];

        for(int i=0;i<adjList.size();i++){
            for(int j=0;j<adjList.get(i).size();j++){
                degree[adjList.get(i).get(j)]++;
            }
        }

        for(int i=0;i<adjList.size();i++){
            System.out.println("degree of "+i+ " is ->"+ degree[i]);
        }
    }

    public void degreeByMatForUndirectGraph(int [][] adjMatrix){
        int [] degree = new int[adjMatrix.length];
        for(int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[0].length;j++){
                if(adjMatrix[i][j] == 1){
                    degree[i]++;
                }
            }
        }
        for(int i=0;i<adjMatrix.length;i++){
            System.out.println("degree of "+i+ " is -> " + degree[i]);
        }
    }

    public void degreeByMatForDirectedGraph(int [][] adjMatrix){
        int outdegree [] = new int[adjMatrix.length];
        int indegree [] = new int[adjMatrix.length];

        for(int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[0].length;j++){
                if(adjMatrix[i][j] == 1){
                    outdegree[i]++;
                }
                if(adjMatrix[j][i] == 1){
                    indegree[i]++;
                }
            }
        }
        for(int i=0;i<adjMatrix.length;i++){
            System.out.println("Outdegree " + i + " -> " + outdegree[i] + " Indegree -> " + indegree[i]);
        }
    }


    public void printWeightadjList(){
        for (int i = 0; i < adjListWithWeight.size(); i++) {
            System.out.print("Vertex " + i + "->");
            System.out.print("[ ");
            for (int j = 0; j < adjListWithWeight.get(i).size(); j++) {
                System.out.print(adjListWithWeight.get(i).get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nodes = 4;

//        System.out.println("Undirected Graph");
//        int edges[][] = {{0,1,10},{1,2,3},{2,3,5}};
        int edges[][] = {{0,2},{0,1},{1,3}};
        Graph graph = new Graph(nodes);
//        graph.edgesInGraph(edges,false);
//        graph.printadjMatrix();
//        System.out.println();
//
        System.out.println("Directed Graph");
        graph.edgesInGraph(edges,true);
        graph.printadjMatrix();
        System.out.println();
//
//        System.out.println("Weighted Undirected Graph");
//        graph.weightEdgesInGraph(edges, false);
//        graph.display();

   //    System.out.println("Undirected Graph");
        //int edges[][] = {{0,1,10},{1,2,3},{2,3,5}};
      // int edges[][] = {{0,2},{0,1},{1,3}};
      //  Graph graph = new Graph(nodes);
//        graph.edgesInList(edges,false);
//        graph.printadjList();
//        System.out.println();

//        System.out.println("Directed Graph");
//        graph.edgesInList(edges,true);
//        graph.printadjList();
//        System.out.println();

//        System.out.println("Weighted Undirected Graph List-");
//        graph.edgesWithWeightInList(edges, false);
//        graph.printWeightadjList();
//
//        System.out.println("Degree of Directed Graph");
//        graph.degreeOfdictedGraph(edges, nodes);
//
//        System.out.println("Degree of Undirected Graph");
//        graph.degreeOfUndirectedGraph(edges, nodes);

//        System.out.println();
//        System.out.println("degree by adjList for directed graph");
//        graph.degreeByListForDirected(graph.adjList);
//
//        System.out.println();
//        System.out.println("degree for Undirected graph by adjList ");
//        graph.degreeByListForUndirected(graph.adjList);


//        System.out.println();
//        System.out.println("degree for Undirected graph by adfMatrix");
//        graph.degreeByMatForUndirectGraph(graph.adjMatrix);

        System.out.println();
        System.out.println("degree for directed graph by adjMatrix");
        graph.degreeByMatForDirectedGraph(graph.adjMatrix);



    }


}
