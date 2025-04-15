package HashMap_HashSet;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayDivByK {

    //1st approach
    public int longestSubarrayDivK(int[] arr, int k) {
        // Complete the function
        int n = arr.length;
        int sum=0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        int max =0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                max = Math.max(max , len);
            }
            if(!map.containsKey(rem)){
                map.put(rem,i);
            }
        }
        return max;
    }

    //2nd approach
    public int longestSubArrayDivK2(int[] arr, int k) {
        // Complete the function
        int n = arr.length, res = 0;
        Map<Integer, Integer> prefIdx = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % k;
            if (sum < 0) sum += k;

            if (sum == 0) {
                res = i + 1;
            }
            else if (prefIdx.containsKey(sum)) {
                res = Math.max(res, i - prefIdx.get(sum));
            }
            else {
                prefIdx.put(sum, i);
            }

            if (res == n) return res;
        }
        return res;
    }
    public static void main(String[] args) {
        int arr [] = {7, -1, 2, -2, -9, 0, -4, -3, 0, -9};
        int k = 6;
        LongestSubArrayDivByK l = new LongestSubArrayDivByK();
        System.out.println(l.longestSubarrayDivK(arr,k));
    }
}
