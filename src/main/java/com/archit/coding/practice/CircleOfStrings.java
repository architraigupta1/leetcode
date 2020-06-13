package com.archit.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class CircleOfStrings {
  public static void main(String[] args) {
    String[] str = {"aab", "bac", "aaa", "cda"};
    boolean[]  visited = new boolean[str.length];
    List<String> circle = new ArrayList<>();
    int index = 0;
    circle.add(str[0]);
    visited[index] = true;
    boolean flag = true;
    while(circle.size() != str.length && flag) {
      char end = circle.get(index).charAt(circle.get(index).length() - 1);
      flag = false;
      for (int i = 1; i < str.length; i++) {
        if (!visited[i] && end == str[i].charAt(0)) {
          visited[i] = true;
          index++;
          circle.add(str[i]);
          flag = true;
          break;
        }
      }
    }

    if (circle.size() == str.length) {
      char begin = circle.get(0).charAt(0);
      char end = circle.get(circle.size() - 1).charAt(circle.get(circle.size() - 1).length() - 1);
      if (begin != end) {
        System.out.print(false);
      } else {
        System.out.print(true);
      }
    } else {
      System.out.print(false);
    }

  }
}
