package LinkedList;

class Dnode<T> {
    T data;
    Dnode<T> prev;
    Dnode<T> next;

    Dnode() {}

    public Dnode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedOpr {
    private Dnode<Integer> head;
    int size = 0;

    public static void main(String[] args) {
        DoublyLinkedOpr ob = new DoublyLinkedOpr();
        ob.AddHead(5);
        ob.Addend(10);
        ob.AddHead(48);
        ob.AddHead(55);
        ob.display();
//        ob.AddHead(54);
//        ob.Addspecif(4, 4);
//        ob.deleteHead();
//        ob.deleteEnd();
//        ob.deleteSpecific(4);
//        ob.update(2, 100);
//        ob.update(4, 3);
//        ob.display();
//        ob.search(4);
    }

    // Add a node at the head
    public void AddHead(int data) {
        Dnode<Integer> newNode = new Dnode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add a node at the end
    public void Addend(int data) {
        Dnode<Integer> newNode = new Dnode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Dnode<Integer> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        size++;
    }

    // Add a node at a specific position
    public void Addspecif(int data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Position out of bounds.");
            return;
        }
        if (position == 1) {
            AddHead(data);
            return;
        }
        Dnode<Integer> newNode = new Dnode<>(data);
        Dnode<Integer> temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }

    // Display the linked list
    public void display() {
        Dnode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Size of Linked List: " + size);
    }

    // Delete the head node
    public void deleteHead() {
        if (head == null) {
            System.out.println("Head is already null");
            return;
        }
        Dnode<Integer> temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        temp.next = null;
        size--;
    }

    // Delete the end node
    public void deleteEnd() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Dnode<Integer> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }
        size--;
    }

    // Delete a node at a specific position
    public void deleteSpecific(int position) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        if (position < 1 || position > size) {
            System.out.println("Position out of bounds.");
            return;
        }
        if (position == 1) {
            deleteHead();
            return;
        }
        Dnode<Integer> temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        temp.next = null;
        temp.prev = null;
        size--;
    }

    // Update a node at a specific position
    public void update(int position, int value) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        if (position < 1 || position > size) {
            System.out.println("Position out of bounds.");
            return;
        }
        Dnode<Integer> temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        temp.data = value;
    }

    // Search for a value in the linked list
    public void search(int value) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        int counter = 1;
        Dnode<Integer> temp = head;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value found at position: " + counter);
                return;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Value not found");
    }
}