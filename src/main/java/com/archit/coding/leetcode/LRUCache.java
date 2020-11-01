package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  public static void main(String[] args) {
    LRUCache1 lru = new LRUCache1(2);
    lru.put(1,1);
    lru.put(2,2);
    System.out.println(lru.get(1));
    lru.put(3,3);
    System.out.println(lru.get(2));
    lru.put(4,4);
    System.out.println(lru.get(1));
    System.out.println(lru.get(3));
    System.out.println(lru.get(4));
  }

  static class LRUCache1 {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache1(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<>(this.capacity);
      this.head = new Node();
      this.tail = new Node();
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      if (this.map.containsKey(key)) {
        Node node = this.map.get(key);
        delete(node);
        add(node);
        return node.value;
      }
      return -1;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = this.map.get(key);
        node.value = value;
        delete(node);
        add(node);
      } else {
        Node node = new Node(key, value);
        this.map.put(key, node);
        if (map.size() <= this.capacity) {
          add(node);
        } else {
          map.remove(tail.prev.key);
          delete(tail.prev);
          add(node);
        }
      }
    }

    private void delete(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void add(Node node) {
      this.head.next.prev = node;
      node.next = this.head.next;
      node.prev = this.head;
      this.head.next = node;
    }
  }

  static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {

    }

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
