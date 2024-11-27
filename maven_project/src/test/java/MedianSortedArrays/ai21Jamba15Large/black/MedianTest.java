package MedianSortedArrays.ai21Jamba15Large.black;
import MedianSortedArrays.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class MedianTest {

    private Median medianFinder = new Median();

    @Test
    void testMedianOfTwoSortedArrays_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.00000;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.50000;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_EqualLength() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        double expected = 3.5;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_FirstArrayLonger() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7};
        double expected = 4.0;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_SecondArrayLonger() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5, 6, 7};
        double expected = 4.0;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_EmptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        double expected = 3.0;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_EmptySecondArray() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        double expected = 3.0;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_BothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expected = 0.0;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_LargeInput() {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] nums2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        double expected = 11.0;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void testMedianOfTwoSortedArrays_SingleElementArrays() {
        int[] nums1 = {5};
        int[] nums2 = {10};
        double expected = 7.5;
        Assertions.assertEquals(expected, medianFinder.findMedianSortedArrays(nums1, nums2));
    }
}