package DSA_Sheet.Uber;

public class nextPermu {

        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int fstlow = n - 2;

            while (fstlow >= 0 && nums[fstlow] >= nums[fstlow + 1]) {
                fstlow--;
            }

            if (fstlow >= 0) {
                int fstlarg = n - 1;
                while (nums[fstlarg] <= nums[fstlow]) {
                    fstlarg--;
                }
                swap(nums, fstlow, fstlarg);

            }
            rev(nums, fstlow + 1, n - 1);
        }

        void swap(int [] nums, int low, int high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }

        void rev(int [] nums, int st, int end){
            while(st<end){
                swap(nums,st,end);
                st++;
                end--;
            }
        }

    public static void main(String[] args) {
        nextPermu ob = new nextPermu();
        int [] arr = {1,2,3};
        ob.nextPermutation(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
//leetCode : 31
//link - https://leetcode.com/problems/next-permutation/description/
//