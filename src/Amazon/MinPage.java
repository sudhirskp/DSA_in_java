package Amazon;

public class MinPage {

        public int findPages(int[] arr, int k) {
            // code here

            if(arr.length < k) return -1;

            int maxVal =-1;
            int sum = 0;

            for(int val : arr){
                maxVal = Math.max(maxVal,val);
                sum+=val;
            }

            int st = maxVal;
            int end = sum;
            int res = -1;

            while(st <= end){
                int mid = st + (end -st)/2;

                if(validate(arr,k,mid)){
                    res = mid;
                    end = mid -1;
                }else{
                    st = mid+1;
                }
            }

            return res;
        }

        private boolean validate(int [] arr, int k, int limit){
            int student = 1;
            int curpage =0;

            for(int page : arr){
                if(curpage + page > limit){
                    student++;
                    curpage = page;

                    if(student > k) return false;
                }else{
                    curpage += page;
                }
            }

            return true;
        }

    public static void main(String[] args) {
        MinPage ob = new MinPage();
        System.out.println(ob.findPages(new int[]{12,34,67,90},2));
    }
}
//gfg problem : link - https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
//leetcode similar problem : link - https://leetcode.com/problems/split-array-largest-sum/description/
//TC : O(n log(sum of arr))
//SC : O(1)