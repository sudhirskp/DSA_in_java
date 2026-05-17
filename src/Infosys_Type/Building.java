package Infosys_Type;
import java.util.PriorityQueue;
public class Building {

    //TC:O(nlogk) //SC:O(k)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i =0;i<n-1;i++) {
            int diff = heights[i+1] - heights[i];
            if (diff > 0) {

                que.offer(diff);

                if (que.size() > ladders) {
                    bricks -= que.poll();
                }

                if (bricks < 0) {
                    return i;
                }
            }
        }
        return n-1;
    }

    public static void main(String[] args) {
        Building ob = new Building();
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(ob.furthestBuilding(heights,bricks,ladders));
    }
}
//https://leetcode.com/problems/furthest-building-you-can-reach/
//LeetCode 1642