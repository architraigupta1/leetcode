package com.archit.coding.practice.backtracking;


import java.util.HashMap;
import java.util.Map;

public class WordBoggle {
  static String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE", "GEES", "GES"};
  static Map<String, Boolean> map = new HashMap();
  public static void main(String[] args) {

    char boggle[][] = {
        {'G','I','Z'},
        {'U','E','K'},
        {'Q','S','E'}
    };

    boolean visited[][] = new boolean [boggle.length][boggle[0].length];
    WordBoggle wordBoggle = new WordBoggle();
    Trie trie = wordBoggle.createTrieFromDict(dictionary);
    for (int i = 0; i < boggle.length; i++) {
      for (int j = 0; j < boggle[0].length; j++) {
        int index = boggle[i][j] - 'A';

        if (trie.root.child[index] != null) {
          String s = "" + boggle[i][j];
          visited[i][j] = true;
          searchWord(trie.root.child[index], boggle, visited, s, i, j);
          visited[i][j] = false;
        }
      }
    }

  }

  private static void searchWord(TrieNode root, char[][] boggle,
                                 boolean[][] visited, String s, int row, int col) {
    if (map.containsKey(s)) {
      System.out.print(s + " ");
    }

    int[] rowNums = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colNums = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int i = 0; i < 8; i++) {
      int nextRow = row + rowNums[i];
      int nextCol = col + colNums[i];

      if (isSafe(nextRow, nextCol, visited) && root.child[boggle[nextRow][nextCol] - 'A'] != null) {
        visited[nextRow][nextCol] = true;
        String str = new String(s);
        str += boggle[nextRow][nextCol];
        searchWord(root.child[boggle[nextRow][nextCol] - 'A'], boggle, visited, str, nextRow, nextCol);
        visited[nextRow][nextCol] = false;
      }
    }
  }

  private static boolean isSafe(int row, int col, boolean[][] visited) {
    int rows = visited.length;
    int cols = visited[0].length;

    return row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col];
  }

  private Trie createTrieFromDict(String[] dictionary) {
    Trie trie = new Trie();
    for (int i = 0; i < dictionary.length; i++) {
      trie.insert(dictionary[i]);
      map.put(dictionary[i], true);
    }
    return trie;
  }

  class Trie {

    TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode temp = root;
      for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'A';
        if (temp.child[index] == null) {
          temp.child[index] = new TrieNode(word.charAt(i));
        }
        temp = temp.child[index];
      }
      temp.isWord = true;
    }
  }

  class TrieNode {
    char data;
    boolean isWord;
    TrieNode[] child;

    public TrieNode() {
      this.child = new TrieNode[26];
      this.isWord = false;
    }
    public TrieNode(char data) {
      this.data = data;
      this.child = new TrieNode[26];
      this.isWord = false;
    }
  }
}
