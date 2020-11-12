package com.archit.coding.leetcode;

import com.archit.coding.utils.ArrayUtil;

import java.util.Random;

/**
 * Using reservoir sampling to make sure that each cell has k/rows*cols probability to have a mine
 * If K > rows * cols => k is greater than the cells available than place a mine on all the cells
 * Otherwise, prepare a reservoir that will hold the ids of the cells that will contain a mine.
 * For the reservoir,
 *    - Add first k ids to the reservoir
 *    - For i in (k+1 , rows * cols)
 *      - generate a random number between (1..i)
 *      - If the random  number (r) lies in the range (1..k), replace reservoir[r] = i;
 */
public class RandomlyGenerateMinesOnMNGrid {
  public static void main(String[] args) {
    int rows = 5;
    int cols = 6;
    int k = 7;
    int[][] mine = new int[rows][cols];
    System.out.println("empty mine");
    ArrayUtil.print2DArray(mine);
    addbombs(mine, rows, cols, k);
    System.out.println("mine with " + k +" bombs");
    ArrayUtil.print2DArray(mine);
  }

  private static void addbombs(int[][] mine, int rows, int cols, int k) {
    //if slots are less than k, then place mine everywhere
    if (rows * cols < k) {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          mine[i][j] = 1;
        }
      }
      return;
    }

    Random random = new Random();
    int[] reservoir = new int[k];
    for (int i = 0; i < k; i++) {
      reservoir[i] = i+1;
    }

    for (int i = k; i < rows * cols; i++) {
      int rand = random.nextInt(i) + 1;
      if (rand <= k) {
        reservoir[rand-1] = i+1;
      }
    }

    System.out.println("reservoir");
    ArrayUtil.printArray(reservoir);
    //place bombs at locations in resrvoir
    for (int i = 0; i < k; i++) {
      int id = reservoir[i];
      int row = (id-1) / cols;
      int col = (id-1) % cols;
      mine[row][col] = 1;
    }


  }
}
