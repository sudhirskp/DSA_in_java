package Daily_Task;

public class MaxTrip {
    public long maximumTripletValue(int[] nums) {
        int n= nums.length;
        int imax =0;
        long maxDiff=0;
        long res =0;
        for(int val : nums){
            res = Math.max(res, maxDiff * (long) val);
            maxDiff = Math.max(maxDiff, imax - (long) val);
            imax = Math.max(imax, val);
        }

        return res<0 ? 0 : res;
    }

    public static void main(String[] args) {
        int arr[] = {12,6,1,2,7};
        MaxTrip ob = new MaxTrip();
        System.out.println(ob.maximumTripletValue(arr));
    }
}
