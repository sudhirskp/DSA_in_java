package HashSet;

import java.util.HashSet;

public class KthSumSubArray {
    public boolean kthSumSubarr(int [] arr, int k){
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int SubSum =0;
        for(int i=0;i<n;i++) {
            SubSum += arr[i];
            int find = SubSum - k;
            if (set.contains(find)) {
                return true;
            }
            set.add(SubSum);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr [] = {2,8,6,-6,3,2};
        KthSumSubArray ob = new KthSumSubArray();
        System.out.println(ob.kthSumSubarr(arr , 5));
    }
}
