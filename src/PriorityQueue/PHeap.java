package PriorityQueue;

import java.util.PriorityQueue;

class  newStudent implements  Comparable<newStudent>{
    int id;
    String name;
    int marks;
    newStudent(int id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(newStudent that) {
        //return this.marks - that.marks;  // increasing
        if(this.marks== that.marks){
            return this.name.compareTo(that.name); //lexicographically -
        }
        return that.marks - this.marks; //decreasing

    }

    @Override
    public String toString() {
        return "Student " + this.id +" "+ this.name +" "+ this.marks;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof newStudent){
            newStudent that = (newStudent) obj; //typecasting type safety
            return this.id == that.id;
        }
        return super.equals(obj);
    }
}
public class PHeap {



    public static void main(String[] args) {
        PriorityQueue<newStudent> que = new PriorityQueue<>();
        que.offer(new newStudent(1,"sudhir",100));
        que.offer(new newStudent(2,"shaktiman",90));
        System.out.println(que.peek());
        System.out.println(que.contains(new newStudent(1,"sudhir",100)));


    }
}
