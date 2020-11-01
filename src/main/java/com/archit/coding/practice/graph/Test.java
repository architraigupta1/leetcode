package com.archit.coding.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Test {

  static String getShortestUniqueSubstring(char[] a, String str) {
    // your code goes here
    if (a == null || a.length == 0 || str == null || str.length() == 0) {
      return "";
    }

    int n = str.length(); //n string chars
    int m = a.length; //unique m chars

    //prepare hashset for fast access
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < m; i++) {
      set.add(a[i]);
    }

    int minWindow = Integer.MAX_VALUE;
    int start = 0;
    int begin = 0;
    Map<Character, Integer> map = new HashMap<>(); // to track freq of chars

    //find first window
    int i = begin;
    while (i < n && !set.contains(str.charAt(i))) {
      i++;
    }

    start = i;
    begin = i;

    while(i < n) {
      char ch = str.charAt(i); //get the ith char

      //if the char is not to be tracked, simply consume it.
      if (!set.contains(ch)) {
        i++;
        continue;
      }

      int count = map.getOrDefault(ch, 0);
      map.put(ch, count + 1);
      //check if window has all unique chars atleast once
      if (map.size() == m) {
        minWindow = i + 1;
        break;
      }

      i++;
    }

    //suggests that no window was found with all the chars.
    if (i == n) {
      return "";
    }

    //expand to right from the first window
    for (int j = i + 1; j < n; j++) {
      char ch = str.charAt(j);
      //if the char is not to be tracked, simply consume it.
      if (!set.contains(ch)) {
        continue;
      }
      int count = map.getOrDefault(ch, 0);
      map.put(ch, count + 1);
      //contract from the left until condition is met
      while (begin < j) {
        //get the leftmost char
        char leftmostChar = str.charAt(begin);
        //if leftmost char is not to be tracked, contract the window
        if (!map.containsKey(leftmostChar)) {
          begin++;
          // if count of char is greater than 1, then we can delete this char.
        } else {
          int leftmostCharCount = map.get(leftmostChar);
          if (leftmostCharCount > 1) {
            begin++;
            map.put(leftmostChar, leftmostCharCount-1);
            //else we cannot delete as it is req. for min window of unique chars, break
          } else {
            break;
          }
        }
        minWindow = Math.min(minWindow, j - begin + 1);
        start = begin;
      }
    }

    //return the min. length substring
    return start == 0 ? str.substring(start, start + minWindow) : str.substring(start, start + minWindow - 1);

  }

  public static void main(String[] args) {
    char[] arr = {'x','y','z'};
    String result = getShortestUniqueSubstring(arr, "xxyz");
    System.out.println(result);
  }

}

/*
  arr = [x,y,z] = unique size = m
  str = "xyyzyzyx" = length n

-  smallest substring containing all chars in arr atleast once
-  Return "" (empty string) if such a substring doesn’t exist.


  1. HashSet<Characert> => o(1) => time o(m) as m unique chars
  2. Scan the input str and find first window aving all chars => first length
  3. contract the window from the left

  Time complexity => o(m) + o(n) + o(n) ~ o(n) as (m < n)
  Space compl => o(m) => hashmap o(m) m distinct keys
  where m is the unique chars in arr
  and n is length of input string
*/
