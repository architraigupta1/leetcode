package com.archit.coding.practice.geometry;

import com.archit.coding.utils.Point;

public class PointInsidePolygon {
  public static void main(String[] args) {
    Point polygon[] = {
        new Point(0, 0),
        new Point(10, 0),
        new Point(10, 10),
        new Point(0, 10)
    };

    Point point = new Point(20, 20);
    System.out.println(insidePolgon(polygon, point));

    point = new Point(5, 5);
    System.out.println(insidePolgon(polygon, point));
  }

  private static boolean insidePolgon(Point[] polygon, Point point) {
    int n = polygon.length;

    //there must be atlease 3 vertices to make a polygon
    if (n < 3) {
      return false;
    }

    //find x-max from polygon points
    int xmax = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      xmax = Math.max(xmax, polygon[i].x);
    }

    //make a reference point to draw a horizontal line to find number of intersections with polygon
    Point reference = new Point(xmax + 1, point.y);

    int count = 0;
    int i = 0;
    // Count intersections of the line (point, reference)
    // with sides of polygon
    // pick each edge one by one (p0, p1), (p1,p2) .. (pn, p0)
    do {
      int next = (i + 1) % n;

      //check if lines (pi, pnext) and (point, reference) intersect
      if (intersect(polygon[i], polygon[next], point, reference)) {

        //if the lines intersect, check if point is collinear with edge (pi, pnext)
        if (orientation(polygon[i], point, polygon[next]) == 0) {

          //if the point lies on the segment (pi, pnext) then it is inside the polygon else outside.
          return onSegment(polygon[i], point,
              polygon[next]);
        }
        //increase the intersection count
        count++;
      }
      i = next;
    } while (i != 0);

    // if odd number of intersections then inside the polygon
    return count % 2 != 0;
  }

  private static boolean onSegment(Point p1, Point p2, Point p3) {
    return p2.x >= Math.min(p1.x, p3.x) && p2.x <= Math.max(p1.x, p3.x)
        && p2.y >= Math.min(p1.y, p3.y) && p2.y <= Math.max(p1.y, p3.y);
  }

  private static int orientation(Point p1, Point p2, Point p3) {
    int value = (p2.y - p1.y) * (p3.x - p2.x) - (p3.y - p2.y) * (p2.x - p1.x);
    return value == 0 ? 0 : (value > 0 ? 1 : -1);
  }

  private static boolean intersect(Point p1, Point p2, Point q1, Point q2) {
    int o1 = orientation(p1,p2,q1);
    int o2 = orientation(p1,p2,q2);
    int o3 = orientation(q1,q2,p1);
    int o4 = orientation(q1,q2,p2);

    if (o1 != o2 && o3 != o4) {
      return true;
    }

    if (o1 == 0 && onSegment(p1, p2, q1)) {
      return true;
    }

    if (o2 == 0 && onSegment(p1, p2, q2)) {
      return true;
    }

    if (o3 == 0 && onSegment(q1, q2, p1)) {
      return true;
    }

    if (o4 == 0 && onSegment(q1, q2, p2)) {
      return true;
    }

    return false;

  }
}
