package Sorting;

public class PigeonHole {

    public void pigeonHole(int [] arr){
        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int range = max-min+1;
        int [] holes = new int[range];
        //Count the frequency of each element
        for(int i=0;i<n;i++){
            holes[arr[i]-min]++;
        }

        int index = 0;
        for(int i=0;i<range;i++){
            while(holes[i]>0){
                arr[index] = i+min;
                index++;
                holes[i]--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {8,3,2,7,4,6,8};
        PigeonHole ph = new PigeonHole();
        ph.pigeonHole(arr);
    }
}
