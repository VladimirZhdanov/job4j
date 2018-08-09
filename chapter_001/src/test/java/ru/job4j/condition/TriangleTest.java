package ru.job4j.condition;

/**
 * TriangleTest.
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Declare three objects of class Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Declare a object named triangle and put in it objects of points.
        Triangle triangle = new Triangle(a, b, c);
        // Calculation the area of triangle.
        double result = triangle.area();
        // Declare double named expected and give it value of 2d.
        double expected = 2D;
        //To compere the expected and result.
        assertThat(result, closeTo(expected, 0.1));
    }
}