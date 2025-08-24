package GreedyAlgo;

import java.util.ArrayList;
import java.util.List;

public class Police_thief {

        public int catchThieves(char[] arr, int k) {
            // code here
            List<Integer> pol = new ArrayList<>();
            List<Integer> th = new ArrayList<>();

            for(int i=0;i<arr.length;i++){
                if(arr[i]=='P'){
                    pol.add(i);
                }else{
                    th.add(i);
                }
            }

            int i=0;
            int j =0;
            int count =0;

            while(i<pol.size() && j<th.size()){
                int diff = Math.abs(pol.get(i)-th.get(j));

                if(diff<=k){
                    count++;
                    i++;
                    j++;
                }else if(pol.get(i)<th.get(j)){
                    i++;
                }else{
                    j++;
                }
            }

            return count;
        }

        //without using extra space

        static int catchThieves(char arr[], int n, int k)
        {
            // Code here
            int i=-1;
            int j=-1;
            for(int m=0;m<n;m++){
                if(i==-1 &&arr[m] == 'P') i=m;
                if(j==-1 &&arr[m] == 'T') j=m;
                if(i!=-1 && j!=-1) break;
            }
            if(i==-1 || j==-1) return 0;

            int caught=0;
            while(i<n && j<n){
                if(Math.abs(i-j) <= k) { // next police and thief
                    caught++;
                    i++;
                    while(i<n && arr[i]!='P') i++;
                    j++;
                    while(j<n && arr[j]!='T') j++;
                }
                else if(i<j){ //next police
                    i++;
                    while(i<n && arr[i]!='P') i++;
                }else{ //next thief
                    j++;
                    while(j<n && arr[j]!='T') j++;
                }
            }
            return caught;
        }

    public static void main(String[] args) {
            char [] arr = {'P','T','T','P','T'};
            int k =1;
            Police_thief obj = new Police_thief();
            System.out.println(obj.catchThieves(arr,k));
            System.out.println(catchThieves(arr,arr.length,k));
    }
}
