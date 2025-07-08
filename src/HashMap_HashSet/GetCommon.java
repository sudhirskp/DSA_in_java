package HashMap_HashSet;

import java.util.HashMap;

public class GetCommon {
    public static void main(String[] args) {
        int a[]={1,2,3,5,6,8,6};
        int b[]={1,19,4,8,89,3,0};
        getcommonele(a,b);
    }

    private static void getcommonele(int[] a, int[] b) {
        HashMap<Integer,Integer> common = new HashMap<>();
        for (int a1 : a){
            common.put(a1,1);
        }
        for(int b1 : b){
            if(common.containsKey(b1)==true){
                System.out.println(b1);
            }else {
                continue;
            }
        }
    }
}
