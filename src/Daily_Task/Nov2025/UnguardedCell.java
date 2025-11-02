package Daily_Task.Nov2025;

public class UnguardedCell {


        int row,col;
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            row = m;
            col = n;
            int [][] grid = new int [m][n];

            for(int [] g : guards){
                grid[g[0]][g[1]] = 1;
            }

            for(int [] w : walls){
                grid[w[0]][w[1]] = 2;
            }

            boolean [][] visited = new boolean [m][n];

            for (int[] g : guards) {
                int r = g[0], c = g[1];

                for (int i = r - 1; i >= 0 && grid[i][c] != 1 && grid[i][c] != 2; i--) {
                    if (grid[i][c] == 0) grid[i][c] = 3;
                }

                for (int i = r + 1; i < m && grid[i][c] != 1 && grid[i][c] != 2; i++) {
                    if (grid[i][c] == 0) grid[i][c] = 3;
                }

                for (int j = c - 1; j >= 0 && grid[r][j] != 1 && grid[r][j] != 2; j--) {
                    if (grid[r][j] == 0) grid[r][j] = 3;
                }

                for (int j = c + 1; j < n && grid[r][j] != 1 && grid[r][j] != 2; j++) {
                    if (grid[r][j] == 0) grid[r][j] = 3;
                }
            }


            int ans =0;

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0) ans++;
                }
            }
            return ans;
        }

    public static void main(String[] args) {

            UnguardedCell obj = new UnguardedCell();
            int m = 4;
            int n = 6;
            int[][] guards = {{0,0},{1,1},{2,3}};
            int[][] walls = {{0,1},{2,2},{1,4}};

            System.out.println(obj.countUnguarded(m, n, guards, walls));
    }
}

//LeetCode : 2257
// 2nov 2025
