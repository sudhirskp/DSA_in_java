package DSA_Sheet.Amazon;

import java.util.Arrays;

public class MatrixSetZero {

        int m,n;
        public int[][] setZeroes(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            boolean [][] visited = new boolean[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && matrix[i][j]==0){
                        dfs(i,j,matrix,visited);
                    }
                }
            }
            return matrix;
        }

        private void dfs(int i, int j, int [][] mat, boolean [][] visited){

            for(int c =0;c<n;c++){
                if(mat[i][c]!=0){
                    mat[i][c] = 0;
                    visited[i][c] = true;
                }
            }

            for(int r =0;r<m;r++){
                if(mat[r][j]!=0){
                    mat[r][j] = 0;
                    visited[r][j] = true;
                }
            }

            visited[i][j] =true;
        }

    public static void main(String[] args) {
        MatrixSetZero mt = new MatrixSetZero();
        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int [][] res = mt.setZeroes(matrix);

        System.out.println(Arrays.deepToString(res));
    }
}
//leetCode 73
//Time Complexity: O(m*n)
//link : https://leetcode.com/problems/set-matrix-zeroes/description/