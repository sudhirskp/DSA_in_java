package DP;

public class SuperEgg {

    //TC -> O(K*N)
    public int superEggDrop(int k, int n) {
        int [][] dp = new int [n+1][k+1];

        int mov = 0;

        while(dp[mov][k]<n){
            mov++;
            for(int eg = 1;eg<=k;eg++){
                dp[mov][eg] = 1 + dp[mov-1][eg-1] + dp[mov-1][eg];
            }
        }
        return mov;
    }

    // dp - binary search approach
    public int superEggDrop1(int k, int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (maxFloors(mid, k) < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int maxFloors(int moves, int eggs) {
        int floors = 0;
        int mul = 1;
        for (int i = 0; i < eggs; i++) {
            mul = mul * (moves - i) / (i + 1);
            floors += mul;
            if (floors >= Integer.MAX_VALUE / 2) return Integer.MAX_VALUE;
        }
        return floors;
    }

    public static void main(String[] args) {
        SuperEgg obj = new SuperEgg();
        System.out.println(obj.superEggDrop(2, 6));
        System.out.println(obj.superEggDrop1(2,6));
    }
}
//Leetcode 887
