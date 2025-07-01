package Pattern.Matrix_Traversal;

public class surroundedRegions {

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
    public static void main(String[] args) {

        char[][] grid = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        surroundedRegions obj = new surroundedRegions();
        obj.solve(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//leet 130
