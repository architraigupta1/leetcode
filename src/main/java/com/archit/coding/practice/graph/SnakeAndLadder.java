package com.archit.coding.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
  public static void main(String[] args) {
    int N = 30;
    int moves[] = new int[N];
    for (int i = 0; i < N; i++)
      moves[i] = -1;

    // Ladders
    moves[2] = 21;
    moves[4] = 7;
    moves[10] = 25;
    moves[19] = 28;

    // Snakes
    moves[26] = 0;
    moves[20] = 8;
    moves[16] = 3;
    moves[18] = 6;
    SnakeAndLadder s = new SnakeAndLadder();
    System.out.println("Min Dice throws required is " +
        s.getMinDiceThrows(moves, N));
  }

  private int getMinDiceThrows(int[] moves, int n) {
    boolean[] visited = new boolean[n];
    int src = 0;

    Queue<QNode> q = new LinkedList<>();
    q.add(new QNode(src, 0));
    visited[src] = true;

    while (!q.isEmpty()) {
      QNode cur = q.poll();

      if (cur.cell == n-1) {
        return cur.dist;
      }

      for (int i = cur.cell + 1; i <= cur.cell + 6 && i < n; i++) {
        if (!visited[i]) {
          visited[i] = true;
          QNode next;
          if (moves[i] != -1) {
            next = new QNode(moves[i], cur.dist + 1);
          } else {
            next = new QNode(i, cur.dist + 1);
          }
          q.add(next);
        }
      }
    }
    return Integer.MAX_VALUE;
  }

  class QNode {
    int cell;
    int dist;

    public QNode() {

    }

    public QNode(int cell, int dist) {
      this.cell = cell;
      this.dist = dist;
    }
  }
}
