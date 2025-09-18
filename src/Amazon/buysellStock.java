package Amazon;

public class buysellStock {


        public int maxProfit(int[] prices) {
            int n = prices.length;
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - minPrice);

                }
            }

            return maxProfit;
        }

    public static void main(String[] args) {
        buysellStock bb = new buysellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bb.maxProfit(prices));
    }
}
//leetCode 121
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//time complexity : O(n)
//space complexity : O(1)