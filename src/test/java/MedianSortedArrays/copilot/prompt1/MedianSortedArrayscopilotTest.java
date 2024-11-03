package MedianSortedArrays.copilot.prompt1;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import MedianSortedArrays.Median;

public class MedianSortedArrayscopilotTest {

    @Test
    public void testFindMedianSortedArrays_Example1() {
        Median solution = new Median();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.0;
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_Example2() {
        Median solution = new Median();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_EmptyNums1() {
        Median solution = new Median();
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1.0;
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_EmptyNums2() {
        Median solution = new Median();
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2.0;
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testFindMedianSortedArrays_BothEmpty() {
        Median solution = new Median();
        int[] nums1 = {};
        int[] nums2 = {};
        double expected = 0.0; // Assuming this case throws an exception or returns some value
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 0.00001);
    }
}
