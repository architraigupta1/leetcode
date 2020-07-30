package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime_759 {
  public static void main(String[] args) {
    Solution s = new Solution();
//    [[[1,2],[5,6]],[[1,3]],[[4,10]]]
    List<List<Interval>> intervals = new ArrayList<>();
    List<Interval> one = new ArrayList<>();
    one.add(new Interval(1,2));
    one.add(new Interval(5,6));
    List<Interval> two = new ArrayList<>();
    two.add(new Interval(1,3));
    List<Interval> three = new ArrayList<>();
    three.add(new Interval(4,10));
    intervals.add(one);
    intervals.add(two);
    intervals.add(three);
    List<Interval> result = s.employeeFreeTime(intervals);
    System.out.println(result);
  }


// Definition for an Interval.
static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};


  static class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
      //1. Prepare a list of free intervals
      List<List<Interval>> free = getFreeIntervals(schedule);
      List<Interval> merge = merge(free);
      return sanitize(merge);
    }

    private List<Interval> sanitize(List<Interval> merge) {
      List<Interval> result = new ArrayList<>();
      for (int i = 0; i < merge.size(); i++) {
        if(merge.get(i).start == Integer.MIN_VALUE
            || merge.get(i).end == Integer.MAX_VALUE
            || merge.get(i).start == merge.get(i).end) {
          continue;
        }
        result.add(merge.get(i));
      }
      return result;
    }

    private List<Interval> merge(List<List<Interval>> free) {
      int n = free.size();
      int k = 1;

      List<Interval> fInterval = free.get(0);
      List<Interval> result = new ArrayList<>();
      while(k < n) {
        int i = 0;
        int j = 0;

        result = new ArrayList<>();
        List<Interval> sInterval = free.get(k);
        int first = fInterval.size();
        int second = sInterval.size();

        while(i < first && j < second) {
          Interval one = fInterval.get(i);
          Interval two = sInterval.get(j);

          if(one.end >= two.start && one.start <= two.end) {
            Interval overlap = new Interval();
            overlap.start = Math.max(one.start, two.start);
            overlap.end = Math.min(one.end, two.end);
            result.add(overlap);
          }

          if(one.end > two.end) {
            j++;
          } else if (one.end == two.end) {
            i++;
            j++;
          } else {
            i++;
          }
        }
        fInterval = result;
        k++;
      }

      return result;
    }

    private List<List<Interval>> getFreeIntervals(List<List<Interval>> schedule) {
      int n = schedule.size();
      List<List<Interval>> free = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        List<Interval> intervals = schedule.get(i);
        List<Interval> one = new ArrayList<>();
        int min = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
          one.add(new Interval(min, interval.start));
          min = interval.end;
        }
        one.add(new Interval(min, Integer.MAX_VALUE));
        free.add(one);
      }

      return free;
    }
  }

/*
1. Find out the free intervals for each employee
2. Find out the common overlapping interval in free intervals
*/
}

