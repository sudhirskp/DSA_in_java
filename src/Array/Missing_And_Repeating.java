package Array;

import java.util.ArrayList;

public class Missing_And_Repeating {

    ArrayList<Integer> findTwoElement(int nums[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] temp = findDuplicate(nums); // call once
        res.add(temp[0]); // duplicate
        res.add(temp[1]); // missing
        return res;
    }

    public int[] findDuplicate(int[] nums) {
        int duplicate = 0;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]);
            }
            else if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        int missing = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }



        static ArrayList<Integer> findTwoElement1(int[] arr) {
            int n = arr.length;

            // Expected sum and sum of squares for numbers from 1 to n
            int s = (n * (n + 1)) / 2;
            int ssq = (n * (n + 1) * (2 * n + 1)) / 6;

            int missing = 0, repeating = 0;

            // Subtract actual values from expected sums
            for (int i = 0; i < n; i++) {
                s -= arr[i];
                ssq -= arr[i] * arr[i];
            }

            // Let x = missing, y = repeating
            // s = x - y
            // ssq = x^2 - y^2 = (x - y)(x + y) = s * (x + y)
            // => x + y = ssq / s
            // => x = (s + ssq / s) / 2
            // => y = x - s
            missing = (s + ssq / s) / 2;
            repeating = missing - s;

            ArrayList<Integer> res = new ArrayList<>();
            res.add(repeating);
            res.add(missing);
            return res;
        }

    public static void main(String[] args) {
        Missing_And_Repeating ob = new Missing_And_Repeating();
        System.out.println(ob.findTwoElement(new int [] {1,3,4,2,2}));

        System.out.println(ob.findTwoElement1(new int [] {1,3,4,2,2}));
    }
}
//https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1