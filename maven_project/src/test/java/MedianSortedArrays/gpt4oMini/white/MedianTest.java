package MedianSortedArrays.gpt4oMini.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private final Median median = new Median();

    @Test
    public void testBothArraysEmpty() {
        assertEquals(0.0, median.findMedianSortedArrays(new int[]{}, new int[]{}));
    }

    @Test
    public void testSingleElementInBothArrays() {
        assertEquals(1.0, median.findMedianSortedArrays(new int[]{1}, new int[]{1}));
    }

    @Test
    public void testSingleElementInOneArray() {
        assertEquals(2.0, median.findMedianSortedArrays(new int[]{1}, new int[]{2}));
    }

    @Test
    public void testDifferentLengths() {
        assertEquals(2.5, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    public void testOddTotalLength() {
        assertEquals(3.0, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
    }

    @Test
    public void testEvenTotalLength() {
        assertEquals(2.5, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{4, 5}));
    }

    @Test
    public void testDuplicates() {
        assertEquals(3.0, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 3}));
    }

    @Test
    public void testNegativeAndPositive() {
        assertEquals(-0.5, median.findMedianSortedArrays(new int[]{-3, -1}, new int[]{0, 1, 2}));
    }

    @Test
    public void testAllNegative() {
        assertEquals(-2.0, median.findMedianSortedArrays(new int[]{-5, -3}, new int[]{-2, -1}));
    }

    @Test
    public void testLongArrays() {
        assertEquals(10.5, median.findMedianSortedArrays(new int[]{1, 10, 20, 30}, new int[]{5, 15, 25, 35}));
    }
}