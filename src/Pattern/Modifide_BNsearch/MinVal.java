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

    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            int m= l+(r-l)/2;
            if(nums[m]<min){
                min = nums[m];
            }
            if(nums[m]>nums[r]){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int nums [] = {3,4,5,1,2,3};
        MinVal m = new MinVal();
        System.out.println(m.minVal(nums));
    }
}

//leetcode 153
