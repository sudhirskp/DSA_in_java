package Searching;


//by training class
public class Linear_Search {
    int arr [];

    Linear_Search(int size){
        arr = new int[size];
    }
    public void insertVal(int [] arr) {
        this.arr = arr;
    }

    public int linear(int arr[] , int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Linear_Search ob = new Linear_Search(10);
        ob.insertVal(new int []{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(ob.linear(new int[]{1, 2, 3, 4, 5}, 5));
        ob.display(); // Display the instance array
    }
}
