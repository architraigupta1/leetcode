package com.archit.demo;

import com.archit.coding.utils.ArrayUtil;

public class Pancake {

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {1,5,4,3,2};
    ArrayUtil.printArray(a);
    ArrayUtil.printArray(Solution.pancakeSort(a));
  }
  static class Solution {

    //o(k)
    public static void flip(int[]a, int k) {
      int n = a.length;

      int left = 0;
      int right = k -1;
      while (left < right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
      }

    }

    public static int[] pancakeSort(int[] a) {
      // your code goes here
      //1,5,4,3,2
      int n = a.length;
      int i = n-1;
      //o(n)
      while (i >= 0) {

        int maxIndex = getMaxIndex(a, 0, i);
        flip(a, maxIndex + 1);
        flip(a,i+1);
        i--;
      }

      return a;

    }

    public static int getMaxIndex(int[] a, int left, int right) {


      int max = a[left];
      int index = left;
      for (int i = left; i <= right; i++) {
        if (max <= a[i]) {
          index = i;
          max = a[i];
        }
      }

      return index;
    }

  }

/*
algo1:

-find max element in o..n
- flip k (k is index pof max elemetn)
- flip whole array

Algo 2:

1. given an array
2. Goal: sort the array

1,5,4,3,2
5,1,4,3,2
2,3,4,1,5
1,4,3,2,5
5,2,3,4,1
2,5,3,4,1


3. Flip(arr, k): reverse first k elements
4. pancake (arr)

1,5,4,3,2 => 1,2,3,4,5
flip(a, 3) => 4,5,1,3,2
5,1,4,3,2
4,1,5,3,2
5,1,4,3,2
1,4,5,3,2
3,5,4,1,2
4,5,3,1,2
5,4,3,1,2
2,1,3,4,5
3,1,2,4,5
2,1,3,4,5
3,1,2,4,5

*/
}
