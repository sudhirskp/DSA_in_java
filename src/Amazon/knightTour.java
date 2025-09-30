package Amazon;

public class knightTour {

        public boolean checkValidGrid(int[][] grid) {
            int n = grid.length;

            // Step 1: Store the position of each move
            int[][] pos = new int[n * n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int move = grid[i][j];
                    pos[move][0] = i;
                    pos[move][1] = j;
                }
            }

            // Step 2: Check if move 0 starts at (0, 0)
            if (pos[0][0] != 0 || pos[0][1] != 0) return false;

            // Step 3: Check each move is a valid knight move
            for (int i = 1; i < n * n; i++) {
                int x1 = pos[i - 1][0], y1 = pos[i - 1][1];
                int x2 = pos[i][0], y2 = pos[i][1];

                int dx = Math.abs(x1 - x2);
                int dy = Math.abs(y1 - y2);

                if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
                    return false;
                }
            }

            return true;
        }

    public static void main(String[] args) {
        knightTour ob = new knightTour();
        System.out.println(ob.checkValidGrid(new int[][]{{0,11,16,5,20},
                                                         {17,4,19,10,15},
                                                         {12,1,8,21,6},
                                                         {3,18,23,14,9},
                                                         {24,13,2,7,22}}));
    }
}
// leetcode problem : link - https://leetcode.com/problems/check-knight-tour-configuration/description/
//leetCode : 2596