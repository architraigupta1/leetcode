package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.letterCombinations("23"));
  }

  static class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if (digits == null || digits.isEmpty()) {
        return result;
      }

      int n = digits.length();

      Map<Character, List<Character>> map = new HashMap<>();
      map.put('2', Arrays.asList('a', 'b', 'c'));
      map.put('3', Arrays.asList('d', 'e', 'f'));
      map.put('4', Arrays.asList('g', 'h', 'i'));
      map.put('5', Arrays.asList('j', 'k', 'l'));
      map.put('6', Arrays.asList('m', 'n', 'o'));
      map.put('7', Arrays.asList('p', 'q', 'r', 's'));
      map.put('8', Arrays.asList('t', 'u', 'v'));
      map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

      char[] word = new char[n];
      makeCombinations(digits, 0, n, map, word, result);

      return result;
    }

    private void makeCombinations(String digits, int index, int length,
                                  Map<Character, List<Character>> map,
                                  char[] word, List<String> result) {
      if (index == length) {
        result.add(new String(word));
        return;
      }

      Character digit = digits.charAt(index);
      List<Character> list = map.get(digit);
      int n = list.size();

      for (int i = 0; i < n; i++) {
        word[index] = list.get(i);
        makeCombinations(digits, index + 1, length, map, word, result);
      }
    }














        /*
        Map<Character, String> map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        ListDemo<String> result = new ArrayList();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        int n = digits.length();
        char a[] = new char[n];
        findCombinations(digits, a, map, 0, n, result);

        return result;
    }

    public void findCombinations(String digits, char[] a, Map<Character, String> map, int index, int n, ListDemo<String> result) {
        if (index == n) {
            result.add(new String(a));
            return;
        }

        Character current = digits.charAt(index);
        String letters = map.get(current);

        for (int i = 0; i < letters.length(); i++) {
            a[index] = letters.charAt(i);
            findCombinations(digits, a, map, index + 1, n, result);
        }
    }
    */
  }
}
