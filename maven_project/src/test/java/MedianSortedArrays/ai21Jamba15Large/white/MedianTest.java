package MedianSortedArrays.ai21Jamba15Large.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {

    private Median median = new Median();

    @Test
    public void testMedianWithEvenLengthArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithOddLengthArray() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithOneArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithBothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expected = 0.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithLargeArrays() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        double expected = 4.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithDifferentSizedArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithNegativeNumbers() {
        int[] nums1 = {-1, 3};
        int[] nums2 = {2, 4};
        double expected = 2.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithDuplicates() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 2};
        double expected = 1.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2));
    }
}