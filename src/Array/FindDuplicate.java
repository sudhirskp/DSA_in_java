package Array;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int f = nums[nums[0]];
        int s = nums[0];

        while(f!=s){
            s = nums[s];
            f = nums[nums[f]];
        }

        f = 0;

        while(f!=s){
            s = nums[s];
            f = nums[f];
        }

        return s;
    }

    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                return Math.abs(nums[i]);
            }
            nums[index] = -nums[index];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicate ob = new FindDuplicate();
        System.out.println(ob.findDuplicate(new int [] {1,3,4,2,2}));
    }
}

//LeetCode 287