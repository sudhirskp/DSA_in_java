package DP;

public class House_Robber_II {

        private static int rob1(int[] nums) {
            int n = nums.length;
            int [] dp = new int [n+1];

            dp[1] = nums[0];
            dp[0] = 0;
            for(int i = 2;i<=n;i++){
                int pick =  nums[i-1]+dp[i-2];
                int no = dp[i-1];
                dp[i] = Math.max(pick,no);
            }
            return dp[n];
        }

        public static int rob(int[] nums) {
            int n = nums.length;
            if(n==1) return nums[0];
            int [] t1 = new int [n-1];
            int [] t2 = new int [n-1];

            int j = 0;
            int k =0;

            for(int i =0;i<n;i++){
                if(i!=0)
                    t1[j++] = nums[i];

                if(i!=n-1)
                    t2[k++] = nums[i];
            }

            return Math.max(rob1(t1),rob1(t2));
        }

        //-----------------------------------------------------


        public static int rob2(int[] nums) {
            int n = nums.length;
            if(n==1) return nums[0];
            if(n==0) return 0;

            int c1 = case1(nums,1,n-1);
            int c2 = case2(nums,0,n-2);

            return Math.max(c1,c2);
        }

        public static int case1(int [] nums , int st,int end){
            int n = end;
            if(n==st) return nums[st];
            if(n==0) return 0;

            int pre2 = nums[st];
            int pre1 = Math.max(nums[st],nums[st+1]);

            for(int i=st+2;i<=n;i++){
                int cur = Math.max(nums[i]+pre2,pre1);
                pre2 = pre1;
                pre1 = cur;
            }
            return pre1;
        }

        public static int case2(int [] nums, int st,int end){
            int n = end;
            if(n==st) return nums[st];
            if(n==0) return 0;

            int pre2 = nums[st];
            int pre1 = Math.max(nums[st],nums[st+1]);

            for(int i=st+2;i<=n;i++){
                int cur = Math.max(nums[i]+pre2,pre1);
                pre2 = pre1;
                pre1 = cur;
            }
            return pre1;
        }


    public static void main(String[] args) {
        System.out.println(rob(new int []{2,3,2}));
        System.out.println(rob2(new int []{1,2,3,1}));
    }
}
//LeetCode 213