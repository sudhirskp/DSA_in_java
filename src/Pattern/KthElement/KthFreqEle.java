package Pattern.KthElement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Number implements Comparable<Number>{
    int element;
    int freq;
    Number(int element, int freq){
        this.element = element;
        this.freq = freq;
    }
    public int compareTo(Number that){
        return this.freq - that.freq;
    }
}

public class KthFreqEle {

    public int[] topKFrequent1(int[] nums, int k) {
        PriorityQueue<Number> que = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Number num = new Number(entry.getKey(), entry.getValue());
            que.offer(num);
            if (que.size() > k) {
                que.poll();
            }
        }
        int res[] = new int[k];
        int index = 0;
        while (index < k) {
            Number e = que.poll();
            res[index++] = e.element;
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            que.offer(entry);
            if (que.size() > k) {
                que.poll();
            }
        }

        int res[] = new int[k];
        int i = 0;
        while (!que.isEmpty()) {
            res[i++] = que.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        KthFreqEle kthFreqEle = new KthFreqEle();
        int[] res = kthFreqEle.topKFrequent1(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

//347. Top K Frequent Elements
//Solved
//        Medium
//Topics
//        Companies
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//
//
//
//        Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]
