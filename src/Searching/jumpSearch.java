package Searching;

public class jumpSearch {
    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5,6,7,8,9,10};
        int target = 5;
        jumpSearch ob = new jumpSearch();
        int index = ob.jump(nums,target);
        if(index ==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index "+index);
        }

    }
    public int jump(int nums [] , int target){
        int n = nums.length;
        int left =  1;
        int blocksize = (int)Math.sqrt(n);
        int end = blocksize;
        while(end<n && nums[end]<target){
            left = end;
            end = end +blocksize;
        }
        for(int i=left;i<n;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
