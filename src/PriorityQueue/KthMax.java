package PriorityQueue;

import java.util.PriorityQueue;

public  class KthMax {
    public static void main(String[] args) {
        int [] a={1,2,10,2,20,33};
        int k=3;
        KthMax ob = new KthMax();
        ob.Max(a,k);

    }
    public void Max(int []a,int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int i=0;
        while(i<k){
            pq.add(a[i]);
            i++;
        }
        while(i<a.length) {
            if (a[i] > pq.peek()){
                pq.remove();
                pq.add(a[i]);
            }
            i++;
        }
            while(pq.size()>0){
                System.out.println(pq.remove());
            }

        }
    }
