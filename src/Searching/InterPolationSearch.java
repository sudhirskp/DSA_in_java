package Searching;

public class InterPolationSearch {
    public static void main(String[] args) {
        int nums [] = {2,4,6,8,10,12,14,16,18,20};
        //int nums [] = {2};
        int target = 6;
        InterPolationSearch ob = new InterPolationSearch();
        int index = ob.InterPolation(nums,target);
        if(index ==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index "+index);
        }

    }
    public int InterPolation(int nums [] , int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right && target>=nums[left] && target<=nums[right]){
            int pos = left + (((right-left)/(nums[right]-nums[left]))*(target-nums[left]));
            if(nums[pos]==target){
                return pos;
            }
            if(nums[pos]<target){
                left = pos+1;
            }else{
                right = pos-1;
            }
        }
        return -1;
    }
}
