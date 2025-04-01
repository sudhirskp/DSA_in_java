package Stack;

public class MaxRectangleByMatrix {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxRect =0;

        int heightOfHisto[] = new int [col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int val = matrix[i][j]-'0';
                if(val==0){
                    heightOfHisto[j]=0;
                }else{
                    heightOfHisto[j]+=val;
                }
            }
            maxRect = Math.max(maxRect,MaxHistogram(heightOfHisto));

        }
        return maxRect;
    }
    public int MaxHistogram(int arr[]){
        int n = arr.length;
        int [] stack = new int[n+1];
        int max = Integer.MIN_VALUE;
        int index =-1; //index of stack
        for(int i=0;i<=n;i++){
            int ele = i==n ? 0 : arr[i];
            while(index!=-1 && arr[stack[index]]>ele){
                int h = arr[stack[index--]];
                int ps = index==-1 ? -1 : stack[index];
                int w = i-ps-1;
                max = Math.max(max,h*w);
            }
            stack[++index]=i;
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }

    public static void main(String[] args) {
        char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaxRectangleByMatrix m = new MaxRectangleByMatrix();
        System.out.println(m.maximalRectangle(matrix));
    }
}
//85. Maximal Rectangle
//Hard
//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
//
//
//Example 1:
//
//
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.