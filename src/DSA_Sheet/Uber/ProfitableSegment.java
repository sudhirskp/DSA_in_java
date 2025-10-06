package DSA_Sheet.Uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfitableSegment {

        // Counts the number of contiguous segments (subarrays) that contain exactly targetPremiums odd numbers
        public static long countProfitableSegments(List<Integer> rideList, int targetPremiums) {
            // Map from prefix-odd-count -> frequency (use Long for counts because number of subarrays can be large)
            Map<Integer, Long> freq = new HashMap<>();
            freq.put(0, 1L); // zero odd numbers seen before starting

            long result = 0L;
            int prefixOdds = 0;

            for (int val : rideList) {
                // odd -> premium ride
                if ((val & 1) != 0) prefixOdds++;

                // number of previous prefixes that would make current window have exactly targetPremiums odds
                int need = prefixOdds - targetPremiums;
                result += freq.getOrDefault(need, 0L);

                // record current prefixOdds for future windows
                freq.put(prefixOdds, freq.getOrDefault(prefixOdds, 0L) + 1L);
            }

            return result;
        }
        // You can add a main to test locally if needed
        public static void main(String[] args) {
            List<Integer> rides = Arrays.asList(8, 11, 14, 7, 4);
            int k = 1;
            System.out.println(countProfitableSegments(rides, k)); // expected sample output: 8
        }
}


//        ### **Question **
//
//In Buzz’s ride analytics system, a premium ride is defined as one where the ride distance is **odd**.
//If the value is **even**, the ride is classified as **regular**.
//
//A *profitable segment* is defined as a contiguous segment of rides that contains exactly the given number of premium rides.
//
//You are given:
//
//        * a sequence of ride distances (`rideList`)
//* a target number of premium rides (`targetPremiums`)
//
//Your task is to determine how many **distinct profitable segments** can be formed.
//
//**Note:**
//
//        * Distinct segments are those defined by unique starting and ending positions in the ride sequence.
//* Segments can overlap.
//
//---
//
//        ### **Example**
//
//        ```
//rideList = [7, 10, 3, 6, 5]
//targetPremiums = 2
//        ```
//
//        **Explanation:**
//
//Premium rides (odd numbers) are: `7, 3, 5`.
//
//Profitable segments (subarrays with exactly 2 premium rides) include:
//
//        * [7, 10, 3] → premium rides are 7 and 3
//        * [10, 3, 6, 5] → premium rides are 3 and 5
//        * [7, 10, 3, 6] → premium rides are 7 and 3
//        * [3, 6, 5] → premium rides are 3 and 5
//
//Thus, **the output is 4.**
//
//        ---
//
//        ### **Function Description**
//
//Complete the function `countProfitableSegments` with the following parameters:
//
//        ```java
//public static long countProfitableSegments(List<Integer> rideList, int targetPremiums)
//```
//
//        **Parameters:**
//
//        * `rideList`: a list of integers representing ride distances
//* `targetPremiums`: an integer, the target number of premium (odd) rides in a segment
//
//**Returns:**
//
//        * `long`: the number of distinct profitable segments
//
//---
//
//        ### **Input Format for Custom Testing**
//
//        ```
//STDIN       Function
//-----       --------
//        5           → rideList.size = 5
//        8 11 14 7 4 → rideList = [8, 11, 14, 7, 4]
//        1           → targetPremiums = 1
//        ```
//
//        ---
//
//        ### **Sample Output 0**
//
//        ```
//        8
//        ```
//
//        **Explanation:**
//
//There are eight distinct profitable segments with exactly **1 premium ride**:
//
//        * rideList[0:0] → [8]
//        * rideList[0:1] → [8, 11]
//        * rideList[1:1] → [11]
//        * rideList[3:3] → [7]
//        * rideList[3:4] → [7, 4]
//        * rideList[0:2] → [8, 11, 14]
//        * rideList[2:3] → [14, 7]
//        * rideList[1:3] → [11, 14, 7]
//
//Hence, **output = 8.**
//
//        ---
//
//        ### **Constraints**
//
//        ```
//        1 ≤ |rideList| ≤ 2 × 10^5
//All rides have distinct values
//0 ≤ targetPremiums ≤ |rideList|
//        ```
//
//        ---
//
//Would you like me to format this as a **HackerRank-ready problem statement** (with markdown and boilerplate sections)?

