package com.archit.coding.practice.array;

public class LargetSumSubArrayWithAtleastKNumbers {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, -10, -3};
    int k = 4;
    System.out.println(maxSumWithK(arr, arr.length, k));;
  }

  private static int maxSumWithK(int[] a, int n, int k) {
    int [] maxSum = new int[n];

    //create a maxSum array which hold max sum till index i
    maxSum[0] = a[0];
    int sum_ending_here = a[0];
    for (int i = 1; i < n; i++) {
      sum_ending_here = Math.max(a[i], sum_ending_here + a[i]);
      maxSum[i] = sum_ending_here;
    }

    //find sum of first k elements
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += a[i];
    }

    int result = sum;
    for (int i = k; i < n; i++) {
      //sum of current window of k elements
      sum = sum + a[i] - a[i-k];

      //result holds the maximum k window sum
      result = Math.max(result, sum);

      //if adding elements before current k window increases the result, then add them
      result = Math.max(result, sum + maxSum[i - k]);
    }

    return result;
  }
}
