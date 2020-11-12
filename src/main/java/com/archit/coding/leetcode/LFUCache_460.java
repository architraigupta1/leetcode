package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache_460 {
  public static void main(String[] args) {

  }

  static class LFUCache {

    Map<Integer, Integer> keyToValue;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int min = -1;

    public LFUCache(int capacity) {
      this.capacity = capacity;
      this.keyToValue = new HashMap<>(this.capacity);
      this.keyToFreq = new HashMap<>();
      this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
      if (!keyToValue.containsKey(key)) {
        return -1;
      }

      updateFreq(key);
      return keyToValue.get(key);
    }



    public void put(int key, int value) {
      if (capacity <= 0) {
        return;
      }

      if (keyToValue.containsKey(key)) {
        keyToValue.put(key, value);
        updateFreq(key);
        return;
      }

      if (keyToValue.size() < this.capacity) {
        addKey(key, value);
      } else {
        evictKey();
        addKey(key, value);
      }
    }

    private void updateFreq(int key) {
      int freq = keyToFreq.get(key);

      // remove key from current freq list
      freqToKeys.get(key).remove(key);

      //if this was min freq key and also the only key with this freq
      if (min == freq && freqToKeys.get(key).size() == 0) {
        min++; //now next freq will be the minimum
      }

      //update the freq map
      keyToFreq.put(key, freq+1);

      //update the freqToKeys
      LinkedHashSet<Integer> set = freqToKeys.getOrDefault(
          freq+1, new LinkedHashSet<>());
      set.add(key);
      freqToKeys.put(key, set);
    }

    private void addKey(int key, int value) {
      min = 1; // this is the minimum freq key now
      keyToValue.put(key, value);
      keyToFreq.put(key, 1);

      LinkedHashSet<Integer> set = freqToKeys.getOrDefault(
          1, new LinkedHashSet<>());
      set.add(key);
      freqToKeys.put(key, set);
    }


    private void evictKey() {

      int key = freqToKeys.get(min).iterator().next();
      keyToValue.remove(key);
      keyToFreq.remove(key);
      freqToKeys.get(min).remove(key);
    }
  }


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
Create a class Node (int key, int value, int freq, int timer)

Map<Key, Node>
Min PQ<PqNode> sort asc by (freq, timer)
PqNode <freq, ListDemo<Node>>

get()
check in map, if exists
increment freq, update heap

*/
}
