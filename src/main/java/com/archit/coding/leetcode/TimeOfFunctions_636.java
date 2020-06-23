package com.archit.coding.leetcode;

import com.archit.coding.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TimeOfFunctions_636 {
  public static void main(String[] args) {
    String [] a = {"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
    List<String> logs = Arrays.asList(a);
    Solution s = new Solution();
    int [] b = s.exclusiveTime(2, logs);
    ArrayUtil.printArray(b);

  }

  static class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
      int [] count = new int[n];
      List<Log> logList = new ArrayList();
      for (int i = 0; i < logs.size(); i++) {
        String [] line = logs.get(i).split(":");
        boolean end = line[1].equalsIgnoreCase("start") ? false : true;
        logList.add(new Log(Integer.parseInt(line[0]), end, Integer.parseInt(line[2])));
      }

      Collections.sort(logList, (a, b) ->
          a.time < b.time ? -1 : a.time == b.time ? 0 : 1
      );

//      String [] a = {"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
      Stack<Log> stack = new Stack<>();
      Log prev = logList.get(0);
      stack.push(logList.get(0));
      int i = 1;
      while (i < logList.size()) {
        Log event = logList.get(i);
        if (!event.end) {
          if (!stack.isEmpty()) {
            Log top = stack.peek();
            count[top.id] += event.time - prev.time;
          }
          stack.push(event);
          prev = event;
        } else {
          Log top = stack.peek();
          count[top.id] += event.time - prev.time + 1;
          stack.pop();
          event.time = event.time + 1;
          prev = event;
        }
        i++;
      }

      return count;

    }
  }

  static class Log {
    int id;
    boolean end;
    int time;

    public Log(int id, boolean end, int time) {
      this.id = id;
      this.end = end;
      this.time = time;
    }
  }
}
