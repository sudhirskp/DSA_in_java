package Daily_Task.Nov2025;

public class NoOfSubstring {


        public int numSub(String s) {
            char [] ch = s.toCharArray();
            int MOD = (int)1e9 + 7;
            int consecutiveOne = 0;
            long ans =0;
            for(int i =0;i<ch.length;i++){
                if(ch[i]=='1'){
                    consecutiveOne++;
                }else {
                    ans += (long)consecutiveOne*(consecutiveOne+1)/2;
                    consecutiveOne=0;
                }
            }

            if(consecutiveOne > 0){
                ans += (long)consecutiveOne*(consecutiveOne+1)/2;
            }
            return (int)(ans % MOD);
        }

    public static void main(String[] args) {
            NoOfSubstring noOfSubstring = new NoOfSubstring();
            String s = "1101";
            System.out.println(noOfSubstring.numSub(s));
    }
}
//leetCode 1513
//16 nov 2025
//TC : O(n)