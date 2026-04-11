package Pattern.Backtrack;

import java.util.Arrays;

public class Sudoku_Solver {

    public static char[][] solveSudoku(char[][] board) {
        if(Solver(board,0,0)){
            return board;
        }
        return new char [][]{};
    }

    private static boolean Solver(char [][] brd, int row, int col){
        if(col==9){
            col = 0;
            row  = row + 1;
        }

        if(row==9){
            return true;
        }

        if(brd[row][col]!='.'){
            return Solver(brd,row,col+1);
        }

        for(int i = 1;i<=9;i++){
            char ch = (char)(i + '0');
            if(valid(brd,row,col,ch)){
                brd[row][col] = ch;
                if(Solver(brd,row,col+1))return true;
                brd[row][col] = '.';
            }
        }
        return false;
    }
    private static boolean valid(char [][] brd, int row, int col, char ch){
        for(int i =0;i<9;i++){
            //row check
            if(brd[row][i]==ch) return false;
            //col check
            if(brd[i][col]==ch) return false;

            //this is for grid check

            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;

            if(brd[r][c] == ch) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(Arrays.deepToString(solveSudoku(board)));

    }
}
