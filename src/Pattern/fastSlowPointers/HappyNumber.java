package Pattern.fastSlowPointers;

public class HappyNumber {
    public boolean isHappy(int n){
        int t = n;
        int sum =0;
        while(t>0) {
            int rem = t % 10;
            sum += rem * rem;
            t = t / 10;

        }
        if(sum==1){
            return true;
        }else if(sum==4){
            return false;
        }else{
            return isHappy(sum);
        }
    }

    public boolean isHappyPointers(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 19;
        HappyNumber ob = new HappyNumber();
        //System.out.println(ob.isHappy(n));
        System.out.println(ob.isHappyPointers(n));
    }
}

//202. Happy Number
//Easy
//        Topics
//Companies
//Write an algorithm to determine if a number n is happy.
//
//A happy number is a number defined by the following process:
//
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.
//        Example 1:
//Input: n = 19
//Output: true
//Explanation:
//        1^2 + 9^2 = 82
//        8^2 + 2^2 = 68
//        6^2 + 8^2 = 100
//        1^2 + 0^2 + 0^2 = 1
