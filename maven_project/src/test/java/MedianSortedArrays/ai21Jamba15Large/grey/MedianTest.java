package MedianSortedArrays.ai21Jamba15Large.grey;

import MedianSortedArrays.Median;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedianTest {
    private Median medianFinder = new Median();

    @Test
    public void testMedianOfTwoSortedArrays_Example1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expectedMedian = 2.00000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_Example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expectedMedian = 2.50000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_SingleElementArray() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4};
        double expectedMedian = 2.50000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_EqualSizeArrays() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        double expectedMedian = 3.50000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_EmptyArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expectedMedian = 2.00000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_LargeArray() {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8, 10};
        double expectedMedian = 5.50000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_DifferentSizeArrays() {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {8, 9, 10};
        double expectedMedian = 5.00000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_NegativeValues() {
        int[] nums1 = {-1, 1, 3};
        int[] nums2 = {0, 2, 4};
        double expectedMedian = 1.50000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_LargeAndSmallValues() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1000, 1001, 1002};
        double expectedMedian = 3.00000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_DuplicateValues() {
        int[] nums1 = {1, 1, 2, 2, 3};
        int[] nums2 = {1, 1, 2, 3, 3};
        double expectedMedian = 2.00000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_AllNegativeValues() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-4, -2, 0};
        double expectedMedian = -2.00000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianOfTwoSortedArrays_AllPositiveValues() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        double expectedMedian = 3.50000;
        assertEquals(expectedMedian, medianFinder.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}