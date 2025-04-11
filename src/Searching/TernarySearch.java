package Searching;

public class TernarySearch {
    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5,6,7,8,9,10};
        int target =9;
        TernarySearch ob = new TernarySearch();
        int index = ob.Ternary(nums,target);
        if(index ==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index "+index);
        }
    }
    public int Ternary(int  [] nums , int target){
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid1 = left+(right-left)/3;
            int mid2 = right-(right-left)/3;
            if(nums[mid1]==target){
                return mid1;
            }
            if(nums[mid2]==target){
                return mid2;
            }
            if(target<nums[mid1]){
                right = mid1-1;
            }else if(target>nums[mid2]){
                left = mid2+1;
            }else{
                left = mid1+1;
                right = mid2-1;
            }
        }
        return -1;
    }
}
