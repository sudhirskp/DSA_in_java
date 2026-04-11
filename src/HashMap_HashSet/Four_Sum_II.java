package HashMap_HashSet;

import java.util.HashMap;
import java.util.Map;

public class Four_Sum_II {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        Map<Long,Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                long sum = (long)nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                long sum = (long)nums3[i]+nums4[j];
                if(map.containsKey(-sum)){
                    count += map.getOrDefault(-sum, 0);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
//leetcode 454