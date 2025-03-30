package Other;

public class MinQueries {
    public boolean isNumszero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right = queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = queries.length;
        int l = 0;
        int r = n;
        int k = -1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (isNumszero(nums, queries, mid)) {
                k = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int nums [] = new int []{2,0,2};
        int queries [][] = new int[][]{{0,2,1},{0,2,1},{1,1,3}};
        MinQueries ob = new MinQueries();
        int k = ob.minZeroArray(nums,queries);
        System.out.println("Min queries to make nums zero is " + k);
    }
}
