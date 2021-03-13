package com.archit.coding.leetcode;

public class RestructureQueue_406 {

  public static void main(String[] args) {

  }

  class Solution {
    public int[][] reconstructQueue(int[][] people) {
      if (people == null || people.length == 0) {
        return new int[0][0];
      }

      int n = people.length;
//      Arrays.sort(people, (a, b -> a[0] < b[0] ? -1 :
//          (a[0] == b[0] ?
//              (a[1] < b[1] ? -1 : a[1] == b[1] ? 0 : 1)
//              : 1)
//      ));

      int[][] q = new int[n][2];

      for (int i = 0; i < n; i++) {
        int index = people[i][1];
        if(q[index] == null) {
          q[index] = people[i];
        } else {
          for (int j = index; j < n; j++) {
            if(q[j] == null) {
              q[j] = people[i];
              break;
            }
          }
        }
      }

      return q;
    }
  }

/*
- k = 0 must come first in the array and sorted in asc by height
- all entries must come at index >= k
*/

}
