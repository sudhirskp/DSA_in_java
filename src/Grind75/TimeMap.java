package Grind75;

import java.util.HashMap;
import java.util.TreeMap;

//not understand by m
public class TimeMap {
    HashMap<String , TreeMap<Integer , String>> map ;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        TreeMap <Integer , String > submap = map.get(key);
        submap.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap <Integer , String > submap = map.get(key);
        Integer prevTime = submap.floorKey(timestamp);
        if(prevTime==null) return "";
        return submap.get(prevTime);
    }
    public static void main(String[] args) {

    }
}

//981. Time Based Key-Value Store
//Solved
//        Medium
//Topics
//        Companies
//Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
//
//Implement the TimeMap class:
//
//TimeMap() Initializes the object of the data structure.
//void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
//String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
//
//
//Example 1:
//
//Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//        [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
//Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]