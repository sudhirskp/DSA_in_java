package Pattern.Matrix_Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class No_of_Island {

    int row, col;

    //1st approach - 5ms
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;
        int[][] dir = { { r + 1, c }, { r - 1, c }, { r, c + 1 }, { r, c - 1 } };
        for (int[] neigh : dir) {
            int x = neigh[0];
            int y = neigh[1];
            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] != '0' && !visited[x][y]) {
                dfs(x, y, grid, visited);
            }

        }

    }

    //2nd approach - 4ms
    public int numIslands2(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c, char[][] grid) {
        grid[r][c] = '0';
        int[][] dir = { { r + 1, c }, { r - 1, c }, { r, c + 1 }, { r, c - 1 } };
        for (int[] neigh : dir) {
            int x = neigh[0];
            int y = neigh[1];
            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] != '0') {
                dfs(x, y, grid);
            }

        }

    }

    //3rd approach - 7ms
    public int numIslands3(char[][] grid) {
         row = grid.length;
         col = grid[0].length;
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    que.offer(new int[] { i, j });
                    grid[i][j] = '0';
                    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
                    while (!que.isEmpty()) {
                        int[] index = que.poll();
                        for (int[] ind : dir) {
                            int x = index[0] + ind[0];
                            int y = index[1] + ind[1];
                            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] != '0') {
                                que.offer(new int[] { x, y });
                                grid[x][y] = '0';
                            }
                        }

                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        No_of_Island obj = new No_of_Island();
        System.out.println(obj.numIslands3(grid));

    }
}

//leet 200
