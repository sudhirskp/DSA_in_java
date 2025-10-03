package DSA_Sheet.Uber;

import java.util.ArrayDeque;
import java.util.Deque;

public class NeedTImeToBuyTicket {

        //brute force approach //TC - O(n*m) , SC - O(n)
        public int timeRequiredToBuy1(int[] tickets, int k) {
            int n = tickets.length;
            Deque<int[]> que = new ArrayDeque<>();
            for(int i=0;i<n;i++){
                que.offerLast(new int []{tickets[i],i});
            }

            // while(!que.isEmpty()){
            //     int [] arr = que.removeFirst();
            //     System.out.print(Arrays.toString(arr));
            // }

            int count =0;
            while(!que.isEmpty()){
                int [] arr = que.removeFirst();
                int val = arr[0];
                int index = arr[1];

                if(index==k && val==0){
                    return count;
                }

                //System.out.print(index);
                if(val>0){
                    count++;
                    que.offerLast(new int []{--val,index});

                }


            }
            return count;
        }

        //optimized approach //TC - O(n) , SC - O(1)
        public int timeRequiredToBuy(int[] tickets, int k) {
            int time = 0;
            for (int i = 0; i < tickets.length; i++) {
                if (i <= k) {
                    time += Math.min(tickets[i], tickets[k]);
                } else {
                    time += Math.min(tickets[i], tickets[k] - 1);
                }
            }
            return time;
        }

    public static void main(String[] args) {
        NeedTImeToBuyTicket ob = new NeedTImeToBuyTicket();
        int[] tickets = {2,3,2};
        int k = 2;
        System.out.println(ob.timeRequiredToBuy(tickets,k));
    }
}
// link - https://leetcode.com/problems/time-needed-to-buy-tickets/description/
// leetCode : 2073