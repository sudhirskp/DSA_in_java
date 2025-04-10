package Sorting.Practice;

import java.util.ArrayList;
import java.util.List;

public class findAllnumber {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        //nums = new int [n+];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            //int temp = nums[i];
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }


        for(int j =0;j<n;j++){
            if(nums[j]-1!=j){
                list.add(j+1);
            }
            System.out.print(" " + nums[j]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int n = nums.length;
        findAllnumber f = new findAllnumber();
        System.out.println(f.findDisappearedNumbers(nums));
    }
}
