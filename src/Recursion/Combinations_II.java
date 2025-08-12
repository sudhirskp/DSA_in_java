package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_II {
        int n;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            n = candidates.length;
            Arrays.sort(candidates);
            Combinations(candidates, new ArrayList<>(), 0, target, res);
            return res;
        }

        void Combinations(int[] candidates, List<Integer> list, int index, int target, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (index >= n)
                return;

            for (int i = index; i < n; i++) {
                if (i > index && candidates[i] == candidates[i - 1])
                    continue;
                if (candidates[i] > target)
                    break;
                list.add(candidates[i]);
                Combinations(candidates, list, i + 1, target - candidates[i], res);
                list.remove(list.size() - 1);
            }

        }

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5}; int  target = 8;
            Combinations_II ob = new Combinations_II();
        System.out.println(ob.combinationSum2(candidates,target));
    }
}

//https://leetcode.com/problems/combination-sum-ii/
//40. Combination Sum II