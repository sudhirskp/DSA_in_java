package Queue;

public class Circuler_queue {
    int front;
    int rear;
    int size;
    int queue[];
    int capacity;

    Circuler_queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        if (front == -1) return true;
        else return false;
    }

    public boolean isFull() {
        if ((front == 0 && rear== capacity - 1) || (front!=0 && (rear == (front - 1)%capacity))) return true; // for circular queue
        else return false;
    }

    public int size() {
        return size;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if(rear == capacity - 1 && front != 0){ // for circular queue
            rear=0;
        }else {
            rear++;
        }
        queue[rear] = val;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if(front == capacity - 1){ // for circular queue
            front=0;
        }else{
            front++;
        }
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // or any other error value
        }
        return queue[front];
    }

    public void display() {

        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        if(rear<=front){
            for(int i=front;i<=capacity-1;i++){
                System.out.print(queue[i]+" ");
            }
            for(int i=0;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }else{ // normal case
            for(int i=front;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //one problem  with this queue is that it is not circular and not dynamic
        Circuler_queue q = new Circuler_queue(5);
        q.enqueue(10);
        System.out.println(q.peek());
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.isFull());
        q.enqueue(60);
        q.enqueue(70);
        q.enqueue(80);
        q.enqueue(90);
        q.enqueue(100);
        q.display();
        System.out.println("Peek : "+q.peek());
        System.out.println("Dequeue : "+q.dequeue());
        System.out.println("Dequeue : "+q.dequeue());
        System.out.println("Dequeue : "+q.dequeue());
        q.display();
        System.out.println("Size : "+q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.enqueue(101);
        q.display();
        q.enqueue(102);
        q.display();
        q.enqueue(103);
        q.display();
        System.out.println(q.isFull());
        q.enqueue(104);
    }
}
