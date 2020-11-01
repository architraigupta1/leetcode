package com.archit.coding.leetcode;

public class DecimalToHexaDeimal_405 {
  public static void main(String[] args) {
    int num = -1;
    StringBuilder sb = new StringBuilder();
    char [] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f'};
    while(num != 0) {
      int d = num & 15;
      sb.append(hex[d]);
      num = num >>> 4;
    }

    sb = sb.reverse();
    System.out.println(sb.toString());
  }
}
