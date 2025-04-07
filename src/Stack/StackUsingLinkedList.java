package Stack;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {

    public Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int poppedData = top.data;
            top = top.next;
            return poppedData;
        }
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return top.data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop());  // 30
        System.out.println(stack.pop());  // 20
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.pop());  // 10
        System.out.println(stack.isEmpty()); // true
    }
}