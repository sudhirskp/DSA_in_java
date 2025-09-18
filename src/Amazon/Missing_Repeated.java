package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Missing_Repeated  {


        public int[] findMissingAndRepeatedValues1(int[][] grid) {
            int n = grid.length ;
            int size = n*n,rep=0,no=0;
            int freq[] = new int[size+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    freq[grid[i][j]]++;
                }
            }
            for(int i=1;i<freq.length;i++){
                if(freq[i]>1)
                    rep = i;
                if(freq[i]==0)
                    no = i;
            }
            return new int[]{rep,no};
        }

        public int[] findMissingAndRepeatedValues2(int[][] grid) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int m = grid.length;
            int n = grid[0].length;

            int max = -1;
            int repeat = 0;
            int missing = -1;

            for (int[] arr : grid) {
                for (int i = 0; i < arr.length; i++) {
                    max = Math.max(max, arr[i]);
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

                    if (map.get(arr[i]) >= 2) {
                        repeat = arr[i];
                        //break;
                    }
                }
            }

            int j =1;
            while(max > j){
                if(!map.containsKey(j)){
                    missing = j;
                    break;
                }else{
                    missing = max+1;
                }
                j++;
            }

            return new int[] { repeat, missing };

        }


        public int[] findMissingAndRepeatedValues(int[][] grid) {

            int n = grid.length;
            int size = n * n;
            int[] result = new int[2];

            Map<Integer, Integer> count = new HashMap<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = grid[i][j];
                    count.put(num, count.getOrDefault(num, 0) + 1);
                }
            }

            for (int i = 1; i <= size; i++) {
                if (count.getOrDefault(i, 0) == 2) {
                    result[0] = i;
                }
                if (count.getOrDefault(i, 0) == 0) {
                    result[1] = i;
                }
            }
            return result;
        }


    public static void main(String[] args) {
        Missing_Repeated missing_repeated = new Missing_Repeated();
        int[][] grid = {{1,3},{2,2}};
        int [] result = missing_repeated.findMissingAndRepeatedValues1(grid);
        System.out.println(Arrays.toString(result));
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
//leetCode 2965
