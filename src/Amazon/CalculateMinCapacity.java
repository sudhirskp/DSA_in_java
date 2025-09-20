package Amazon;

import java.util.Arrays;

public class CalculateMinCapacity {

        public static int calculateMinCapacity(int[] contentSize, int k) {
            Arrays.sort(contentSize); // Sort movie sizes for pairing
            int n = contentSize.length;
            if(n==0) return contentSize[0];

            int left = contentSize[n - 1]; // Minimum capacity must fit the largest movie
            int right = contentSize[n - 1] + contentSize[n - 2]; // Max possible pairing

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canDistribute(contentSize, k, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        private static boolean canDistribute(int[] contentSize, int k, int capacity) {
            int i = 0, j = contentSize.length - 1;
            int devicesUsed = 0;

            while (i <= j) {
                if (i!=j && contentSize[i] + contentSize[j] <= capacity) {
                    i++; // Pair smallest with largest
                }
                j--; // Always assign the largest remaining
                devicesUsed++;
            }

            return devicesUsed <= k;
        }

        public static void main(String[] args) {
            int[] contentSize = {9, 2, 4, 6};
            int k = 3;
            System.out.println(calculateMinCapacity(contentSize, k)); // Output: 9
        }
}

//Amazon - SDE 1 (full time) OA question 2025 [Sep 20]
//College Student University Selection
//All test case passed