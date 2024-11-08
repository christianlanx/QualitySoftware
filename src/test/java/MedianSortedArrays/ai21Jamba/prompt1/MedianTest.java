package MedianSortedArrays.ai21Jamba.prompt1;
import MedianSortedArrays.Median;

import org.junit.Assert;
import org.junit.Test;

public class MedianTest {

    @Test
    public void testMedianWithEvenLengthArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double expectedMedian = 2.5;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithOddLengthArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expectedMedian = 2.0;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithOneArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        double expectedMedian = 2.0;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithBothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        double expectedMedian = 0.0;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithLargeArrays() {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        double expectedMedian = 4.5;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithNegativeNumbers() {
        int[] nums1 = {-1, 3};
        int[] nums2 = {0, 2};
        double expectedMedian = 1.0;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithDuplicates() {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2, 2, 3, 4};
        double expectedMedian = 2.5;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithDifferentLengths() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2};
        double expectedMedian = 2.5;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithMaxValues() {
        int[] nums1 = {1000000};
        int[] nums2 = {-1000000};
        double expectedMedian = 0.0;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    public void testMedianWithMinValues() {
        int[] nums1 = {-1000000};
        int[] nums2 = {1000000};
        double expectedMedian = 0.0;
        Assert.assertEquals(expectedMedian, Median.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}