package Queue;

public class Deque {
    int front;
    int rear;
    int size;
    int queue[];
    int capacity;

    Deque(int capacity) {
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
        if ((front == 0 && rear == capacity - 1) || (front != 0 && (rear == (front - 1) % capacity)))
            return true; // for circular queue
        else return false;
    }

    public int size() {
        return size;
    }

    public void enqueueRear(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1 && front != 0) { // for circular queue
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = val;
        size++;
    }

    public void enqueueFront(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0 && rear != capacity-1) {
            front = capacity-1;
        } else {
            front--;
        }
        queue[front] = val;
        size++;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) { // for circular queue
            front = 0;
        } else {
            front++;
        }
        size--;
        return val;
    }

    public int dequeueRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = queue[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
        size--;
        return val;
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // or any other error value
        }
        return queue[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // or any other error value
        }
        return queue[rear];
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        if (rear <= front) {
            for (int i = front; i <= capacity - 1; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        } else { // normal case
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //one problem  with this queue is that it is not circular and not dynamic
        Deque q = new Deque(5);
        q.enqueueRear(10);
        System.out.println(q.peekFront());
        q.enqueueRear(20);
        q.enqueueRear(30);
        q.enqueueRear(40);
        q.enqueueRear(50);
        System.out.println(q.isFull());
        q.enqueueRear(60);
        q.enqueueRear(70);
        q.enqueueRear(80);
        q.enqueueRear(90);
        q.enqueueRear(100);
        q.display();
        System.out.println("Peek : " + q.peekRear());
        System.out.println("Dequeue : " + q.dequeueFront());
        System.out.println("Dequeue : " + q.dequeueFront());
        System.out.println("Dequeue : " + q.dequeueFront());
        q.display();
        System.out.println("Size : " + q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.enqueueRear(101);
        q.display();
        q.enqueueRear(102);
        q.display();
        q.enqueueRear(103);
        q.display();
        System.out.println(q.isFull());
        q.enqueueRear(104);
    }
}
