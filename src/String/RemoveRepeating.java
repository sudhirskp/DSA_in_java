package String;

import java.util.HashSet;

public class RemoveRepeating {

    String removeDuplicate(String str){
        char [] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c : ch){
            if(!set.contains(c)){
                sb.append(c);
            }
            set.add(c);
        }

        return sb.toString();
    }

    String remove(String str){
        char [] ch = str.toCharArray();
        int [] fr = new int [128]; // adjust for uppercase letters

        for(char c : ch){
            fr[c]++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            if(fr[c]>=1) sb.append(c);
            fr[c] = -1;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        RemoveRepeating ob = new RemoveRepeating();
        System.out.println(ob.removeDuplicate("Programming"));
        System.out.println(ob.remove("Programming"));
    }
}
