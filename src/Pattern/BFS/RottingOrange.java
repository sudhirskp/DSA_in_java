package Pattern.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {

        public int orangesRotting(int[][] grid) {
            int row =grid.length;
            int col =grid[0].length;
            Queue<int[]> que = new LinkedList<>();

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(grid[i][j]==2){
                        que.offer(new int []{i,j,0});
                    }
                }
            }

            int ans =0;
            while(!que.isEmpty()){
                int [] index = que.poll();
                int r = index[0];
                int c = index[1];
                int time = index[2];

                ans = Math.max(ans,time);

                if(r+1 < row && grid[r+1][c]==1){
                    int [] temp = {r+1,c,time+1};
                    grid[r+1][c]=2;
                    que.offer(temp);
                }

                if(r-1 >=0 && grid[r-1][c]==1){
                    int [] temp = {r-1,c,time+1};
                    grid[r-1][c]=2;
                    que.offer(temp);
                }

                if(c+1 < col && grid[r][c+1]==1){
                    int [] temp = {r,c+1,time+1};
                    grid[r][c+1]=2;
                    que.offer(temp);
                }

                if(c-1 >=0 && grid[r][c-1]==1){
                    int [] temp = {r,c-1,time+1};
                    grid[r][c-1]=2;
                    que.offer(temp);
                }
            }

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(grid[i][j]==1){
                        return -1;
                    }
                }
            }

            return ans;
        }

    public static void main(String[] args) {
            RottingOrange obj = new RottingOrange();
            int[][] grid = {
                    {2, 1, 1},
                    {1, 1, 0},
                    {0, 1, 1}
            };
            int result = obj.orangesRotting(grid);
            System.out.println("Time taken for all oranges to rot: " + result);
    }
}

//leetCode 994