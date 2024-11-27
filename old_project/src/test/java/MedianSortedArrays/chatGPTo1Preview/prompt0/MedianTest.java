package MedianSortedArrays.chatGPTo1Preview.prompt0;

import org.junit.Test;
import static org.junit.Assert.*;
import MedianSortedArrays.Median;
public class MedianTest {

    @Test
    public void testBothArraysEmpty() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {};
        try {
            median.findMedianSortedArrays(nums1, nums2);
            fail("Expected an IllegalArgumentException for both arrays being empty.");
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test
    public void testOneArrayEmpty() {
        Median median = new Median();
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testOneArrayEmptyReversed() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {};
        double expected = 1.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testBothArraysSingleElement() {
        Median median = new Median();
        int[] nums1 = {1};
        int[] nums2 = {2};
        double expected = 1.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testEvenTotalLength() {
        Median median = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testOddTotalLength() {
        Median median = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testArraysWithDifferentSizes() {
        Median median = new Median();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        double expected = 5.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testArraysWithDuplicateElements() {
        Median median = new Median();
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {2, 3, 4};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testArraysWithNegativeNumbers() {
        Median median = new Median();
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, 0, 2};
        double expected = -1.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testArraysWithLargeNumbers() {
        Median median = new Median();
        int[] nums1 = {1000000, 1000001};
        int[] nums2 = {1000002, 1000003};
        double expected = 1000001.5;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testComplexArrays() {
        Median median = new Median();
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 18, 19, 21, 25};
        double expected = 11.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testArraysWithSameElements() {
        Median median = new Median();
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2};
        double expected = 2.0;
        double result = median.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.0);
    }
}