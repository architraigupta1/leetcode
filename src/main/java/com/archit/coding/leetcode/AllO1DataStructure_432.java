package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class AllO1DataStructure_432 {

//["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
//    [[],   ["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
  public static void main(String[] args) {
    AllOne allOne = new AllOne();
    allOne.inc("a");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("c");
    allOne.inc("c");
    allOne.inc("c");
    allOne.dec("b");
    allOne.dec("b");
    System.out.println(allOne.getMaxKey());
    allOne.dec("a");
    System.out.println(allOne.getMaxKey());
    System.out.println(allOne.getMinKey());
  }

  static class AllOne {

    Map<String, Integer> keyToFreq;
    Map<Integer, HashSet<String>> freqToKeys;
    LinkedList<Integer> freq;

    /** Initialize your data structure here. */
    public AllOne() {
      this.keyToFreq = new HashMap<>();
      this.freqToKeys = new HashMap<Integer, HashSet<String>>();
      this.freqToKeys.put(0, new HashSet<String>());
      this.freqToKeys.put(1, new HashSet<String>());
      this.freq = new LinkedList<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
      int count = this.keyToFreq.getOrDefault(key, 0);
      updateFreqToKeys(key, count);

      //upsert keyToFreq
      keyToFreq.put(key, count+1);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
      if (!keyToFreq.containsKey(key)) {
        return;
      }

      int count = keyToFreq.get(key);
      if (count == 1) {
        keyToFreq.remove(key);
        HashSet<String> set = freqToKeys.get(1);
        set.remove(key);
        // if this is the only key with freq 1 (MIN possible freq)
        if (set.size() == 0) {
          freq.clear();
        }
      } else {
        HashSet<String> set = freqToKeys.get(count);
        set.remove(key);

        if(set.size() == 0) {
          freq.remove(count);
//          if (freq.getLast() == count) { // if this is MAX key
//            freq.removeLast();         //remove it
//          }


          if(!freq.isEmpty() && freq.getLast() < count - 1) {
            freq.addLast(count - 1);
          }

          if (!freq.isEmpty() && freq.getFirst() == count) {
            freq.removeFirst();
            freq.addFirst(count-1);
          }

          if (freq.isEmpty()) {
            freq.add(count - 1);
          }
        } else {
          if (freq.getFirst() < count - 1) {
            freq.addFirst(count-1);
          }
        }
        count--;
        //Add the key to next freq list
        set = freqToKeys.getOrDefault(count, new HashSet<String>());
        set.add(key);
        freqToKeys.put(count, set);
        keyToFreq.put(key, count);
      }

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
      if(keyToFreq.isEmpty()) {
        return "";
      } else {
        int max = freq.getLast();
        return freqToKeys.get(max).iterator().next();
      }

    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
      if(keyToFreq.isEmpty()) {
        return "";
      } else {
        int min = freq.getFirst();
        return freqToKeys.get(min).iterator().next();
      }
    }

    private void updateFreqToKeys(String key, int count) {
      //remove the key from current freq list

      HashSet<String> set = freqToKeys.get(count);
      set.remove(key);

      //if this is the only key
      if (freq.isEmpty()) {
        freq.add(count+1);
      } else if (set.size() == 0) { // this is the only key with freq
        freq.remove(count);
//        if (freq.getFirst() == count) { // if this is MIN key
//          freq.removeFirst();         //remove it
//        }


        if(!freq.isEmpty() && freq.getFirst() > count + 1) {
          freq.addFirst(count + 1);
        }

        if (!freq.isEmpty() && freq.getLast() == count) {
          freq.removeLast();
          freq.add(count+1);
        }

        if (freq.isEmpty()) {
          freq.add(count+1);
        }
      } else {
        if (freq.getLast() < count + 1) {
          freq.add(count+1);
        }
      }

      count++;
      //Add the key to next freq list
      set = freqToKeys.getOrDefault(count, new HashSet<String>());
      set.add(key);
      freqToKeys.put(count, set);
    }
  }

/*
Map<String, freq>
List<Freq, Set> -- ignore
Map<Freq, Set>
LinkedList<Integer> freq
MAX
MIN

* inc
check if key exist in map
    - inc value
    - delete from current freq list
    - add to the next higher freq list (get list with freq and add or create a new list)
    - Update MIN
        - check if this is the only key with min freq, then update min freq
        - for every new insertion reset MIN to 1
    - Update MAX
        - If new freq is greater than MAX, update MAX

* dec
check if key exist in map
    - dec value
    - If value == 1, remove key
    - Update the freq list
         - delete the key from cur freq and add it to lower freq
    - Update MIN
        - If this is the only MIN key, reset MIN to 0
    - update MAX
        - When the key we are deleting is the max key and there is no othe key
           with this freq, then find the next MAX
* max
    - get the value for MAX freq key
* min
    - get the value for MIN freq key
*/

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
