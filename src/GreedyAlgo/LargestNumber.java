package GreedyAlgo;

import java.util.Arrays;

public class LargestNumber {

    //1st way
        public String largestNumber(int[] nums) {
            int n = nums.length;

            String[] temp = new String[n];

            for (int i = 0; i < n; i++) {
                temp[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));

            String res = String.join("", temp);

            if (res.charAt(0) == '0')
                return "0";

            return res;
        }

        //2nd way - faster


        public String largestNumber1(int[] nums) {
            int n = nums.length;

            String[] temp = new String[n];

            for (int i = 0; i < n; i++) {
                temp[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));

            //String res = String.join("", temp);

            if (temp[0].equals("0"))
                return "0";

            StringBuilder sb = new StringBuilder();
            for (String s : temp) {
                sb.append(s);
            }

            return sb.toString();
        }


    public static void main(String[] args) {
        int arr [] = {3,30,34,5,9};
        LargestNumber ob = new LargestNumber();

        System.out.println(ob.largestNumber1(arr));
    }
}

//leetCode 179
