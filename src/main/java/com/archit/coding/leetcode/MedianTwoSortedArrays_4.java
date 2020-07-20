package com.archit.coding.leetcode;

public class MedianTwoSortedArrays_4 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int a[] = {1,2,3,4,5,6};
    int b[] = {3};
    System.out.println(s.findMedianSortedArrays(a, b));
  }

  static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      //we want to work using the smaller array to minimize complexity
      if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
      }

      int x = nums1.length;
      int y = nums2.length;

      int low = 0;
      int high = x;

      while(low <= high) {
        int partitionX = low + (high - low) / 2;
        int partitionY = (x + y + 1) / 2 - partitionX;

        int minX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int maxX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

        int minY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
        int maxY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

        if(minX <= maxY && minY <= maxX) {
          if((x+y) % 2 == 0) {
            return ((double)Math.max(minX, minY) + Math.min(maxX, maxY)) / 2.0;
          } else {
            return (double) Math.max(minX, minY);
          }
        } else if (minX > maxY) {
          high = partitionX - 1;
        } else {
          low = partitionX + 1;
        }
      }

      return Integer.MIN_VALUE;
    }
  }

/*
median of array
if odd then l+r/2
if even then (l+r/2 + l+r/2 + 1) / 2

base case:
when 2 elements in each array
min = (a[1], b[0]);
max = ()
while (l1 <= r1 && l2 <= r2)
get m1 and m2
if (m1 == m2) {
    return m1
} else if (m1 < m2) {
l1 = mid1+1
r2 = mid2;
} else {
r1 = mid1;
l2 = mid2+1;

}

*/

/*
median of array
if odd then l+r/2
if even then (l+r/2 + l+r/2 + 1) / 2

base case:
when 2 elements in each array
min = (a[1], b[0]);
max = ()
while (l1 <= r1 && l2 <= r2)
get m1 and m2
if (m1 == m2) {
    return m1
} else if (m1 < m2) {
l1 = mid1+1
r2 = mid2;
} else {
r1 = mid1;
l2 = mid2+1;

}

*/
}
