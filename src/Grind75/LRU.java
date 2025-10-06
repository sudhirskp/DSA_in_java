package Grind75;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {


        private final int capacity;
        private final Map<Integer, Integer> map;
        private final LinkedList<Integer> usage;

        public LRU(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.usage = new LinkedList<>();
        }

    public int get(int key) {
            if (!map.containsKey(key)) return -1;

            // Move key to the end to mark it as recently used
            usage.remove((Integer) key);
            usage.addLast(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // Update value and move key to the end
                map.put(key, value);
                usage.remove((Integer) key);
                usage.addLast(key);
            } else {
                if (map.size() >= capacity) {
                    // Remove least recently used key
                    int lruKey = usage.removeFirst();
                    map.remove(lruKey);
                }
                map.put(key, value);
                usage.addLast(key);
            }
        }

    public static void main(String[] args) {
        LRU lruCache = new LRU(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // return 1
        lruCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // return -1 (not found)
        lruCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1)); // return -1 (not found)
        System.out.println(lruCache.get(3)); // return 3
        System.out.println(lruCache.get(4)); // return 4
    }
}
//leetCode 146 : https://leetcode.com/problems/lru-cache/description/
//Time Complexity: O(1) for both get and put operations.
//Space Complexity: O(capacity) for storing the cache items.