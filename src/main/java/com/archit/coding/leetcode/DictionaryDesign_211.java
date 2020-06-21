package com.archit.coding.leetcode;

public class DictionaryDesign_211 {
  public static void main(String[] args) {

    WordDictionary w = new WordDictionary();
    w.addWord("bad");
    w.addWord("dad");
    w.addWord("mad");
    w.addWord("pad");
    w.addWord("bad");
    System.out.println(w.search("pad"));
    System.out.println(w.search("bad"));
    System.out.println(w.search("bada"));
    System.out.println(w.search(".ad"));
    System.out.println(w.search("b.."));
  }


  static class WordDictionary {

    TrieNode parent;

    /** Initialize your data structure here. */
    public WordDictionary() {
      parent = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
      TrieNode root = parent;
      for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if(root.child[index] == null) {
          root.child[index] = new TrieNode(word.charAt(i));

        }
        root = root.child[index];
      }
      root.isWord = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
      return match(parent, word, 0);
    }

    public boolean match(TrieNode root, String word, int index) {
      if (index == word.length()) {
        return root.isWord;
      }

      char c = word.charAt(index);
      if(c != '.') {
        return root.child[c - 'a'] != null && match(root.child[c-'a'], word, index + 1);
      } else {
        for (int i = 0; i < 26; i++) {
          if (root.child[i] != null) {
            boolean result = match(root.child[i], word, index + 1);
            if (result == true) {
              return true;
            }
          }
        }
      }

      return false;
    }
  }

  static class TrieNode {
    char data;
    TrieNode[] child;
    boolean isWord;

    public TrieNode() {
      this.child = new TrieNode[26];
    }

    public TrieNode(char data) {
      this.data = data;
      this.child = new TrieNode[26];
    }
  }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
