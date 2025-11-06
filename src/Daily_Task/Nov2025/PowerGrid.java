package Daily_Task.Nov2025;

import java.util.*;

public class PowerGrid {

        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            int[] parent = new int[c + 1];
            Map<Integer, TreeSet<Integer>> online = new HashMap<>();
            boolean[] offline = new boolean[c + 1];

            for (int i = 1; i <= c; i++) {
                parent[i] = i;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                online.put(i, set);
            }

            for (int[] no : connections) {
                int a = no[0], b = no[1];
                int ra = find(a, parent), rb = find(b, parent);
                if (ra != rb) {
                    if (online.get(ra).size() < online.get(rb).size()) {
                        int temp = ra; ra = rb; rb = temp;
                    }
                    parent[rb] = ra;
                    online.get(ra).addAll(online.get(rb));
                    online.remove(rb);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int[] qu : queries) {
                int q = qu[0], node = qu[1];
                if (q == 2) {
                    if (!offline[node]) {
                        offline[node] = true;
                        int root = find(node, parent);
                        online.get(root).remove(node);
                    }
                } else {
                    if (!offline[node]) {
                        ans.add(node);
                    } else {
                        int root = find(node, parent);
                        TreeSet<Integer> set = online.get(root);
                        ans.add(set.isEmpty() ? -1 : set.first());
                    }
                }
            }

            int[] res = new int[ans.size()];
            int j = 0;
            for (int v : ans) res[j++] = v;
            return res;
        }

        private int find(int x, int[] parent) {
            if (parent[x] != x) parent[x] = find(parent[x], parent);
            return parent[x];
        }

    public static void main(String[] args) {
            PowerGrid powerGrid = new PowerGrid();
            int c = 6;
            int[][] connections = {{1,2},{2,3},{3,4},{4,5},{5,6}};
            int[][] queries = {{1,1},{2,2},{2,1},{1,6}};
            int [] res = powerGrid.processQueries(c,connections,queries);
            System.out.print(Arrays.toString(res));

    }
}
//LeetCode 3607
//6 nov 2025

