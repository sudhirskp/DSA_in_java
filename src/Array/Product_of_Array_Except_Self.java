package Array;

public class Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left [] = new int [n];
        int right [] = new int [n];
        int answer [] = new int [n];
        left[0]=1;
        right[n-1]=1;

        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            answer[i]=left[i]*right[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Product_of_Array_Except_Self ob = new Product_of_Array_Except_Self();
       int ans [] = ob.productExceptSelf(new int[]{1,2,3,4});
       for(int i=0;i<ans.length;i++){
           System.out.print(ans[i]+" ");
       }
    }
}


//238. Product of Array Except Self
//        Solved
//Medium
//        Topics
//Companies
//        Hint
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.