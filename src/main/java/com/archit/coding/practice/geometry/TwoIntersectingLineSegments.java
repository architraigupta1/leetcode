package com.archit.coding.practice.geometry;

import com.archit.coding.utils.Point;

public class TwoIntersectingLineSegments {
  public static void main(String[] args) {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 2);
    Point q1 = new Point(10, 1);
    Point q2 = new Point(10, 2);

    System.out.println(intersect(p1, p2, q1, q2));

    p1 = new Point(10, 1);
    p2 = new Point(0, 0);
    q1 = new Point(0, 10);
    q2 = new Point(10, 10);

    System.out.println(intersect(p1, p2, q1, q2));

    p1 = new Point(-5, -5);
    p2 = new Point(1, 1);
    q1 = new Point(0, 0);
    q2 = new Point(10, 10);

    System.out.println(intersect(p1, p2, q1, q2));

  }

  /**
   * NOTE: Draw on paper to see
   * Two line segments intersect if and only if one of the conditions below is true
   * 1) Orientation of (p1,p2,q1) and (p1,p2,q2) is different AND
   *    Orientation of (q1,q2,p1) and (q1,q2,p2) is different
   *    OR
   * 2) (p1,p2,q1), (p1,p2,q2), (q1,q2,p1), (q1,q2,p2) are collinear
   *    AND x-projection of (p1,p2) and (q1,q2) intersect
   *    AND y-projection of (p1,p2) and (q1,q2) intersect
   *
   * @return true if two line segments intersect, false otherwise.
   */
  private static boolean intersect(Point p1, Point p2, Point q1, Point q2) {
    int o1 = getOrientation(p1,p2,q1);
    int o2 = getOrientation(p1,p2,q2);
    int o3 = getOrientation(q1,q2,p1);
    int o4 = getOrientation(q1,q2,p2);

    // Case 1
    if (o1 != o2 && o3 != o4) {
      return true;
    }

    // (p1,p2,q1) are collinear and p2 falls on (p1,q1)
    if (o1 == 0 && onLineSegment(p1,p2,q1)) {
      return true;
    }

    // (p1,p2,q2) are collinear and p2 falls on (p1,q2)
    if (o2 == 0 && onLineSegment(p1,p2,q2)) {
      return true;
    }

    // (q1,q2,p1) are collinear and q2 falls on (q1,p1)
    if (o3 == 0 && onLineSegment(q1, q2, p1)) {
      return true;
    }

    // (q1,q2,p2) are collinear and q2 falls on (q1,p2)
    if (o4 == 0 && onLineSegment(q1, q2, p2)) {
      return true;
    }

    return false;
  }

  /**
   * Given three collinear points, returns true if p2 lies on line (p1,p3)
   *
   */
  private static boolean onLineSegment(Point p1, Point p2, Point p3) {
    return p2.x >= Math.min(p1.x, p3.x) && p2.x <= Math.max(p1.x, p3.x)
        && p2.y >= Math.min(p1.y, p3.y) && p2.y <= Math.max(p1.y, p3.y);
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
  private static int getOrientation(Point p1, Point p2, Point p3) {
    int value = (p2.y - p1.y) * (p3.x - p2.x) - (p3.y - p2.y) * (p2.x - p1.x);
    if (value > 0) {
      return 1;
    } else if (value < 0) {
      return -1;
    } else {
      return 0;
    }
  }
}
