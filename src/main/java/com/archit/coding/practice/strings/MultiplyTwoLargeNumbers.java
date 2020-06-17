package com.archit.coding.practice.strings;

public class MultiplyTwoLargeNumbers {
  public static void main(String[] args) {
    String str1 = "1235421415454545454545454544";
    String str2 = "1714546546546545454544548544544545";
    String sign = "";
    if (str1.charAt(0) == '-' && str2.charAt(0) == '-') {
      str1 = str1.substring(1);
      str2 = str2.substring(1);
    } else if (str1.charAt(0) == '-' && str2.charAt(0) != '-') {
      sign = "-";
      str1 = str1.substring(1);
    } else if (str1.charAt(0) != '-' && str2.charAt(0) == '-') {
      sign = "-";
      str2 = str2.substring(1);
    }

    System.out.println(sign + multiply(str1, str2));
  }

  private static String multiply(String str1, String str2) {
    int l1 = str1.length();
    int l2 = str2.length();

    int a[] = new int[l1 + l2 + 1];
    int index1 = 0;
    for (int i = l1 - 1; i >= 0; i--) {
      int carry = 0;
      int index2 = 0;
      int n1 = str1.charAt(i) - '0';
      for (int j = l2 - 1; j >= 0; j--) {
        int n2 = str2.charAt(j) - '0';

        int result = n1 * n2 + carry + a[index1 + index2];

        carry = result / 10;
        a[index1 + index2] = result % 10;
        index2++;
      }
      
      if (carry > 0) {
        a[index1 + index2] += carry;
      }
      index1++;
    }

    int i = l1+l2;
    while(i >= 0 && a[i] == 0) {
      i--;
    }

    StringBuilder sb = new StringBuilder();
    for (int j = i; j >= 0; j--) {
      sb.append(a[j]);
    }

    return sb.toString();
  }
}
