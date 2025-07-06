package DP;

public class Pascals {

        public int[][] PascalsTriangle(int A) {
            int[][] res = new int[A][A];

            for (int i = 0; i < A; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        res[i][j] = 1;
                    } else {
                        res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                    }
                }
            }

            return res;
        }

    public static void main(String[] args) {
            Pascals ob = new Pascals();
            int [][] res = ob.PascalsTriangle(5);

            for(int i=0;i< res.length;i++){
                for(int j=0;j<res[i].length;j++){
                    System.out.print(res[i][j]+" ");
                }
                System.out.println();
            }
    }
}
