package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalMinSwap {

        public static int calculateMinimumSwaps(int[] fileSize, int[] affinity) {
            int n = fileSize.length;
            List<Integer> conflictIndices = new ArrayList<>();
            Map<Integer, Integer> freq = new HashMap<>();

            // Step 1: Identify conflicts
            for (int i = 0; i < n; i++) {
                if (fileSize[i] == affinity[i]) {
                    conflictIndices.add(i);
                    freq.put(fileSize[i], freq.getOrDefault(fileSize[i], 0) + 1);
                }
            }

            // Step 2: Check if it's impossible
            int maxFreq = 0;
            for (int val : freq.values()) {
                maxFreq = Math.max(maxFreq, val);
            }

//            if (maxFreq > conflictIndices.size() / 2 + (conflictIndices.size() % 2)) {
//                return -1;
//            }

            if (maxFreq > (conflictIndices.size()+1) / 2) {
                return -1;
            }

            // Step 3: Count minimum swaps
            return (conflictIndices.size() + 1) / 2;
        }

        // Example usage
        public static void main(String[] args) {
            int[] fileSize = {1, 2, 3, 2, 1};
            int[] affinity = {1, 2, 3, 2, 3};
            System.out.println(calculateMinimumSwaps(fileSize, affinity)); // Output: 3
        }
}
//Amazon - SDE 1 (full time) OA