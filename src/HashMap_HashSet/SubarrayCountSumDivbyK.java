package HashMap_HashSet;

import java.util.HashMap;
import java.util.Map;

public class SubarrayCountSumDivbyK {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            int rem = sum%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);

        }
        return count;
    }

    public int subarraysDivByk(int[] nums, int k) {
        //Map<Integer,Integer> map = new HashMap<>();
        int [] map = new int [k];
        //map.put(0,1);
        map[0] = 1;
        int count = 0;
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            int rem = sum%k;
            if(rem<0){
                rem+=k;
            }
            // if(map.containsKey(rem)){
            //      count += map.get(rem);
            // }
            count += map[rem];
            map[rem]++;
            //map.put(rem, map.getOrDefault(rem, 0) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayCountSumDivbyK ob = new SubarrayCountSumDivbyK();
        int [] arr = {1,2,3,4,1};
        System.out.println(ob.subarraysDivByk(arr,3));
    }
}
