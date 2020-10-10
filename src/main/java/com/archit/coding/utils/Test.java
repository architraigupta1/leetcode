package com.archit.coding.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test{
  public static void main(String... args){
    Integer a = 360000;
    Integer b = 360000;
    System.out.println(a==b);
    Map<String, List<Integer>> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    result.addAll(map.values());
  }

}

