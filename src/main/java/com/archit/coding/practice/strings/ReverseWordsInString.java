package com.archit.coding.practice.strings;

public class ReverseWordsInString {
  public static void main(String[] args) {
    String s[] = "i like this program very much".trim().split(" ");
    StringBuilder ans = new StringBuilder();
    for (int i = s.length - 1; i >= 0; i--) {
      ans.append(s[i]).append(" ");

    }
    System.out.println("Reversed String:");
    System.out.println(ans.toString().trim());
  }
}
