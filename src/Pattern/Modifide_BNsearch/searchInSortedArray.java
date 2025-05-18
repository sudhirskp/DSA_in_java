package Pattern.Modifide_BNsearch;

public class searchInSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left =0;
        int right = n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left =mid + 1;
                }
            }else if(nums[mid] < target && nums[right] >= target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        searchInSortedArray s = new searchInSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(nums,target));
    }
}

//leetcode 33
