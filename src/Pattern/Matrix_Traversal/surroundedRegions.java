package Pattern.Matrix_Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class surroundedRegions {

    //using dfs
    int row, col;
    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {

            edge(i, 0, board);
            edge(i, col - 1, board);

        }

        for (int j = 0; j < col; j++) {
            edge(0, j, board);
            edge(row - 1, j, board);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }

    public void edge(int r, int c, char[][] grid) {

        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 'O') {
            return;
        }
        grid[r][c] = 'E';
        int[][] dir = { { r + 1, c }, { r - 1, c }, { r, c + 1 }, { r, c - 1 } };
        for (int[] ind : dir) {
            edge(ind[0], ind[1], grid);
        }

    }

    //using bfs
    public void solve1(char[][] board) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {

            edge1(i, 0, board);
            edge1(i, col - 1, board);

        }

        for (int j = 0; j < col; j++) {
            edge1(0, j, board);
            edge1(row - 1, j, board);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }

    public void edge1(int r, int c, char[][] grid) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 'O') {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int i = index[0], j = index[1];
            grid[i][j] = 'E';

            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

            for (int[] d : directions) {
                int x = i + d[0];
                int y = j + d[1];

                if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 'O') {
                    queue.offer(new int[] { x, y });
                    grid[x][y]='E';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] grid = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        surroundedRegions obj = new surroundedRegions();
        obj.solve1(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//leet 130
