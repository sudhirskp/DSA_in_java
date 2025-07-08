package HashMap_HashSet;

import java.util.ArrayList;
import java.util.HashMap;


//wrong answer not by me
public class sumPairWith0Sum {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int num : arr){
            int complement = -num; // Find the number that sums to 0 with the current number
            if (map.containsKey(complement) && !map.get(complement)) {
                // Add the pair in sorted order
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(Math.min(num, complement));
                pair.add(Math.max(num, complement));
                ans.add(pair);

                // Mark both numbers as used
                map.put(complement, true);
                map.put(num, true);
            } else if (!map.containsKey(num)) {
                map.put(num, false); // Mark the number as unused
            }
        }

        // Sort the result list
        ans.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });

        return ans;
    }

    public static void main(String[] args) {
        int arr [] = {-1, 0, 1, 2, -1, -4};
        //int arr [] = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        sumPairWith0Sum ob = new sumPairWith0Sum();
        ArrayList<ArrayList<Integer>> ans = ob.getPairs(arr);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}

//Two sum Pairs with 0 Sum
//Difficulty: EasyAccuracy: 31.49%Submissions: 479K+Points: 2Average Time: 20m
//Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
//
//Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.
//
//Examples:
//
//Input: arr = [-1, 0, 1, 2, -1, -4]
//Output: [[-1, 1]]
//Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
//arr[2] + arr[4] = 1 + (-1) = 0.
//The distinct pair are [-1,1].
