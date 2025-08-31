package Grind75;

import java.util.HashMap;

class TNode{
    HashMap<Integer , TNode> child;
    boolean Endof;

    TNode(){
        child = new HashMap<>();
        Endof = false;
    }
}

public class Trie {
        TNode root;


        public Trie() {
            root = new TNode();
        }

        public void insert(String str) {
            TNode current = root;
            for(char ch : str.toCharArray()){
                int ind = ch - 'a';
                if(!current.child.containsKey(ind)){
                    current.child.put(ind,new TNode());
                }
                current= current.child.get(ind);
            }
            current.Endof=true;
        }

        public boolean search(String str) {
            TNode current = root;
            for(char ch : str.toCharArray()) {
                int ind = ch - 'a';
                if (!current.child.containsKey(ind)) {
                    return false;
                }
                current = current.child.get(ind);
            }
            return current.Endof;
        }

        public boolean startsWith(String prefix) {
            TNode current = root;
            for(char ch : prefix.toCharArray()) {
                int ind = ch - 'a';
                if (!current.child.containsKey(ind)) {
                    return false ;
                }
                current = current.child.get(ind);
            }
            return true;
        }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.insert("apple");
        System.out.println(ob.search("apple"));   // return True
        System.out.println(ob.search("app"));     // return False
        System.out.println(ob.startsWith("app")); // return True
        ob.insert("app");
        System.out.println(ob.search("app"));     // return True
    }
}

//link : https://leetcode.com/problems/implement-trie-prefix-tree/
//leet 208
