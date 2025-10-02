package DSA_Sheet.Amazon;

import java.util.Arrays;

public class ProductArray {


        //SC : O(1) - excluding output array
        public int[] productExceptSelf1(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }

            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= suffix;
                suffix *= nums[i];
            }

            return res;
        }



    //SC : O(n)
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n];
            int[] suffix = new int[n];
            int[] result = new int[n];
            prefix[0] = 1;
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }

            suffix[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }

            for (int i = 0; i < n; i++) {
                result[i] = prefix[i] * suffix[i];
            }

            return result;
        }

    public static void main(String[] args) {
        ProductArray ob = new ProductArray();
        System.out.println(Arrays.toString(ob.productExceptSelf1(new int[] {1,2,3,4})));
    }
}
//leetCode 238
//TC : O(n)