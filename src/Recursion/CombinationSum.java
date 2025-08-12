package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();

            Combination(candidates,0,res,new ArrayList<>(),target);

            return res;
        }


        private void Combination(int [] candidates, int index, List<List<Integer>> res, List<Integer>temp,int target){
            int n = candidates.length;
            if(index==n){
                if(target==0){
                    res.add(new ArrayList<>(temp));
                }
                return;
            }
            if(target>=candidates[index]){
                temp.add(candidates[index]);
                Combination(candidates,index,res,temp,target-candidates[index]);
                temp.remove(temp.size()-1);
            }
            Combination(candidates,index+1,res,temp,target);
        }


    public static void main(String[] args) {
            int [] candidate = {2,3,6,7};
            int target = 7;
            CombinationSum ob = new CombinationSum();

        System.out.println( ob.combinationSum(candidate ,target));
    }
}

//leeTCode 39