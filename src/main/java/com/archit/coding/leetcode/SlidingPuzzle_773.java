package com.archit.coding.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle_773 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] board = {{3,0,5},{4,2,1}};
    System.out.println(s.slidingPuzzle(board));
  }

  static class Solution {

    public int slidingPuzzle(int[][] board) {
      if (board == null || board.length != 2 || board[0].length !=3) {
        return -1;
      }

      if(isSolved(board)) {
        return 0;
      }

      //locate zero
      int row = 0;
      int col = 0;
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
          if(board[i][j] == 0) {
            row = i;
            col = j;
            break;
          }
        }
      }

      //possible moves
      int[] rowNums = {-1, 0, 1, 0};
      int[] colNums = {0, 1, 0, -1};

      Queue<Node> q = new LinkedList<Node>();
      String key = getKey(board);

      //enqueue first node
      Node root = new Node(board, row, col, 0, key);
      q.add(root);

      Set<String> set = new HashSet<>();
      set.add(key);

      while(!q.isEmpty()) {
        Node node = q.poll();
        if(node.key.equals("123450")) {
          return node.moves;
        }


        for (int i = 0; i < 4; i++) {
          int nextRow = node.row + rowNums[i];
          int nextCol = node.col + colNums[i];

          if(nextRow >= 0 && nextRow < 2 && nextCol >= 0 && nextCol < 3
          ) {
            int[][] newBoard = getClone(node.board);

            //swap 0 and neighbour in the clone board
            swap(newBoard, node.row, node.col, nextRow, nextCol);
            //check if the new board is already processed
            String newKey = getKey(newBoard);
            if(set.contains(newKey)) {
              continue;
            }
            //Add the unprocessed new board to the Q.
            Node nei = new Node(newBoard, nextRow, nextCol,
                node.moves + 1, newKey);

            q.add(nei);
            set.add(newKey);
          }
        }
      }

      return -1;
    }

    //DFS based solution. 5.07% and 121ms
/*
    private void dfs(int[][] board, int row, int col,
                     int moves) {
      if (moves > min) {
        return;
      }
      String key = getKey(board);
      if(key.equals("123450")) {
        min = Math.min(min, moves);
        return;
      }

      if (map.containsKey(key) && moves > map.get(key)) {
        return;
      }

      map.put(key, moves);

      int[] rowNums = {-1, 0, 1, 0};
      int[] colNums = {0, 1, 0, -1};

      for (int i = 0; i < 4; i++) {
        int nextRow = row + rowNums[i];
        int nextCol = col + colNums[i];

        if(nextRow >= 0 && nextRow < 2 && nextCol >= 0 && nextCol < 3
        ) {
          //swap 0 and neighbour
          swap(board, row, col, nextRow, nextCol);
          dfs(board, nextRow, nextCol, moves + 1);

          //unswap to continue exploration with another swap
          swap(board, nextRow, nextCol, row, col);
        }
      }
    }
*/
    private int[][] getClone(int[][] board) {
      int[][] clone = new int[2][3];

      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
          clone[i][j] = board[i][j];
        }
      }

      return clone;
    }

    private String getKey(int[][] board){
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
          sb.append(board[i][j]);
        }
      }

      return sb.toString();
    }

    private void swap(int[][] board, int row, int col, int nextRow, int nextCol) {
      int temp = board[row][col];
      board[row][col] = board[nextRow][nextCol];
      board[nextRow][nextCol] = temp;
    }


    private boolean isSolved(int[][] board) {
      return board[0][0] == 1
          && board[0][1] == 2
          && board[0][2] == 3
          && board[1][0] == 4
          && board[1][1] == 5
          && board[1][2] == 0;
    }
  }

  static class Node {
    int[][] board;
    int row;
    int col;
    int moves;
    String key;

    public Node(int[][] board, int row, int col, int moves, String key) {
      this.board = board;
      this.row = row;
      this.col = col;
      this.moves = moves;
      this.key = key;
    }
  }
}
