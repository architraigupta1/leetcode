package com.archit.coding.test;

import java.util.Random;

public class Oprations {
  public static void main(String[] args) {
    Random random = new Random();
    System.out.println(random.nextInt(1));
    int x = -122;
    System.out.println(x%10);
    char ch = 'a';
    int num = 0;
    switch (ch) {
      case 'a': System.out.println(1);
        break;
      case 'b': num =2;
      break;
    }
  }
}
