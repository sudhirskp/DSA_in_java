package Queue;

public class Deque_single {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    Deque_single(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return true;
        } else return false;
    }

    public boolean isFull() {
        if (size == capacity) {
            System.out.println("Queue is Full");
            return true;
        } else {
            return false;
        }
    }

    public void pushFront(int val) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1; // Wrap around
        } else {
            front--;
        }
        arr[front] = val;
        size++;
    }

    public void pushRear(int val) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0; // Wrap around
        } else {
            rear++;
        }
        arr[rear] = val;
        size++;
    }

    public int popFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = arr[front];
        if (front == rear) { // Single element
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0; // Wrap around
        } else {
            front++;
        }
        size--;
        return val;
    }

    public int popRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = arr[rear];
        if (front == rear) { // Single element
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1; // Wrap around
        } else {
            rear--;
        }
        size--;
        return val;
    }

    public static void main(String[] args) {
        Deque_single deque = new Deque_single(5);
        deque.pushRear(10);
        deque.pushRear(20);
        deque.pushFront(5);
        deque.pushFront(1);
        System.out.println(deque.popFront()); // 1
        System.out.println(deque.popRear());  // 20
    }
}