package com.archit.coding.practice.strings;

import java.util.PriorityQueue;

public class RearrangeCharsForNoRepeatition {
  public static void main(String[] args) {
    String str = "aaaabc";
    PriorityQueue<HeapNode> pq = new PriorityQueue<>((a, b) -> {
      if (b.freq > a.freq) {
        return 1;
      } else if (b.freq <= a.freq) {
        return -1;
      } else {
        return 0;
      }
    });
    int[] count = new int[26];
    for (int i = 0; i < str.length(); i++) {
      int index = str.charAt(i) - 'a';
      count[index] += 1;
    }

    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        HeapNode node = new HeapNode((char)('a' + i), count[i]);
        pq.add(node);
      }
    }

    HeapNode cur = null;
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      HeapNode max = pq.poll();
      sb.append(max.data);
      max.freq -= 1;
      if (cur != null && cur.freq != 0) {
        pq.add(cur);
      }
      cur = max;
    }

    if (str.length() == sb.toString().length()) {
      System.out.println(sb.toString());
    } else {
      System.out.println("Not possible: " + sb.toString());
    }
  }

}

class HeapNode implements Comparable<HeapNode> {
  char data;
  int freq;

  public HeapNode(char data, int freq) {
    this.data = data;
    this.freq = freq;
  }

  @Override
  public int compareTo(HeapNode b) {
    if (b.freq > this.freq) {
      return 1;
    } else if (b.freq <= this.freq) {
      return -1;
    } else {
      return 0;
    }
  }

}