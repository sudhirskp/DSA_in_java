package Daily_Task.Nov2025;

public class AllArrayEle {

        public int minOperations(int[] nums) {
            int n = nums.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    count++;
                }

            }
            if (count > 0) {
                return n - count;
            }

            int minsub = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                for(int j=i+1;j<n;j++){
                    num = findGCD(num, nums[j]);
                    if (num == 1) {
                        minsub = Math.min(minsub,j-i+1);
                        break;
                    }
                }
            }
            return minsub == Integer.MAX_VALUE ? -1 : (n-1) +(minsub-1);
        }

        public static int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }


    public static void main(String[] args) {
            AllArrayEle allArrayEle = new AllArrayEle();
            int [] nums = {2,6,3,4};
            System.out.println(allArrayEle.minOperations(nums));
    }
}
//leetCode 2654
//12 nov 2025
//Time : O(n^2)