package Grind75;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianDataStream {


        PriorityQueue<Integer> l; //left MaxHeap
        PriorityQueue<Integer> r; //right MinHeap
        public MedianDataStream() {
            r = new PriorityQueue<>(Collections.reverseOrder());
            l = new PriorityQueue<>();
        }

        public void addNum(int num) {
            l.offer(num);
            r.offer(l.poll());
            if(r.size()>l.size()){
                l.offer(r.poll());
            }
        }

        public double findMedian() {
            if(l.size()>r.size()){
                return l.peek();
            }else{
                return (l.peek()+r.peek())/2.0;
            }
        }


    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
        MedianDataStream medianFinder = new MedianDataStream();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}

//https://leetcode.com/problems/find-median-from-data-stream/description/
//Time Complexity: O(log n) for addNum and O(1) for findMedian
//Space Complexity: O(n) for storing the numbers in heaps.
//leetCode 295