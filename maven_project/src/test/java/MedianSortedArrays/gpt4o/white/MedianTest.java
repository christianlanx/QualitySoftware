package MedianSortedArrays.gpt4o.white;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    public void testFindMedianSortedArrays_bothEmptyArrays() {
        Median median = new Median();
        assertThrows(IllegalArgumentException.class, () -> {
            median.findMedianSortedArrays(new int[]{}, new int[]{});
        });
    }

    @Test
    public void testFindMedianSortedArrays_oneEmptyArray() {
        Median median = new Median();
        assertEquals(2.0, median.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{}));
        assertEquals(2.0, median.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3}));
    }

    @Test
    public void testFindMedianSortedArrays_oddTotalLength() {
        Median median = new Median();
        assertEquals(2.0, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    public void testFindMedianSortedArrays_evenTotalLength() {
        Median median = new Median();
        assertEquals(2.5, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    public void testFindMedianSortedArrays_differentlySizedArrays() {
        Median median = new Median();
        assertEquals(3.0, median.findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4}));
    }

    @Test
    public void testFindMedianSortedArrays_negativeNumbers() {
        Median median = new Median();
        assertEquals(-2.0, median.findMedianSortedArrays(new int[]{-3, -2, -1}, new int[]{}));
    }

    @Test
    public void testFindMedianSortedArrays_identicalNumbers() {
        Median median = new Median();
        assertEquals(1.0, median.findMedianSortedArrays(new int[]{1, 1, 1}, new int[]{1, 1}));
    }

    @Test
    public void testFindMedianSortedArrays_largeArrays() {
        Median median = new Median();
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i;
            nums2[i] = i + 1000;
        }
        assertEquals(999.5, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArrays_singleElementArrays() {
        Median median = new Median();
        assertEquals(2.0, median.findMedianSortedArrays(new int[]{1}, new int[]{2, 3}));
        assertEquals(2.5, median.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));
    }
}