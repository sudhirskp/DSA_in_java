package Jus;

public class mxWeight {

    public int maxWeightCell(int[] exits) {
        int n = exits.length;
        int []w = new int [n];
        int maxw = 0;

        for(int i=0;i<n;i++){
            if(exits[i]!=-1){
                w[exits[i]] += i;
                maxw = Math.max(maxw,w[exits[i]]);
            }
        }

        int index = -1;
        for(int i=0;i<n;i++){
            if(w[i]==maxw){
                index = Math.max(index,i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        mxWeight ob = new mxWeight();
        int ans = ob.maxWeightCell(new int[]{2,0,-1,2});
        System.out.println(ans);
    }
}

//easy -gfg- https://www.geeksforgeeks.org/problems/maximum-weight-node--170645/1?page=1&company=JUSPAY&sortBy=submissions