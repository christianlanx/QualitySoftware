package MedianSortedArrays.ai21Jamba15Large.white;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {
    
    private Median medianFinder = new Median();

    @Test
    public void testMedianWithEvenNumberOfElements() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double expectedMedian = 2.5;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithOddNumberOfElements() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expectedMedian = 2.5;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithOneArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expectedMedian = 2.0;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithBothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expectedMedian = 0.0;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithLargeArrays() {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13};
        int[] nums2 = {2, 4, 6, 8, 10, 12, 14};
        double expectedMedian = 7.5;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithDifferentSizedArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4, 6, 8};
        double expectedMedian = 4.0;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianWithNegativeNumbers() {
        int[] nums1 = {-1, 3};
        int[] nums2 = {2, 4};
        double expectedMedian = 2.0;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2));
    }
}