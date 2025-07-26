package Recursion;

public class DecToBN {
    void binary(int n) {
       if(n==0) return ;
       binary(n/2);
       //System.out.print(n%2);
    }

    String StringBinary(int n) {
        if(n==0) return "";
        return StringBinary(n/2) + n%2;
    }
    public static void main(String[] args) {
        DecToBN ob = new DecToBN();

        ob.binary(10);
        System.out.println(ob.StringBinary(10));
    }
}
