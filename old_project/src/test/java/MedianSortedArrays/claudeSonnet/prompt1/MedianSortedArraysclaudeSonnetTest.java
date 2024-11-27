package MedianSortedArrays.claudeSonnet.prompt1;


import org.junit.Test;

import MedianSortedArrays.Median;

import static org.junit.Assert.*;

public class MedianSortedArraysclaudeSonnetTest {
    private static final double DELTA = 0.00001;
    private Median solution = new Median();

    @Test
    public void testExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testEmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testEmptySecondArray() {
        int[] nums1 = {1};
        int[] nums2 = {};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testBothArraysSameLength() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        assertEquals(3.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testLargeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i * 2;
            nums2[i] = i * 2 + 1;
        }
        assertEquals(999.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-4, -2, 0};
        assertEquals(-2.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testExtremeBoundaryValues() {
        int[] nums1 = {-1000000};
        int[] nums2 = {1000000};
        assertEquals(0.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testIdenticalArrays() {
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 1, 1};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testDifferentSizedArrays() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8};
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testSingleElementArrays() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(1.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }
}