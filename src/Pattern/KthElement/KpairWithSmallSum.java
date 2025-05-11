package Pattern.KthElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KpairWithSmallSum {

    static class Ind{
        int ind1;
        int ind2;
        Ind(int ind1 , int ind2){
            this.ind1 = ind1;
            this.ind2 = ind2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<Ind> que = new PriorityQueue<>((pair1, pair2) ->
                Integer.compare(nums1[pair1.ind1] + nums2[pair1.ind2], nums1[pair2.ind1] + nums2[pair2.ind2])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            que.offer(new Ind(i,0));
        }
        while (!que.isEmpty() && k-- > 0) {
            Ind index = que.poll();
            int x = index.ind1;
            int y = index.ind2;
            res.add(Arrays.asList(nums1[x], nums2[y]));
            if (y + 1 < nums2.length) {
                que.offer(new Ind(x,y+1));
            }
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) ->
                (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            que.offer(new int[] { i, 0 });
        }

        while (k-- > 0 && !que.isEmpty()) {
            int[] index = que.poll();
            int x = index[0], y = index[1];
            res.add(Arrays.asList(nums1[x], nums2[y]));
            if (y + 1 < nums2.length) {
                que.offer(new int[] { x, y + 1 });
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int nums1[] = {1,7,11};
        int nums2[] = {2,4,6};
        int k = 3;
        KpairWithSmallSum kpairWithSmallSum = new KpairWithSmallSum();
        List<List<Integer>> res = kpairWithSmallSum.kSmallestPairs1(nums1, nums2, k);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i) + " ");
        }
    }
}

// 373. Find K Pairs with Smallest Sums
