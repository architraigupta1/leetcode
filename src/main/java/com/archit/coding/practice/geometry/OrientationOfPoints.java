package com.archit.coding.practice.geometry;

import com.archit.coding.utils.Point;

public class OrientationOfPoints {
  public static void main(String[] args) {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(4, 4);
    Point p3 = new Point(1, 2);

    int orientation = findOientation(p1, p2, p3);
    if (orientation > 0) {
      System.out.println("clockwise");
    } else if (orientation < 0) {
      System.out.println("anti clockwise");
    } else {
      System.out.println("collinear");
    }
  }

  /**
   * Calculate slope1 = (p2.y - p1.y) / (p2.x - p1.x)
   * Calculate slope2 = (p3.y - p2.y) / (p3.x - p2.x)
   * if slope1 == slope2 then points are collinear
   * if slope1 > slope2 then points are clockwise
   * if slope1 < slope2 then points are anit clockwise
   * Draw on paper to get more clarity.
   * This reduces to the below formula
  */
  private static int findOientation(Point p1, Point p2, Point p3) {
    int value = (p2.y - p1.y) * (p3.x - p2.x) - (p3.y - p2.y) * (p2.x - p1.x);
    return value;
  }
}
