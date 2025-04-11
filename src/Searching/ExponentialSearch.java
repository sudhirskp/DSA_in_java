package Searching;

public class ExponentialSearch {
    public static int bnsearch(int nums [] , int target , int start , int end){
        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }else if(nums[mid]>target){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums [] = new int [] {2,4,6,7,8,9,23,46,78};
        int target =99;
        int start = 1;
        int end = nums.length;
        while(start< nums.length && nums[start]<=target){
            start = start * 2;
        }
        end = Math.min(start,nums.length-1);
        int index = bnsearch(nums,target,start/2,end);
        if(index==-1){
            System.out.println("Element is Not Found");
        }else{
            System.out.println("Element is found at index " + index);
        }
    }

}
