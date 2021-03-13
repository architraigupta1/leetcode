package com.archit.coding.test;

import java.util.HashMap;
import java.util.Set;

public class Operators {
  public static void main(String[] args) {
    HashMap<String, Object> map = new HashMap<>();
    HashMap<String, Object> key2 = new HashMap<>();
    HashMap<String, Object> c = new HashMap<>();
    HashMap<String, Object> empty = new HashMap<>();
    empty.put("", 1);
    c.put("d", "3");
    c.put("e", empty);
    key2.put("a", 2);
    key2.put("b", "3");
    key2.put("c", c);
    map.put("key1", 1);
    map.put("key2", key2);

    HashMap<String, String> result = flatDict(map);
    for (String key : result.keySet()) {
      System.out.println(key +  " " + result.get(key));
    }
  }

  private static HashMap<String, String> flatDict(HashMap<String, Object> dict) {
    HashMap<String, String> result = new HashMap<>();
    for (String key : dict.keySet()) {// key2, a,b,c, d,e
      Object value = dict.get(key); //dict
      if (value instanceof HashMap) {
        HashMap<String, String> childMap = flatDict((HashMap<String, Object>)value);
        for (String childKey : childMap.keySet()) {
          String flatKey = key + "." + childKey; //e + ""
          result.put(flatKey, childMap.get(childKey)); //c.d -> 3 c.e->1
        }
      } else {
        result.put(key, String.valueOf(value));   //key1 -> 1
      }
    }

    return result;
  }

  private static void solve(String num, int index, int n, Set<String> set,
                     int prev, int cur, int target, StringBuilder sb) {
    if (index == n) {
      if (cur == target) {
        set.add(sb.toString());
      }
      return;
    }

    int length = sb.length();
    int sum = 0;
    // for (int i = index; i < n; i++) {
    int digit = num.charAt(index) - '0';
    sum = sum * 10 + digit;

    sb.append(sum).append("+");
    solve(num, index + 1, n, set, cur, cur + sum, target, sb);
    sb.setLength(length);

    sb.append(sum).append("-");
    solve(num, index + 1, n, set, -sum, cur - sum, target, sb);
    sb.setLength(length);
    // }
  }
}
