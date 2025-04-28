package Graph;

public class TopoSort {
    public static void main(String[] args) {
        int nodes = 6;
        int edges[][] = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };
        Graph graph = new Graph(nodes);
        graph.edgesInGraph(edges, true);
        topoSort(graph, nodes);

    }

    private static void topoSort(Graph graph, int nodes) {

        boolean visited[] = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);

            }
        }
    }

    private static void dfs(int node, boolean[] visited, Graph graph) {
        visited[node] = true;
        for (int i = 0; i < graph.adjList.size(); i++) {
            if (!visited[i] && graph.adjMatrix[node][i] == 1) {
                dfs(i, visited, graph);
            }
        }
        System.out.print(node + " ");
    }

}
