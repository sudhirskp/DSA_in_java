package Stack;

public class Mystk{
    int [] stack ;
    int top = -1;
    int size;
    Mystk(int size){
        this.size = size;
        stack = new int[size];
    }
    public void push(int data){
        if (top == size - 1){
            System.out.println("Stack is full");
        }else {
            top++;
            stack[top] = data;
        }
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }else {
            System.out.println(stack[top]);
        }
    }

    public void pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }else {
            System.out.println(stack[top]);
            top--;
        }
    }

    public boolean isEmpty(){
        if (top == -1){
            System.out.println("Stack is empty");
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Mystk mystk = new Mystk(5);
        mystk.push(10);
        mystk.push(20);
        mystk.push(30);
        mystk.push(40);
        mystk.push(50);
        mystk.push(60);
        mystk.peek();
        mystk.pop();
        mystk.pop();
        mystk.pop();
    }
}
