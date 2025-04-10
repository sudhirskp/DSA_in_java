package Tree;

public class MinHeap {
    int[] heap;
    int heapsize;
    int capacity;

    MinHeap(int[] arr) {
        capacity = arr.length;
        heap = new int[capacity];
        heapsize = arr.length;
        System.arraycopy(arr, 0, heap, 0, arr.length);
        buildHeap();
    }

    public void increaseCapacity() {
        int[] temp = new int[capacity * 2];
        System.arraycopy(heap, 0, temp, 0, heapsize);
        heap = temp;
        capacity = capacity * 2;
    }

    public void heapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < heapsize && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < heapsize && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            heapify(smallest);
        }
    }

    public void buildHeap() {
        for (int i = heapsize / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int extractMin() {
        if (heapsize == 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        int min = heap[0];
        heap[0] = heap[heapsize - 1];
        heapsize--;
        heapify(0);
        return min;
    }

    public void printHeap() {
        for (int i = 0; i < heapsize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= heapsize || heap[index] < newValue) {
            System.out.println("Invalid index");
            return;
        }
        heap[index] = newValue;
        heapify(index);
    }

    public void decreaseKey(int index, int newValue) {
        if (index < 0 || index >= heapsize || heap[index] <= newValue) {
            System.out.println("Invalid index");
            return;
        }
        heap[index] = newValue;
        while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
            int temp = heap[index];
            heap[index] = heap[(index - 1) / 2];
            heap[(index - 1) / 2] = temp;
            index = (index - 1) / 2;
        }
    }

    public void insert(int newValue) {
        if (heapsize == capacity) {
            increaseCapacity();
        }
        heapsize++;
        int index = heapsize - 1;
        heap[index] = newValue;
        while (index > 0 && heap[(index - 1) / 2] > heap[index]) {
            int temp = heap[index];
            heap[index] = heap[(index - 1) / 2];
            heap[(index - 1) / 2] = temp;
            index = (index - 1) / 2;
        }
    }

    public int[] heapSort() {
        buildHeap();
        int size = heapsize;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = extractMin();
        }
        return res;
    }

    public static void main(String[] args) {
        MinHeap ob = new MinHeap(new int[]{10, 5, 20, 6, 11});
        ob.printHeap();
        int[] res = ob.heapSort();
        for (int i = res.length - 1; i >= 0; i--) {
            System.out.print(res[i] + " ");
        }
    }
}