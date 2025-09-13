package Grind75;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduling {

        public int leastInterval(char[] tasks, int n) {
            HashMap<Character,Integer> freq = new HashMap<>();
            for(char c : tasks){
                freq.put(c,freq.getOrDefault(c,0)+1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(b[0]-a[0]));

            for(Character ch : freq.keySet()){
                pq.offer(new int []{freq.get(ch),0});
            }

            Queue<int []> que = new LinkedList<>();

            int time =0;
            while(!que.isEmpty() || !pq.isEmpty()){
                time++;
                if(!pq.isEmpty()){
                    int [] task = pq.poll();
                    int tasfreq = task[0];
                    int et = task[1];

                    tasfreq--;
                    if(tasfreq>0){
                        et = time + n;
                        que.offer(new int []{tasfreq,et});
                    }

                }
                if(!que.isEmpty() && que.peek()[1]==time){
                    pq.offer(que.poll());
                }

            }

            return time;
        }


    public static void main(String[] args) {
            int n = 2;
            char [] tasks = {'A','A','A','B','B','B'};
            TaskScheduling taskScheduling = new TaskScheduling();
            System.out.println(taskScheduling.leastInterval(tasks,n));
    }
}

//leetCode 621
//https://leetcode.com/problems/task-scheduler/description/
//medium
//time complexity : O(nlogn)
//space complexity : O(n)
