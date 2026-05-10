package Array;

public class Inversion {

    static int inversionCount(int arr[]) {
        // Code Here
        return MergeSort(arr,0,arr.length-1);
    }

    static int MergeSort(int [] arr, int l, int r){
        if(l>=r) return 0;
        int count = 0;
        int mid = l + (r-l)/2;

        count+=MergeSort(arr,l,mid);
        count +=  MergeSort(arr,mid+1,r);
        count += merge(l,r,mid,arr);

        return count;
    }

    static int merge(int l, int r, int mid, int [] arr){

        int n1 = mid-l+1;
        int n2 = r - mid;

        int [] left = new int [n1];
        int [] right = new int [n2];

        for(int i =0;i<n1;i++){
            left[i] = arr[l+i];
        }

        for(int i =0;i<n2;i++){
            right[i] = arr[mid+1+i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        int count = 0;

        while(i<n1 && j<n2){

            if(left[i]<=right[j]){
                arr[k] = left[i++];
            }else{
                arr[k] = right[j++];
                count+=(n1-i);
            }
            k++;
        }

        while(i<n1){
            arr[k++] = left[i++];
        }

        while(j<n2){
            arr[k++] = right[j++];
        }
        return count;
    }

    public static void main(String[] args) {
        Inversion obj = new Inversion();
        System.out.println(obj.inversionCount(new int [] {2,4,1,3,5}));
    }
}
//https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1