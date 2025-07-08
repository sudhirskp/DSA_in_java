package HashMap_HashSet;

import java.util.HashMap;

public class Maxfrequency {
    public static void main(String[] args) {
        String sr= "ajsdjhsbaaaaahbjsajbdjka";
        maxfr(sr);
    }

    private static void maxfr(String sr) {
        HashMap<Character, Integer> frmap = new HashMap<>();
        for (int i = 0; i < sr.length(); i++) {
            char ch = sr.charAt(i);
            if (frmap.containsKey(ch) == true) {
                int currentfr = frmap.get(ch);
                frmap.put(ch, currentfr + 1);
            } else {
                frmap.put(ch, 1);
            }
        }

        int maxval = 0;
        char maxchar = 'c';
        for (char cc : frmap.keySet()){
            if(frmap.get(cc)>maxval){
                maxval = frmap.get(cc);
                maxchar = cc;
            }
        }
        System.out.println(maxchar);
    }
}
