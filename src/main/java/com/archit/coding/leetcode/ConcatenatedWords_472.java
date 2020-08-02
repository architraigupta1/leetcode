package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords_472 {
  public static void main(String[] args) {
    Solution s = new Solution();
    String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    List<String> result = s.findAllConcatenatedWordsInADict(words);
    result.forEach(System.out::println);
  }

  static class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
      List<String> result = new ArrayList<>();

      if (words == null || words.length < 3) {
        return result;
      }

      int n = words.length;
      Trie trie = new Trie();
      prepareTrie(trie, words);

      for (int i = 0; i < n; i++) {
        int length = words[i].length();
        String s = words[i];
        Node temp = trie.root;
        for (int j = 0; j < length; j++) {
          int index = s.charAt(j) - 'a';
          if(temp.child[index].isWord && (j + 1) < length) {
            boolean canSplit = checkSplit(trie, s, j + 1, length);
            if (canSplit) {
              result.add(s);
              break;
            }
          }
          temp = temp.child[index];
        }
      }

      return result;
    }

    private boolean checkSplit(Trie trie, String s, int index, int length) {
      if (index == length) {
        return true;
      }

      Node temp = trie.root;
      for (int i = index; i < length; i++) {
        int loc = s.charAt(i) - 'a';
        if (temp.child[loc] == null) {
          return false;
        }

        if (temp.child[loc].isWord) {
          if ((i + 1) == length) {
            return true;
          } else {
            if (checkSplit(trie, s, i + 1, length)) {
              return true;
            }
          }
        }
        temp = temp.child[loc];
      }

      return false;
    }

    private void prepareTrie(Trie trie, String[] words) {
      int n = words.length;
      for (int i = 0; i < n; i++) {
        trie.insert(words[i]);
      }
    }
  }

  static class Trie {
    Node root;

    public Trie() {
      this.root = new Node();
    }

    public void insert(String word) {
      Node temp = root;
      int n = word.length();

      for (int i = 0; i < n; i++) {
        int index = word.charAt(i) - 'a';
        if (temp.child[index] == null) {
          temp.child[index] = new Node();
          temp = temp.child[index];
        } else {
          temp = temp.child[index];
        }

      }
      temp.isWord = true;
    }
  }

  static class Node {
    Node[] child;
    boolean isWord;

    public Node () {
      this.child = new Node[26];
    }
  }


/*
1. Insert all words in a hashmap
2. scan all the words
    - For each word, scan it char by char and check against hash
    - If it atleast hits twice in map before the complete word is scanned, add it to result


B)
1. Insert all words in a trie.
2. Scan all words.
    - For each word, start traversing the trie.
    - On encountering a valid word
        - if the word is fully explored, then it is just one single word in dict
        - Else, start scanning the substring from the if match found, add to result
    - If match is not found for substring, continue scanning in the current string
*/
}
