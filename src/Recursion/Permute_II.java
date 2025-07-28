package Recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Permute_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        //wrong logic to find duplicates and remove from res - it is not working - TLE also if we change the "if" into while
//            HashMap<List<Integer>, Integer> map = new HashMap<>();
//            for (int i = 0; i < res.size(); i++) {
//                map.put(res.get(i), map.getOrDefault(res.get(i), 0) + 1);
//            }
//
//            for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
//                if (entry.getValue() > 1) {
//                    res.remove(entry.getKey());
//                }
//            }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            set.add(res.get(i));
        }
        res.clear();
        //below all are same logic
       // res.addAll(set);
        //res = set.stream().toList();
       // res = set.stream().collect(Collectors.toList());
        res= List.copyOf(set);

        return res;
    }

    void permute(int[] nums, int ind, List<List<Integer>> res) {
        int n = nums.length;
        if (ind == n - 1) {
            List<Integer> list = new ArrayList<>();
            for (int val : nums) {
                list.add(val);
            }
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < n; i++) {
            swap(nums, i, ind);
            permute(nums, ind + 1, res);
            swap(nums, i, ind);
        }
    }

    void swap(int[] nums, int i, int ind) {
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }
        public List<List<Integer>> permuteUnique1(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums); // sort to handle duplicates
            boolean[] used = new boolean[nums.length];
            backtrack(nums, new ArrayList<>(), res, used);
            return res;
        }

        void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] used) {
            if (temp.size() == nums.length) {
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;

                // Skip duplicates: only use the first un-used duplicate in each branch
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, temp, res, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    public static void main(String[] args) {
        Permute_II obj = new Permute_II();
        int[] nums = {1, 1, 2};
        System.out.println(obj.permuteUnique1(nums));
    }
}
