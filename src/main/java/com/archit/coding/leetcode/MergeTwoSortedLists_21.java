package com.archit.coding.leetcode;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 39.8 MB, less than 16.16% of Java online submissions for Merge Two Sorted Lists.
 */

public class MergeTwoSortedLists_21 {
  public static void main(String[] args) {

    Solution solution = new Solution();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;

    ListNode ll1 = new ListNode(1);
    ListNode ll2 = new ListNode(3);
    ListNode ll3 = new ListNode(4);
    ll1.next = ll2;
    ll2.next = ll3;

    ListNode one = l1;
    ListNode two = ll1;
    solution.print(one);
    solution.print(two);
    ListNode merged = solution.mergeTwoLists(one, two);
    solution.print(merged);
  }

  static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }
  static class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      ListNode head;
      ListNode temp;
      if(l1.val <= l2.val) {
        temp = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        temp = new ListNode(l2.val);
        l2 = l2.next;
      }
      head = temp;

      while (l1 != null && l2!= null) {
        ListNode newNode;
        if (l1.val <= l2.val) {
          newNode = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          newNode = new ListNode(l2.val);
          l2 = l2.next;
        }
        temp.next = newNode;
        temp = newNode;
      }

      if (l1 != null) {
        temp.next = l1;
      }

      if (l2 != null) {
        temp.next = l2;
      }
      return head;
    }

    public void print(ListNode listNode) {
      ListNode temp = listNode;
      while(temp != null) {
        System.out.println(temp.val);
        temp = temp.next;
      }
    }
  }
}
