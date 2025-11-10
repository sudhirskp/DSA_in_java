package Daily_Task.Nov2025;

public class AlleleTozero {

    public int minOperations(int[] nums) {
        int [] stack = new int [nums.length];
        int index =-1;
        int ans =0;
        for(int val : nums){
            while(index!=-1 && stack[index]>val){
                index--;
            }
            if(val > 0 && (index==-1 || val != stack[index])){
                ans+=1;
                stack[++index]=val;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AlleleTozero alleleTozero = new AlleleTozero();
        int [] nums = {3,1,2,1};
        System.out.println(alleleTozero.minOperations(nums));
    }
}
//leetCode 3542
//11 nov 2025
//Time : O(n)
//Space : O(n)