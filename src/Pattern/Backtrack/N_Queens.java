package Pattern.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            String[][] board = new String[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], ".");
            }
            findQ(n, res, 0, board);
            return res;
        }

        private void findQ(int n, List<List<String>> res, int row, String[][] brd) {


                if (row == n) {
                    List<String> board = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        board.add(String.join("", brd[i]));
                    }
                    res.add(board);
                    return;
                }

            for (int col = 0; col < n; col++) {
                if (Valid(row, col, n, brd)) {
                    brd[row][col] = "Q";
                    findQ(n, res, row + 1, brd);
                    brd[row][col] = ".";
                }
            }
        }

        boolean Valid(int row, int col, int n, String [][] board) {
            for (int i = 0; i < row; i++) {
                if (board[i][col] == "Q")
                    return false;
            }

            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == "Q")
                    return false;
            }

            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == "Q")
                    return false;
            }
            return true;
        }

        public static void main(String[] args) {
            int n = 4;
            Recursion.N_Queens obj = new Recursion.N_Queens();
            List<List<String>> res = obj.solveNQueens(n);
            System.out.println(res);

        }
    }

//leetcode 51
