package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_III {

        int[] number = new int[9];

        public List<List<Integer>> combinationSum3(int k, int n) {
            for (int i = 1; i <= 9; i++) {
                number[i - 1] = i;
            }
            List<List<Integer>> res = new ArrayList<>();
            Combinations(res, k, n, new ArrayList<>(), 0);
            return res;
        }

        private void Combinations(List<List<Integer>> res, int k, int n, List<Integer> list, int index) {
            if (list.size() == k) {
                if (n == 0) {
                    res.add(new ArrayList<>(list));
                }
                return;
            }
            if (index >= number.length) return;

            if (n >= number[index]) {
                list.add(number[index]);
                Combinations(res, k, n - number[index], list, index + 1);
                list.remove(list.size() - 1);
            }
            Combinations(res, k, n, list, index + 1);
        }

    public static void main(String[] args) {
        int k = 3, n = 7;
        CombinationSum_III obj = new CombinationSum_III();
        List<List<Integer>> res = obj.combinationSum3(k, n);
        System.out.println(res);
    }
}
