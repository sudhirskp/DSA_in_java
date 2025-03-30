package Other;

class Solution{
    public int removeElement(int[] nums, int val) {
        int n= nums.length;
        int left=0;
        for(int r=0;r<n;r++){
            if(nums[r]!=val) {
                nums[left] = nums[r];
                left++;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Solution ob =new Solution();
        int m= ob.removeElement(new int []{3,2,2,3},3);
        System.out.println(m);
    }
}