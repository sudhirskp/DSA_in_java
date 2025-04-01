package Stack;

public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSquare = 0;

        int heightOfHisto[] = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = matrix[i][j] - '0';
                if (val == 0) {
                    heightOfHisto[j] = 0;
                } else {
                    heightOfHisto[j] += val;
                }
            }
            maxSquare = Math.max(maxSquare, MaxHistogram(heightOfHisto));
        }
        return maxSquare;
    }

    public int MaxHistogram(int arr[]) {
        int n = arr.length;
        int[] stack = new int[n + 1];
        int maxSquareArea = 0;
        int index = -1; //index of stack
        for (int i = 0; i <= n; i++) {
            int ele = i == n ? 0 : arr[i];
            while (index != -1 && arr[stack[index]] > ele) {
                int h = arr[stack[index--]];
                int ps = index == -1 ? -1 : stack[index];
                int w = i - ps - 1;
                int side = Math.min(h, w);
                maxSquareArea = Math.max(maxSquareArea, side * side);

            }
            stack[++index] = i;
        }
        return maxSquareArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaxSquare m = new MaxSquare();
        System.out.println(m.maximalSquare(matrix));
    }
}


//221. Maximal Square
//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//
//
//Example 1:
//
//
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//Output: 4