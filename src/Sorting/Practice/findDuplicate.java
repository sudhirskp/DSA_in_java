package Sorting.Practice;

import java.util.ArrayList;
import java.util.List;

public class findDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int [] temp = new int[n];
        for(int j=0;j<n;j++){
            temp[j] = nums[j];
        }
        for(int i=0;i<n;i++){
            int ele = nums[i];
            int actualIndex = ele-1;
            if(temp[actualIndex]<0){
                list.add(ele);
            }
            temp[actualIndex] = -1*temp[actualIndex];
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicate f = new findDuplicate();
        System.out.println(f.findDuplicates(nums));
    }
}
