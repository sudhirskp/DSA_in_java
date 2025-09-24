package Amazon;

import Grind75.MergeIntervals;

public class MedianOfTwoSortedArray {

        int m,n; //TC : O(m+n) //SC : O(m+n)
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            m = nums1.length;
            n = nums2.length;

            int [] temp = new int [m+n];
            merge(nums1,nums2,temp);

            int size = temp.length;
            if(size%2==0){
                int index = (size+1)/2-1;
                int nextind = index+1;

                return (double)(temp[index]+temp[nextind])/2;
            }
            return temp[(size+1)/2-1];
        }

        private void merge(int [] nums1, int [] nums2, int [] temp){

            int i=0;
            int j =0;
            int k =0;

            while(i < m && j <n){
                if(nums1[i]<=nums2[j]){
                    temp[k++] = nums1[i++];
                }else{
                    temp[k++] = nums2[j++];
                }
            }

            while(i<m){
                temp[k++] = nums1[i++];
            }

            while(j<n){
                temp[k++] = nums2[j++];
            }
        }


        //TC : O(log(min(m,n))) //SC : O(1)
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            // make num1 as min length array.
            // call same function, and change the params
            // if nums1 was greater and nums2 was smaller
            // so because we swapped these two, now nums1 is smaller and
            // nums2 is greater.
            if(nums1.length > nums2.length){
                return findMedianSortedArrays(nums2,nums1);
            }
            // nums1 is smaller and num2 is greater.
            int n1 = nums1.length;
            int n2 = nums2.length;
            int N = n1+n2;
            int start = 0;
            int end = n1;
            while (start<=end){
                // mid -> cut1
                int cut1 = start + (end - start)/2;
                // (n1 + n2)/2 - length of cut1
                int cut2 = N/2 - cut1;
                // l1,l2, r1 and r2.
                int l1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
                int l2 = (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
                int r1 = (cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
                int r2 = (cut2==n2)?Integer.MAX_VALUE:nums2[cut2];

                // check if cut is valid
                if(l1 <= r2 && l2 <= r1){
                    // if N is odd, only one median
                    if(N%2!=0){
                        return (double) Math.min(r1,r2);
                    }
                    // else if N is even, two medians, so take average
                    else {
                        return ((Math.max(l1,l2) + Math.min(r1,r2))/2.0);
                    }
                } else if (l1>r2) {
                    end = cut1-1;
                } else{
                    start = cut1+1;
                }
            }
            return 0.0; // to avoid error
        }


    public static void main(String[] args) {
        MedianOfTwoSortedArray ob = new MedianOfTwoSortedArray();
        System.out.println(ob.findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
    }
}
//leetCode : 4