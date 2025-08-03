package Other;

public class TrionicArray {

    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int [] ct = new int [3];

        int i =0;
        int j = i+1;
        while(j<n){
            if(nums[i]<nums[j]){
                ct[0]++;
            }else{
                break;
            }
            j++;
            i++;
        }
        if(ct[0]==0) return false;

        while(j<n-1){
            if(nums[i]>nums[j]){
                ct[1]++;
            }else{
                break;
            }
            j++;
            i++;
        }
        if(ct[1]==0) return false;

        while(j<n){
            if(nums[i]<nums[j]){
                ct[2]++;
            }else{
                break;
            }
            j++;
            i++;
        }
        if(ct[2]==0) return false;
        return ct[0]+ct[1]+ct[2]+1==n;
    }

    public static void main(String[] args) {
        //int [] nums = {1,3,5,4,2,6};
        //int [] nums = {2,1,3};
       // int [] nums = {1,2,3,4,5,6};
        int [] nums = {3,7,1};
        System.out.println(new TrionicArray().isTrionic(nums));
    }
}
