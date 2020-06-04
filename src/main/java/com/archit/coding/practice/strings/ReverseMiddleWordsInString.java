package com.archit.coding.practice.strings;

public class ReverseMiddleWordsInString {
  public static void main(String[] args) {
    String s[] = "i like this program very much".trim().split(" ");
    StringBuilder ans = new StringBuilder(s[0] + " ");

    for (int i = 1; i < s.length -1; i++) {
      ans.append(reverse(s[i]));
    }
    ans.append(s[s.length - 1]);
    System.out.print(ans);
  }

  private static String reverse(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      sb.append(word.charAt(i));
    }
    return sb.reverse().append(" ").toString();
  }
}
