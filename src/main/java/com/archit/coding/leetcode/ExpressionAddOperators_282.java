package com.archit.coding.leetcode;

import com.archit.coding.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {
  static List<String> result = new ArrayList<>();
  public static void main(String[] args) {
    Solution s = new Solution();
    s.addOperators("00", 0);
//    s.addOperators("121", 2);
    ArrayUtil.printArray(result.toArray(new String[result.size()]));

  }

  static class Solution {
    long target;
    public List<String> addOperators(String num, int t) {
      if (num == null || num.isEmpty() || num.length() == 0) {
        return result;
      }
      this.target = t;

      recurse(num, new StringBuilder(), num.toCharArray(), target, 0, 0, 0);

      return result;
    }

    private void recurse(String n, StringBuilder sb, char[] num, long target,
                         int index, long calVal, long prev) {
      if(index == num.length) {
        if(target == calVal) {
          result.add(sb.toString());
        }
        return;
      }
      long curNum = 0;
      for(int i = index; i < num.length; i++) {
        if(num[index] == '0' && i != index) {
          break;
        }

        curNum = 10 * curNum + num[i] - '0';
        int l = sb.length();
        if(index == 0) {
          sb.append(curNum);
          recurse(n, sb, num, target, i+1, curNum, curNum);
          sb.setLength(l);
        } else {

          this.recurse(n, sb.append('+').append(curNum), num, target, i+1, calVal + curNum, curNum);
          sb.setLength(l);

          this.recurse(n, sb.append('-').append(curNum), num, target, i+1, calVal - curNum, -curNum);
          sb.setLength(l);

          this.recurse(n, sb.append('*').append(curNum), num, target, i + 1, calVal - prev + prev * curNum, prev * curNum);
          sb.setLength(l);
        }
      }
    }
  }
}
