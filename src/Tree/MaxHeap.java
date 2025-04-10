package Tree;

public class MaxHeap {
    int [] arr  = new int [] {10,5,20,6,11};
    int [] heap;
    int heapsize;
    int capacity;

    MaxHeap(int[] arr){
        heap = arr;
        heapsize = arr.length;
        capacity = arr.length;
    }

    // for the insertion logic increase the capacity
    public void increaseCapacity(){
        int [] temp = new int[capacity*2];
        for(int i = 0; i < heapsize; i++){
            temp[i] = heap[i];
        }
        heap = temp;
        //capacity = capacity*2;
    }

    //it is for maxHeap

    public void heapify(int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largest = index;

        if(left < heapsize && heap[left] > heap[largest]){
            largest = left;
        }

        if(right < heapsize && heap[right] > heap[largest]){
            largest = right;
        }

        if(largest != index){
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }
    }


    public void buildHeap(){
        //leaf node index = n/2 to n-1
        //non-leaf node index = 0 to n/2 - 1
        //leaf node is already a heap
        //so we start from n/2 - 1 to 0
        for(int i = heapsize/2 - 1; i >= 0; i--){
            heapify(i);
        }
    }


    //root element is always the max element in the heap[0]
    //extract max function to remove the max element from the heap

    public int extractMax(){
        if(heapsize == 0){
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        int max = heap[0];
        heap[0] = heap[heapsize - 1];
        heapsize--;
        heapify(0);
        return max;
    }

    public void printHeap(){
        for(int i = 0; i < heapsize; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
    }

    //go to the particuler index and update the value

    //to increase the value of the particuler index
    public void increaseKey(int index , int newValue){
        if(index < 0 || index >= heapsize || heap[index]> newValue){
            System.out.println("Invalid index");
            return;
        }
        heap[index] = newValue;
        int parent = (index - 1)/2;
        //parent = (int)Math.ceil((index/2.0)-1);
        while(index > 0 && heap[parent] < heap[index]){
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            parent = (index - 1)/2;
        }
    }

    //to decrease the value of the particuler index

    public void decreseKey(int index , int newValue){
        if(index < 0 || index >= heapsize || heap[index] <= newValue){
            System.out.println("Invalid index");
            return;
        }
        heap[index] = newValue;
        heapify(index);
    }
    // insert new  value

    public void insert(int newValue){
        if(heapsize+1>=capacity){
            increaseCapacity();
        }
        heapsize++;
        heap[heapsize-1] = newValue;
        int index = heapsize - 1;
        int parent = (int)Math.ceil((index/2.0)-1);
        while(index > 0 && heap[parent] < heap[index]){
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
        }
    }

    public int [] heapSort(){
        buildHeap();
        int size = heapsize;
        int [] res = new int [size];
        for(int i=0;i<size;i++){
            res[i] = extractMax();
        }
        return res;
    }



    public static void main(String[] args) {
        MaxHeap ob = new MaxHeap(new int [] {10,5,20,6,11});
//        ob.buildHeap();
//        ob.printHeap();
//       // System.out.println("deleted max val -> " + ob.extractMax());
//        //ob.printHeap();
//        System.out.println("after increasing the value of the index 4");
//        ob.increaseKey(4, 15);
//        ob.printHeap();
//        System.out.println("after decreasing the value of the index 2");
//        ob.decreseKey(2, 3);
//        ob.printHeap();
//        System.out.println("after inserting the value 25");
//        ob.insert(25);
//        ob.printHeap();

        ob.printHeap();
        int []  res = ob.heapSort();
        for(int i=res.length-1;i>=0;i--){
            System.out.print(res[i] + " ");
        }

    }
}
