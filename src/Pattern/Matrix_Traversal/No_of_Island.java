package Pattern.Matrix_Traversal;

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

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        No_of_Island obj = new No_of_Island();
        System.out.println(obj.numIslands(grid));

    }
}

//leet 200
