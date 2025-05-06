package LinkedList;


class Node<T>{
    T data;
    Node<T> next;

    Node(){
    }
    Node(T data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedOpr {
    private Node<Integer> head;
    int size=0;
    public static void main(String[] args) {

        LinkedOpr ob = new LinkedOpr();

        ob.AddHead(5);
        ob.Addend(10);
        ob.AddHead(48);
        ob.AddHead(55);
        ob.AddHead(54);
        ob.Addspecif(4,4);
        ob.deleteHead();
        ob.deleteEnd();
        ob.deleteSpecific(4);
        ob.update(2,100);
        ob.update(4,3);
        ob.display();

        ob.search(4);

    }
    //---------------------------------------------------------------------
    public void AddHead(int data){
        Node<Integer> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void Addend(int data){
        Node<Integer> newNode = new Node<>(data);
        if(head==null) {
            head = newNode;
            size++;
        }else{
            Node<Integer> temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
        }
    }

    public void Addspecif(int data , int position){
        Node<Integer> newNode = new Node<>(data);
        Node<Integer>  temp;
        temp = head;
        if(position==1) {
            AddHead(data);
            size++;
        }
        else{
            for(int i=1;i<position-1;i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
    //---------------------------------------------------------------------
    public void display(){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");

        System.out.println("size of Linked List : " + size);
    }
    //---------------------------------------------------------------------
    public void deleteHead(){
        if(head==null){
            System.out.println("Head is Already null");
        }
        Node<Integer> temp;
        temp = head;
        head=head.next;
        temp.next=null;
        size--;
    }

    public void deleteEnd(){
        if(head==null){
            System.out.println("Linked List is Empty");
        }
        //to handle the single node
        if(head.next==null){
            head=null;
            size--;
        }
        Node<Integer> temp;
        Node<Integer> pre = null;
        temp = head;
        while(temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        pre.next=null;
        size--;
    }

    public void deleteSpecific(int position){
        //to check LinkedList
        if(head==null){
            System.out.println("Linked list is Empty");
            return;
        }
        if(position==1) {
            deleteHead();
        }else if(position==size){
            deleteEnd();
        }else {
            int counter = 1;
            Node<Integer> temp = head;
            Node<Integer> pre = null;

            while (counter < position && temp != null) {
                counter++;
                pre = temp;
                temp = temp.next;
            }
            if (temp != null) {
                pre.next = temp.next;
                temp.next = null;
                size--;
            }
        }
    }

    //---------------------------------------------------------------------

    public void update(int position , int value){
        if(head==null) {
            System.out.println("Linked list is Empty");
        }
        int counter = 1;
        Node<Integer> temp = head;
        while(counter < position && temp!=null){
            counter++;
            temp=temp.next;
        }
        if(position==counter && temp!=null){
            temp.data = value;
        }else{
            System.out.println("Position is not valid for Update");
        }
    }

    public void search(int value){
        if(head==null){
            System.out.println("Linked List is Empty");
        }
        int counter =1;
        Node<Integer> temp=head;
        while(temp!=null) {
            if (temp.data == value) {
                System.out.println("Value found at position : " + counter);
                return;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Value not found");
    }
}




