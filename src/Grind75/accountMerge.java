package Grind75;

import java.util.*;

public class accountMerge {

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            HashMap<String, List<String>> adj = new HashMap<>();
            for (List<String> acc : accounts) {
                String keymail = acc.get(1);
                for (int i = 2; i < acc.size(); i++) {
                    String email = acc.get(i);
                    if (!adj.containsKey(keymail)) {
                        adj.put(keymail, new ArrayList<>());
                    }
                    adj.get(keymail).add(email);

                    if (!adj.containsKey(email)) {
                        adj.put(email, new ArrayList<>());
                    }
                    adj.get(email).add(keymail);
                }
            }

            List<List<String>> res = new ArrayList<>();
            HashSet<String> visited = new HashSet<>();

            for (List<String> acc : accounts) {
                String name = acc.get(0);
                String email = acc.get(1);
                List<String> sublist = new ArrayList<>();
                if (!visited.contains(email)) {
                    merge(email, visited, sublist, adj);
                    Collections.sort(sublist);
                    sublist.add(0, name);
                    res.add(sublist);
                }

            }
            return res;
        }

        private void merge(String email, HashSet<String> visited, List<String> sub, HashMap<String, List<String>> adj) {
            visited.add(email);
            sub.add(email);

            if(!adj.containsKey(email)) return;
            for (String str : adj.get(email)){
                if (!visited.contains(str)) {
                    merge(str, visited, sub, adj);
                }
            }
        }

    public static void main(String[] args) {
        accountMerge obj = new accountMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com","John","johnsmith@mail.com","john00@mail.com","Mary","mary@mail.com","John","johnnybravo@mail.com"));
        System.out.println(obj.accountsMerge(accounts));
    }
}
//Leetcode 721
//Time Complexity: O(NK log NK) where N is the number of accounts and K is the maximum length of an account.
//Space Complexity: O(NK) for the adjacency list and other data structures used.