package MedianSortedArrays.gpto1Mini.white;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {

    private final Median median = new Median();

    @Test
    public void testBothArraysEmpty() {
        // Depending on implementation, this might return 0.0 or throw an exception.
        // Here, we assume it returns 0.0
        double result = median.findMedianSortedArrays(new int[]{}, new int[]{});
        assertEquals(0.0, result, "Median of two empty arrays should be 0.0");
    }

    @Test
    public void testFirstArrayEmptySecondArrayOdd() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, "Median should be 1.0");
    }

    @Test
    public void testFirstArrayEmptySecondArrayEven() {
        int[] nums1 = {};
        int[] nums2 = {1, 2};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.5, result, "Median should be 1.5");
    }

    @Test
    public void testSecondArrayEmptyFirstArrayOdd() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, "Median should be 2.0");
    }

    @Test
    public void testSecondArrayEmptyFirstArrayEven() {
        int[] nums1 = {2, 3};
        int[] nums2 = {};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result, "Median should be 2.5");
    }

    @Test
    public void testSingleElementInEachArray() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.5, result, "Median should be 1.5");
    }

    @Test
    public void testDifferentLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.0, result, "Median should be 2.0");
    }

    @Test
    public void testOverlappingArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result, "Median should be 2.5");
    }

    @Test
    public void testWithDuplicates() {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(1.0, result, "Median should be 1.0");
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums1 = {-3, -1};
        int[] nums2 = {-2, 0};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(-1.5, result, "Median should be -1.5");
    }

    @Test
    public void testOneArrayAllLessThanOther() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(3.5, result, "Median should be 3.5");
    }

    @Test
    public void testLargeCombinedArray() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(5.5, result, "Median should be 5.5");
    }
}