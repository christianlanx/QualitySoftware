package MedianSortedArrays.gpto1Mini.white;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    @Test
    void testFindMedianOddTotalLength() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianEvenTotalLength() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianBothArraysHaveDuplicates() {
        Median median = new Median();
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        double expected = 0.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianFirstArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianSecondArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianLargeArrays() {
        Median median = new Median();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        double expected = 5.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianDifferentLengths() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4};
        double expected = 2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

    @Test
    void testFindMedianWithNegativeNumbers() {
        Median median = new Median();
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, 0, 2, 4};
        double expected = -1.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-5);
    }

}