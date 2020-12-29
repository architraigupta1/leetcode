package com.archit.coding.leetcode;

public class SmallestDivisorGivenThreshold_1283 {

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {46480,71852,4544,23598,962,66567,66601,90661,30701,30463,
        76184,35590,50634,82516,3847,83498,40938,82092,17753,21195,3748,
        94798,77080,49254,24184,81610,80045,69248,10776,45690,59496,15406,
        38198,47381,13353,93106,71420,14775,99118,6866,62300,57444,3966,
        91603,56289,26752,16439,96836,80050,14948,14487,3034,79113,23445,
        78123,91204,77022,36837,38978,94389,77331,523,42947,25830,55630,45936,
        76823,32614,49959,5111,74080,59558,79203,93414,11356,87885,50858,4490,
        11503,35141,4446,52051,75511,41767,64622,61572,28298,21584,77878,99083,
        47585,75926,84968,12477,86333,55299,99291,47402,82539,19070};
    int t = 549;
    System.out.println(s.smallestDivisor(a, t));
  }

  static class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {

      int max = getMax(nums);
      int left = 1;
      int right = max;
      int pivot = left;

      while(left <= right) {
        int mid = left + (right - left) / 2;
        int sum = getSum(nums, mid);
        if (sum > threshold) { //we need to increase the divisor
          left = mid + 1;
        } else { //sum is less than threshold, try to decrease the divisor
          pivot = mid;
          right = mid - 1;
        }
      }

      return pivot;
        /*
            - Below is the brute force approach where we divide with every
            number and check against threshold. Is times out.
            - Time complexity is o(kn) where k is the divisor.
        int i = 1;
        while(true) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] / i);
                if (nums[j] % i != 0) {
                    sum++;
                }
            }

            if (sum <= threshold) {
                return i;
            }
            i++;
        }
        */
    }

    private static int getMax(int[] nums) {
      int max = nums[0];
      for (int num : nums) {
        if (num > max) {
          max = num;
        }
      }

      return max;
    }

    private static int getSum(int[] nums, int div) {
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += (nums[i] / div);
        if (nums[i] % div != 0) {
          sum++;
        }
      }

      return sum;
    }
  }

/*
- Every number in array will contribute to the sum
- Divisor 1 will give the maximum sum. Every number will contribute
its total value to the sum.
- If we want to decrease the sum, we need to increment the divisor
- For any divisor which is greater than the max element in the array,
we will always get the same sum since every element will contribute value
1 to the sum
- For the divisor equal to the max array element, every element will contribute
value 1 to the sum.
- So now we have a range. Our divisor will be in [1, max(array)]
- We can use binary search to find the smallest divisor
*/
}
