package com.archit.coding.practice.strings;

import com.archit.coding.utils.ArrayUtil;

public class FormatParanthesis {
  public static void main(String[] args) {
    int n = 3;
    FormatParanthesis f = new FormatParanthesis();
    char ch [] = new char[2*n];
    f.printParan(0, 0, n, ch, 0);
  }

  private void printParan(int lcount, int rcount, int n, char[] ch, int index) {
    if (index == 2*n) {
      ArrayUtil.printCharArray(ch);
      return;
    }

    if (lcount < n) {
      ch[index] = '{';
      printParan(lcount + 1, rcount, n, ch, index + 1);
    }

    if (rcount < lcount) {
      ch[index] = '}';
      printParan(lcount, rcount + 1, n, ch, index + 1);
    }
  }
}
