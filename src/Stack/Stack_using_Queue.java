package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_using_Queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();



    public void push(int x){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public int pop(){
        if(q1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.poll();
    }

    public int peek(){
        if(q1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }
    public static void main(String[] args) {
        Stack_using_Queue ob = new Stack_using_Queue();
        ob.push(1);
        ob.push(2);
        ob.push(3);
        System.out.println(ob.pop());
        System.out.println(ob.peek());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
    }
}
