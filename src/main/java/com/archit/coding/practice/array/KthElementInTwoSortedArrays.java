package com.archit.coding.practice.array;

/*
* 1. Use the merge step of the sorted array to find the k smallest => o(k)
* 2. Make a max heap of size k, insert all elements and keep checking. (m+n)*logk
* 3. Use binary search and check k/2th element in both arrays and keep on dividing => logk
*/
public class KthElementInTwoSortedArrays {
  public static void main(String[] args) {
    int [] a = {2, 5, 10, 12, 13};
    int [] b = {3, 6, 8, 10, 11};
    int k = 8;
    int element = kthElement(a, 0, a.length, b, 0, b.length, k);
    System.out.println(element);
  }

  private static int kthElement(int[] a, int s1, int e1, int[] b, int s2, int e2, int k) {
    //If array1 has no elements, then return kth from array2
    if(s1 == e1) {
      return b[s2 + k - 1];
    }

    //If array2 has no elements, then return kth from array1
    if (s2 == e2) {
      return a[s1 + k - 1];
    }

    //If invalid k, then return -1
    if (k < 1 || k > (e1 - s1 + e2 - s2)) {
      return -1;
    }

    //If k == 1, return the minimum element amongst a and b.
    if (k == 1) {
      return Math.min(a[s1], b[s2]);
    }

    int cur = k/2;

    //if size of array 1 is less than k/2
    if (cur - 1 >= e1-s1) {
      //if last element of array 1 is less than k/2th element of array 2
      //return (k-size1)th element of array 2
      if (a[e1 - 1] < b[ s2 + cur - 1]) {
        return b[s2 + (k - (e1 - s1) - 1)];
      } else {
        //discard first k/2 elements of array 2 and search for (k - k/2)th element
        return kthElement(a, s1, e1, b, s2 + cur, e2, k - cur);
      }
    }

    // if size of array 2 is less than k / 2
    if (cur - 1 >= e2 - s1) {
      //if last element of array 2 is less than k/2th element of array 1
      //return (k - size2)th element of array 1.
      if (b[e2 - 1] < a[s1 + cur - 1]) {
        return a[s1 + k - (e2 - s2) - 1];
      } else {
        //discard the first half of array 1 and search for (k - k/2)th element
        return kthElement(a, s1 + cur, e1, b, s2, e2, k - cur);
      }
      //check which array's k/2 elements are consumed fully and discard that half
    } else {
      if (a[s1 + cur - 1] < b[s2 + cur - 1]) {
        //discard first k/2 elements of array 1 and search for (k-k/2)th element
        return kthElement(a, s1 + cur, e1, b, s2, e2, k - cur);
      } else {
        //discard first k/2 elements of array 2 and search for (k-k/2)th element
        return kthElement(a, s1, e1, b, s2 + cur, e2, k - cur);
      }
    }
  }

}
