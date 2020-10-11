package com.archit.coding.practice.dynamicprogramming;

/*
* https://www.geeksforgeeks.org/number-of-ways-to-pair-people/
* Given that there are p people in a party. Each person can either join dance as a single individual
* or as a pair with any other. The task is to find the number of different ways in which p people
* can join the dance.
* */
public class NumberOfWaysToPairGuests {
  public static void main(String[] args) {
    int guests = 5;
    int[] dp = new int[guests + 1];
    dp[0] = 0; // 0 people = 0 ways
    dp[1] = 1; //1 person can only join the party individually
    dp[2] = 2; // Each person can come individually or they can come as a pair [p1,p2], [(p1,p2)]

    for (int i = 3; i <= guests; i++) {
      dp[i] =
          dp[i-1] //guest come individually. So the total possibilities are same as without him
          +
          (i-1) * dp[i-2]; //guest i can pair with all the other i-1 guests. If he/she pairs, then the remaining
      //guests will be i-2 as these two have paired with each other.
    }

    System.out.println(dp[guests]);
  }
}
