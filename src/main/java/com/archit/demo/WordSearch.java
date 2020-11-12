package com.archit.demo;

public class WordSearch {
  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.addWord("pad");
    wordDictionary.addWord("bad");
    wordDictionary.search(".ad");
    wordDictionary.search("b..");
//    ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
  }

  static class WordDictionary {

    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
      this.trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
      this.trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
      return this.trie.match(word);
    }
  }

  static class Trie {
    Node root;

    public Trie() {
      this.root = new Node();
    }

    public void insert(String word) {
      if (word == null || word.isEmpty()) {
        return;
      }

      int n = word.length();
      Node parent = this.root;
      for (int i = 0; i < n; i++) {
        int index = word.charAt(i) - 'a';
        if (parent.children[index] == null) {
          parent.children[index] = new Node();
        }
        parent = parent.children[index];
      }
      parent.isWord = true;
    }

    public boolean match(String word) {
      return match(root, word, 0);
    }

    private boolean match(Node parent, String word, int index) {
      if (index == word.length()) {
        return parent.isWord;
      }

      char ch = word.charAt(index);
      if (ch != '.') {
        if (parent.children[ch - 'a'] == null) {
          return false;
        }
        return match(parent.children[ch - 'a'], word, index + 1);
      } else {
        for (int i = 0; i < 26; i++) {
          if (parent.children[i] != null) {
            boolean result = match(parent.children[i], word, index + 1);
            if (result) {
              return true;
            }
          }
        }
        return false;
      }
    }
  }

  static class Node {
    Node[] children;
    boolean isWord;

    public Node() {
      this.children = new Node[26];
      this.isWord = false;
    }
  }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
