package MedianSortedArrays.claudeSonnet.prompt0;

import org.junit.Test;
import static org.junit.Assert.*;
import MedianSortedArrays.Median;

public class MedianSortedArraysTestClaude35Sonnet {
    private final Median solution = new Median();
    private static final double DELTA = 1e-10; // Delta for double comparison

    @Test
    public void testEvenLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testOddLengthArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testFirstArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testSecondArrayEmpty() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testBothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        assertEquals(0.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testLargeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = {1, 2, 3, 4, 5};
        assertEquals(4.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-2, 0, 2};
        assertEquals(-1.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testDuplicateNumbers() {
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 1, 1};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testExtremeCases() {
        int[] nums1 = {Integer.MIN_VALUE};
        int[] nums2 = {Integer.MAX_VALUE};
        assertEquals(0.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testOverlappingRanges() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testDisjointRanges() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8};
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testArraysWithDifferentSizes() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8};
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }
}