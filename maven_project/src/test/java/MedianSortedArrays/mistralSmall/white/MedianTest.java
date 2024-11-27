package MedianSortedArrays.mistralSmall.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    private final Median median = new Median();

    @Test
    public void testMedianOfTwoSortedArrays() {
        assertArrayEquals(new int[]{4}, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0001);
        assertArrayEquals(new int[]{4, 5}, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4, 5}), 0.0001);
        assertArrayEquals(new int[]{2.5}, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0001);
        assertArrayEquals(new int[]{2.5}, median.findMedianSortedArrays(new int[]{0, 0, 1, 1}, new int[]{1, 2}), 0.0001);
        assertArrayEquals(new int[]{2}, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0001);
        assertArrayEquals(new int[]{5}, median.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}), 0.0001);
        assertArrayEquals(new int[]{6}, median.findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}), 0.0001);
        assertArrayEquals(new int[]{4}, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0001);
    }

    @Test
    public void testEdgeCases() {
        assertArrayEquals(new int[]{5}, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{5, 7}), 0.0001); // One element in one array
        assertArrayEquals(new int[]{2}, median.findMedianSortedArrays(new int[]{1}, new int[]{2, 3}), 0.0001); // One element in one array
        assertArrayEquals(new int[]{2, 3}, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{2, 3, 4}), 0.0001); // Duplicate elements
        assertArrayEquals(new int[]{2}, median.findMedianSortedArrays(new int[]{1}, new int[]{2}), 0.0001); // Empty array
    }
}