package com.archit.coding.utils;

public class TestMain {
  int a = 10;
  public static void main(String args[]){
    final String s1="job";
    final String s2="seeker";
    String s3=s1.concat(s2);
    String s4="jobseeker";
    System.out.println(s3==s4); // Output
    System.out.println(s3.equals(s4)); // Output
  }
}
