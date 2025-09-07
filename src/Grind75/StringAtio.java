package Grind75;

public class StringAtio {

        public int myAtoi(String s) {
            int n = s.length();
            int i = 0;
            int num = 0;
            int sign = 1;

            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                sign = (s.charAt(i) == '-') ? -1 : 1;
                i++;
            }

            while (n > i && Character.isDigit(s.charAt(i))) {
                int digi = s.charAt(i) - '0';

                if (num > (Integer.MAX_VALUE - digi) / 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num = num * 10 + digi;

                i++;
            }
            return num * sign;
        }

    public static void main(String[] args) {
        String s = "   -42";
        StringAtio obj = new StringAtio();
        System.out.println(obj.myAtoi(s));
    }
}

//leetcode 8
//https://leetcode.com/problems/string-to-integer-atoi/description/
//Time complexity O(n)
//Space complexity O(1)
