package Daily_Task.Nov2025;

public class ColorRope {


        public int minCost(String colors, int[] neededTime) {
            int time =0;
            int pre=0;

            char [] ch = colors.toCharArray();

            for(int i=1;i<ch.length;i++){
                if(ch[i]==ch[pre]){
                    time += Math.min(neededTime[i],neededTime[pre]);
                    if(neededTime[i]>neededTime[pre]){
                        pre=i;
                    }
                }else{
                    pre=i;
                }
            }

            return time;
        }

    public static void main(String[] args) {
            ColorRope colorRope = new ColorRope();
            int[] neededTime = {1,2,3,4,5};
            String colors = "aabacbc";
            System.out.println(colorRope.minCost(colors, neededTime));
    }
}
//LeetCode : 1578
//3 nov 2025
//Time : O(n)
//Space : O(1)