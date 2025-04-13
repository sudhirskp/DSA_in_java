package HashSet;

import java.util.Arrays;
import java.util.HashSet;

public class NoOFSubset {


    //1st approach
    public int freq(int arr[]){
        int [] count = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int count1 = 0;
        for(int j=0;j<arr.length;j++){
            count1 = Math.max(count1 , count[j]);
        }
        return count1;
    }

    //2nd approach

    public int noOfSubset(int arr[] ){
        boolean visited [] = new boolean[arr.length+1];
        Arrays.fill(visited , false);
        int count =0;
        for(int i=0;i<arr.length;i++){
           if(visited[i]){
               continue;
           }
           count++;
           HashSet<Integer> set = new HashSet<>();
           for(int j=i;j<arr.length;j++){
               if(visited[j] || set.contains(arr[j])){
                   continue;
               }
               visited[j] = true;
               set.add(arr[j]);

           }
        }
        return count;
    }


    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};
        NoOFSubset ob = new NoOFSubset();
        System.out.println(ob.freq(arr));
        System.out.println(ob.noOfSubset(arr));
    }
}

//You are given an array of n-element. You have to make subsets from the array such that no subset contain duplicate elements. Find out minimum number of subset possible.
//
//        Examples :
//
//Input : arr[] = {1, 2, 3, 4}
//Output :1
//Explanation : A single subset can contain all values and all values are distinct.
//
//Input : arr[] = {1, 2, 3, 3}
//Output : 2
//Explanation : We need to create two subsets {1, 2, 3} and {3} [or {1, 3} and {2, 3}] such that both subsets have distinct elements.
