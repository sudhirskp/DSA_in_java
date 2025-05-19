package Pattern.Modifide_BNsearch;

public class MinVal {
    public int minVal(int [] nums){
        int n = nums.length;
        int l = 0;
        int r= n-1;
        int minval = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l + (r-l)/2;
            minval = Math.min(minval,nums[mid]);
            if(nums[l] <= nums[mid] && nums[l]>=nums[r]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return minval;
    }
    public static void main(String[] args) {
        int nums [] = {3,4,5,1,2,3};
        MinVal m = new MinVal();
        System.out.println(m.minVal(nums));
    }
}

//leetcode 153
