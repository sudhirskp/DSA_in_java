package Pattern.Matrix_Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class floodFill {

    //1st approach
    int row,col;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        row = image.length;
        col = image[0].length;

        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        int [][] ans = image;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int []{sr,sc});

        while(!que.isEmpty()){
            int [] index = que.poll();
            int r = index[0];
            int c = index[1];

            if(ans[r][c]==originalColor){
                ans[r][c]=color;
                int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int [] neigh : dir){
                    int x = neigh[0] + r;
                    int y = neigh[1] + c;
                    if(x>=0 && x < row && y >=0 && y < col && ans[x][y]==originalColor){
                        que.offer(new int []{x,y});
                    }
                }
            }
        }
        return ans;
    }

    //2nd approach
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        row = image.length;
        col = image[0].length;
        boolean [][] visit = new boolean[row][col];
        dfs(sr,sc,image[sr][sc],color,visit,image);
        return image;
    }

    public void dfs(int r , int c ,int oldcolor , int newcolor,boolean[][] visit,int [][]image){
        if(r<0 || r>=row || c<0 || c>=col){
            return;
        }
        if(visit[r][c]){
            return;
        }
        if(image[r][c]!=oldcolor){
            return;
        }
        image[r][c]=newcolor;
        visit[r][c] = true;
        int [][] adjList = {{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
        for(int neighbour [] : adjList){
            dfs(neighbour[0],neighbour[1],oldcolor,newcolor,visit,image);
        }
    }

    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        floodFill obj = new floodFill();
        int [][] ans = obj.floodFill2(image, sr, sc, color);
        for(int [] row : ans){
            for(int ele : row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
//leet 733