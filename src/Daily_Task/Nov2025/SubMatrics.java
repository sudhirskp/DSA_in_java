package Daily_Task.Nov2025;

public class SubMatrics {


        public int[][] rangeAddQueries(int n, int[][] queries) {
            int [][] mat = new int [n][n];


            for(int [] qu : queries){
                int r1 = qu[0];
                int c1 = qu[1];
                int r2 = qu[2];
                int c2 = qu[3];

                for(int i=r1;i<=r2;i++){
                    for(int j = c1;j<=c2;j++){
                        mat[i][j]+=1;
                    }
                }

            }
            return mat;
        }

    public static void main(String[] args) {
            SubMatrics subMatrics = new SubMatrics();
            int [][] queries = {{1,1,2,2},{0,0,1,1}};
            int [][] mat = subMatrics.rangeAddQueries(3, queries);
            for(int [] row : mat){
                for(int ele : row){
                    System.out.print(ele+" ");

                }
            }
    }
}
//leetCode 2536
//15 nov 2025
//TC : O(n^2)
