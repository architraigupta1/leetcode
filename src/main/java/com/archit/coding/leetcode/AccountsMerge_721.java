package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AccountsMerge_721 {
  public static void main(String[] args) {
    String [][] data = {
        {"John", "johnsmith@mail.com", "john00@mail.com"},
        {"John", "johnnybravo@mail.com"},
        {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
        {"Mary", "mary@mail.com"}
    };

    Solution s = new Solution();
  }

  static class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      Map<String, String> emailToName = new HashMap();
      Map<String, ArrayList<String>> graph = new HashMap();
      for (List<String> account: accounts) {
        String name = "";
        for (String email: account) {
          if (name == "") {
            name = email;
            continue;
          }
          graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
          graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
          emailToName.put(email, name);
        }
      }

      Set<String> seen = new HashSet();
      List<List<String>> ans = new ArrayList();
      for (String email: graph.keySet()) {
        if (!seen.contains(email)) {
          Stack<String> stack = new Stack();
          List<String> component = new ArrayList();
          seen.add(email);
          stack.push(email);

          while (!stack.empty()) {
            String node = stack.pop();
            component.add(node);
            for (String nei: graph.get(node)) {
              if (!seen.contains(nei)) {
                seen.add(nei);
                stack.push(nei);
              }
            }
          }
          Collections.sort(component);
          component.add(0, emailToName.get(email));
          ans.add(component);
        }
      }
      return ans;
    }
  }
}