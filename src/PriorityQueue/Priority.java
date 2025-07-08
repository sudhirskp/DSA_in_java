package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Priority {
    public static void main(String[] args) {
        PriorityQueue<Integer> pr = new PriorityQueue<>(Collections.reverseOrder()); //for revers the preferance of the priorty -Collection.reverseOrder
        //add- 0(logn)
        pr.add(1);
        pr.add(10);
        pr.add(15);
        pr.add(39);
        pr.add(99);

        //get -peek()- 0(1)
        System.out.println(pr.peek());

        //remove - 0(logn)

        System.out.println(pr.remove());
        System.out.println(pr.remove());
        System.out.println(pr.remove());

        //size  -0(logn)
        System.out.println(pr.size());

    }
}
