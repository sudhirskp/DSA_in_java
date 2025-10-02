package DSA_Sheet.Amazon;

public class findDuplicate {


        //SC : O(1)
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    return Math.abs(nums[i]);
                }
                nums[index] = -nums[index];
            }
            return -1;
        }


        //SC : O(n)
        public int findDuplicate1(int[] nums) {
            int n = nums.length;
            int [] temp = new int[n];
            for(int j=0;j<n;j++){
                temp[j] = nums[j];
            }
            for(int i=0;i<n;i++){
                int ele = nums[i];
                int actualIndex = ele-1;
                if(temp[actualIndex]<0){
                    return ele;
                }
                temp[actualIndex] = -1*temp[actualIndex];
            }
            return 0;
        }

    public static void main(String[] args) {
        findDuplicate ob = new findDuplicate();
        System.out.println(ob.findDuplicate1(new int[] {1,3,4,2,2}));
    }
}
//Time : O(n)
//leetcode : https://leetcode.com/problems/find-the-duplicate-number/description/
//leetcode : 287