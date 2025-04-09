package Sorting;

public class CycleSort {

    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public void display(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //variation of cycle sort
    public void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int ele = arr[i];
            //int actualPos = ele; // This is the correct way to find the actual position if having 0 based index
            int actualPos = ele - 1;
            if (arr[i] < arr.length && arr[i] != arr[actualPos]) {
                swap(arr, i, actualPos);
            } else {
                i++;
            }
        }
    }

    //original cycle sort
    public void cycleSort1(int[] arr) {
        int n = arr.length;
       for(int cycle =0;cycle<n;cycle++){
           int pos = cycle;
           int item = arr[cycle];
           //finding smaller element
           for(int i=cycle+1;i<n;i++){
               if(arr[i]<item){
                   pos++;
               }
           }
           if(pos==cycle){
               continue;
           }
           //passing duplicate element
           while(arr[pos]==item){
               pos++;
           }
           if(pos!=cycle){
               int temp = arr[pos];
               arr[pos] = item;
               item = temp;
           }

           while(pos!=cycle){
               pos = cycle;
               for(int i=cycle+1;i<n;i++){
                   if(arr[i]<item){
                       pos++;
                   }
               }
               while(arr[pos]==item){
                   pos++;
               }
               if(arr[pos]!=item){
                   int temp = arr[pos];
                   arr[pos] = item;
                   item = temp;
               }
           }
       }
    }

    public static void main(String[] args) {
        int [] arr = {3, 5, 2, 1, 4}; //if we add 0 at the place of 2 then it is not working
        CycleSort cs = new CycleSort();
        //cs.cycleSort(arr);
        cs.cycleSort1(arr);
        cs.display(arr);
    }
}
