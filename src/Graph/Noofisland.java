package Graph;

public class Noofisland {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0, 0},
                       {1, 1, 0, 0, 0},
                       {0, 0, 1, 0, 0},
                       {0, 0, 0, 1, 1}};
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) { // Corrected column length
                if (arr[i][j] == 1) {
                    DFS(arr, i, j);
                    ans++;
                }
            }
        }
        System.out.println("No of island : " + ans);
    }

    private static void DFS(int[][] arr, int i, int j) {
        // Mark the current cell as visited by setting it to 0
        arr[i][j] = 0;

        // Check all four directions (up, down, left, right)
        if (i + 1 < arr.length && arr[i + 1][j] == 1) { // Down
            DFS(arr, i + 1, j);
        }
        if (j + 1 < arr[0].length && arr[i][j + 1] == 1) { // Right
            DFS(arr, i, j + 1);
        }
        if (i - 1 >= 0 && arr[i - 1][j] == 1) { // Up
            DFS(arr, i - 1, j);
        }
        if (j - 1 >= 0 && arr[i][j - 1] == 1) { // Left
            DFS(arr, i, j - 1);
        }
    }
}

