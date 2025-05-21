package Pattern.TwoPointers;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left =0;
        int right =n-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }
            if(sum==target){
                return new int []{left+1,right+1};
            }
        }
        return new int []{};
    }
    public static void main(String[] args) {
        int [] numbers = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
//
//167. Two Sum II - Input Array Is Sorted