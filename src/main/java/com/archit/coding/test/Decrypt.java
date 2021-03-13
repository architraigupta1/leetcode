package com.archit.coding.test;

public class Decrypt {
  public static void main(String[] args) {
//    String input = "dnotq";
//    System.out.println(decrypt(input));

    System.out.println(myPow(2.0, 5));


  }

  public static double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    double ans = 1;
    double current_product = x;
    for (long i = N; i > 0; i /= 2) {
      if ((i % 2) == 1) {
        ans = ans * current_product;
      }
      current_product = current_product * current_product;
    }
    return ans;
  }

  static String decrypt(String word) {
    // your code goes here
    if (word == null || word.length() == 0) {
      return word;
    }

    int n = word.length();

    int secondStep = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int ascii = word.charAt(i);
      int newAscii = ascii - secondStep;

      while(newAscii < 97) {//ascii value of 'a'
        newAscii += 26;
      }

      sb.append((char) (newAscii));
      secondStep += newAscii;

    }

    return sb.toString();

  }

}
