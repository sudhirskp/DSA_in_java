package DSA_Sheet.Amazon;

public class SearchinRotated {


        public int search(int[] nums, int target){
            int n = nums.length;
            int l=0;
            int r = n-1;
            int ans =-1;
            while(r>=l){
                int mid = l+(r-l)/2;
                if(target==nums[mid]) return mid;
                if(nums[l]<=nums[mid]){
                    if(target>=nums[l] && target < nums[mid]){
                        r=mid-1;
                    }else{
                        l = mid+1;
                    }
                }else {
                    if(target>nums[mid] && target <= nums[r]){
                        l = mid+1;
                    }else{
                        r = mid-1;
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        SearchinRotated ob = new SearchinRotated();
        System.out.println(ob.search(new int[] {4,5,6,7,0,1,2}, 0));
    }
}
//leetcode : 33
//TC : O(log n)
//SC : O(1)
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/