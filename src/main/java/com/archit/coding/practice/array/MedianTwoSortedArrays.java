package com.archit.coding.practice.array;

public class MedianTwoSortedArrays {
  public static void main(String[] args) {
    int ar1[] = { 1, 2, 3, 9 };
    int ar2[] = { 5, 6, 8, 10 };
    System.out.println("Median of two sorted arrays : " +
        medianOfTwoArrays(ar1, 0, ar1.length -1, ar2, 0, ar2.length-1));
//    System.out.println("Median of two sorted arrays 2: " +
//        getMedian(ar1, ar1, 0, 0, ar1.length -1, ar2.length-1));
  }

  static int median(
      int[] arr, int start, int end)
  {
    int n = end - start + 1;
    if (n % 2 == 0) {
      return (
          arr[start + (n / 2)]
              + arr[start + (n / 2 - 1)])
          / 2;
    }
    else {
      return arr[start + n / 2];
    }
  }

  static int getMedian(
      int[] a, int[] b, int startA,
      int startB, int endA, int endB)
  {
    //since equal sized arrays, so checking the size of any one is fine.
    //Base case where each array has only 2 elements
    if (endA - startA == 1) {
      return (
          Math.max(a[startA],
              b[startB])
              + Math.min(a[endA], b[endB]))
          / 2;
    }
    /* get the median of
    the first array */
    int m1 = median(a, startA, endA);

        /* get the median of
    the second array */
    int m2 = median(b, startB, endB);

        /* If medians are equal then
    return either m1 or m2 */
    if (m1 == m2) {
      return m1;
    }

        /* if m1 < m2 then median must
    exist in ar1[m1....] and
                ar2[....m2] */
    else if (m1 < m2) {
      return getMedian(
          a, b, (endA + startA + 1) / 2,
          startB, endA,
          (endB + startB + 1) / 2);
    }

        /* if m1 > m2 then median must
    exist in ar1[....m1] and
    ar2[m2...] */
    else {
      return getMedian(
          a, b, startA,
          (endB + startB + 1) / 2,
          (endA + startA + 1) / 2, endB);
    }
  }

  private static int medianOfTwoArrays(int[] ar1, int l1, int r1, int[] ar2, int l2, int r2) {
    int size1 = r1 - l1 + 1;
    if (size1 == 2) {
      return (Math.max(ar1[l1], ar2[l2]) + Math.min(ar1[r1], ar2[r2])) / 2;
    }

    int m1 = median(ar1, l1, r1);
    int m2 = median(ar2, l2, r2);

    if (m1 == m2) {
      return m1;
    }

    if (m1 < m2) {
      return medianOfTwoArrays(ar1, (l1 + r1 + 1)/2, r1, ar2, l2, (l2+r2+1) /2);
    } else {
      return medianOfTwoArrays(ar1, l1, (l1+r1+1)/2, ar2, (l2+r2+1)/2, r2);
    }

  }
}
