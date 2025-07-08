package Interview_prep;

import java.util.HashMap;

public class getPairsCount {


    // 1st approach to solve the question
    public int pairsCount(int arr[] , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count =0;
        for(int val : arr){
            map.put(val , map.getOrDefault(val,0)+1);
        }
        for(int i=0;i<arr.length;i++){
            if(k<arr[i]) continue;
            int p1 = k-arr[i];
            if(map.containsKey(p1)){
                count+= map.get(p1);
                map.put(arr[i], map.get(arr[i])-1);
            }
            if(p1 == arr[i]){
                count--;
            }
        }
        return count;
    }

    // second approach ---

    public int pairsCount2(int arr[] , int k) {
        int ans =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if(val>k) continue;
            int secondval = k-val;
            ans += map.getOrDefault(secondval, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        getPairsCount ob = new getPairsCount();
        int arr[] = {1, 5, 7, 1};
        int pair = ob.pairsCount(arr, 6);
        System.out.println(pair);
        System.out.println(ob.pairsCount2(arr , 6));

    }
}
