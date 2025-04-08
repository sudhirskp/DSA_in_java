package Queue;

import java.util.Stack;

public class Queue_using_Stack {
    Stack<Integer> s1 = new Stack<>(); //input stack
    Stack<Integer> s2 = new Stack<>();


    //------------------------------------------------------
    //when enqeue is called max time and dequeue is called min time
//    public void enqueue(int x){
//        s1.push(x);
//    }
//
//    public int dequeue(){
//        if(s1.isEmpty()) return -1;
//        while(!s1.isEmpty()){
//                s2.push(s1.pop());
//            }
//        if(s2.isEmpty()){
//            System.out.println("Queue is empty");
//            return -1;
//        }
//        int val =  s2.pop();
//        while(!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
//        return val;
//    }
//
//    public int peek(){
//        if(s1.isEmpty()) return -1;
//        while(!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//        if(s2.isEmpty()){
//            System.out.println("Queue is empty");
//            return -1;
//        }
//        int val =  s2.peek();
//        while(!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
//        return val;
//    }

    //------------------------------------------------------



    public void enqueue(int x){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int dequeue(){
        if(s1.isEmpty()) return -1;
        return s1.pop();
    }

    public int peek(){
        if(s1.isEmpty()) return -1;
        return s1.peek();
    }
    public static void main(String[] args) {
        Queue_using_Stack ob = new Queue_using_Stack();

        ob.enqueue(10);
        ob.enqueue(20);
        ob.enqueue(30);
        ob.enqueue(40);
       // ob.dequeue();

        System.out.println(ob.peek());

    }
}
