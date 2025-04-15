package HashMap_HashSet;

import java.util.HashMap;

public class LargestSubArrayOf01 {

    public int maxLen(int[] arr) {
        // Your code here
        int n = arr.length;
        int maxlen =0;
        int sum =0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                sum+=arr[i]-1;
            }else{
                sum+=arr[i];
            }
            int find = sum - 0;
            if(map.containsKey(find)){
                int len = i-map.get(find);
                maxlen = Math.max(maxlen , len);
            }
            if(!map.containsKey(find)){
                map.put(find , i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        //int arr [] = {1, 0, 1, 1, 1, 0, 0};
        //int arr[] = {0, 0, 1, 1, 0};
        int arr [] = {0};

        LargestSubArrayOf01 ob = new LargestSubArrayOf01();
        System.out.println(ob.maxLen(arr));
    }
}


//Largest subarray of 0's and 1's
//Difficulty: EasyAccuracy: 32.96%Submissions: 119K+Points: 2Average Time: 20m
//Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
//
//        Examples:
//
//Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
//Output: 6
//Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
//        Input: arr[] = [0, 0, 1, 1, 0]
//Output: 4
//Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
//        Input: arr[] = [0]
//Output: 0
//Explnation: There is no subarray with an equal number of 0s and 1s.