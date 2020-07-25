package com.archit.coding.test;

public class StringOps {
  public static void main(String[] args) {
    String s1 = " ";
    System.out.print(s1.isEmpty());
    StringBuilder sb = new StringBuilder();
    sb.append("abc");
    sb.setLength(2);
    String a = "";
    System.out.println(a.length());
  }
}
